package com.bublik.rozklad;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        somethingChanged = false;
        setupListButtons();
    }

    int highlightColor = 0x46AFAFAF;

    @Override
    protected void onResume() {
        super.onResume();
        setAllTransparent();
    }

    private void setAllTransparent()
    {
        for (int i = 0; i < items.length; i++)
        {
            items[i].setBackgroundColor(0x00FFFFFF);
        }
    }

    LinearLayout[] items = new LinearLayout[4];

   private void setupListButtons()
   {

       items[0] = (LinearLayout) findViewById(R.id.listsManager);
       items[1] = (LinearLayout) findViewById(R.id.listEditor);
       items[2] = (LinearLayout) findViewById(R.id.importExport);
       items[3] = (LinearLayout) findViewById(R.id.aboutItem);

       for (int i = 0; i < items.length; i++)
       {
           items[i].setOnClickListener(onClickListener);
           items[i].setOnTouchListener(onTouchListener);
       }

   }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                v.setBackgroundColor(highlightColor);
            }
            if (event.getAction() == MotionEvent.ACTION_UP)
            {
                setAllTransparent();
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE)
            {
                Rect rect = new Rect();
                v.getGlobalVisibleRect(rect);
                if (!rect.contains((int)event.getRawX(), (int)event.getRawY())) setAllTransparent();
            }
            return false;
        }
    };

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.listsManager:
                    openManager();
                    break;
                case R.id.aboutItem:
                    openAbout();
                    break;
                case R.id.importExport:
                    openImport();
                    break;
                case R.id.listEditor:
                    openEditor();
                    break;
            }
        }
    };

    private void openEditor()
    {
        somethingChanged = true;
        Intent intent = new Intent(this, ScheduleEditor.class);
        startActivity(intent);
    }

    private void openManager()
    {
        somethingChanged = true;
        Intent intent = new Intent(this, ListManager.class);
        startActivity(intent);
    }

    private void openImport()
    {
        somethingChanged = true;
        Intent intent = new Intent(this, ImportExport.class);
        startActivity(intent);
    }

    private void openAbout()
    {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    boolean somethingChanged = false;

    @Override
    public void finish() {
       sendResult();
        super.finish();
    }

    private void sendResult()
    {
        Intent answerIntent = new Intent();
        answerIntent.putExtra(MainActivity.settingsActivityKey, somethingChanged);
        setResult(RESULT_OK, answerIntent);
    }


}
