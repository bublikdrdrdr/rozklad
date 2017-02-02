package com.bublik.rozklad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        createClasses();
        start();
        setUI();
    }

    MySettings mySettings;
    public static Settings_v2 settings_v2;
    public static MyData myData;
    MyRender myRender;
    private void createClasses()
    {
        settings_v2 = new Settings_v2(Settings_v2.createFileName(this));
        mySettings = new MySettings(settings_v2);
        myRender = new MyRender(this, getMainLayout());
    }

    private LinearLayout getMainLayout()
    {
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.mainLayout);
        return linearLayout;
    }

    private void start()
    {
        myData = mySettings.checkSettings();
        if (myData==null) System.exit(0);//pyzdejszn
        myRender.myData = myData;
        myRender.showAll();
        LinearLayout ll = (LinearLayout) findViewById(R.id.layout);
        Integer cl = myRender.getBackgroundColor();
        if (cl!=null) ll.setBackgroundColor(cl);
    }


    Button closeButton;
    Button settingsButton;
    private void setUI()
    {
        closeButton = (Button)findViewById(R.id.closeButton);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        closeButton.setOnClickListener(onClickListener);
        settingsButton.setOnClickListener(onClickListener);
    }

    public final static String settingsActivityKey = "com.bublik.rozklad.RELOAD";
    public final static int settingsActivityIntentNumber = 1;
    private void openSettings()
    {
        Intent intent = new Intent(this, Settings.class);

        startActivityForResult(intent, settingsActivityIntentNumber);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==settingsActivityIntentNumber)
        {
            if (resultCode==RESULT_OK)
            {
                if (data.getBooleanExtra(settingsActivityKey, true))
                {
                    reloadData();
                }
            }
        }
    }

    private void reloadData()
    {
        mySettings.saveNewData(myData);
        removeAllChildsFromMainLayout();
        createClasses();
        start();
       // showMessage(Message.RELAUNCH_APPLICATION); fixed нафіг треба
    }

    private void removeAllChildsFromMainLayout()
    {
        getMainLayout().removeAllViews();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.settingsButton:
                    openSettings();
                    break;
                case R.id.closeButton:
                    finish();
                    break;
            }
        }
    };



    public static int dpToPx(int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    private void showMessage(Message message)
    {
        boolean timeLong = false;
        String textMessage = "";
        switch (message)
        {
            case RELAUNCH_APPLICATION:
                textMessage = getString(R.string.RELAUNCH_APPLICATION);
                break;
            case TEST:
                timeLong = false;
                textMessage = "test";
                break;
            default:
                break;
        }
        Toast.makeText(this, textMessage, (timeLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT)).show();
    }


    enum Message {
        TEST,
        RELAUNCH_APPLICATION
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     //   getMenuInflater().inflate(R.menu.main, menu);
     //   menu.setGroupVisible(R.id.groupVsbl, true);
            menu.add(0, 1, 0, getString(R.string.settings_button)).setIcon(R.drawable.menu_icon).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.getItem(0).setOnMenuItemClickListener(onMenuItemClickListener);
        return true;
    }

    MenuItem.OnMenuItemClickListener onMenuItemClickListener = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            openSettings();
            return true;
        }
    };
}
