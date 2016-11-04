package com.bublik.rozklad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ListManager extends AppCompatActivity {

    RadioGroup radioGroup;
    Button saveButton;
    Button cancelButton;
    MyData data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_manager);
        radioGroup = (RadioGroup) findViewById(R.id.managerRadioGroup);
        saveButton = (Button) findViewById(R.id.managerSaveButton);
        cancelButton = (Button) findViewById(R.id.managerCancelButton);
        saveButton.setOnClickListener(onClickListener);
        cancelButton.setOnClickListener(onClickListener);
        data = MainActivity.myData;
        clear();
        render();
    }

    private void clear()
    {
        radioGroup.removeAllViews();
    }

    private void render()
    {
        RadioButton radioButton;
        int checkedIndex = -1;
        for (int i = 0; i < data.myPages.length; i++)
        {
            radioButton = new RadioButton(this);
            radioButton.setText(getString(R.string.item_page) + " " + Integer.toString(i + 1) + " \"" + data.myPages[i].name + "\"");
            radioButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.list_text_size));
            radioButton.setPadding(0,MainActivity.dpToPx(5),0,MainActivity.dpToPx(5));
            radioGroup.addView(radioButton);
            if (i==data.activePage)
            {
                checkedIndex = i;
              //  radioGroup.check(radioGroup.getChildAt(i).getId());
            }
        }
        if (checkedIndex!=-1)
        {
            ((RadioButton)(radioGroup.getChildAt(checkedIndex))).setChecked(true);
        }
    }

    private void cancel()
    {
        finish();
    }

    private void save()
    {
        int idx = getNewIndex();
        if (idx == -1){
            showMessage(Message.CHOOSE_A_PAGE);
            return;
        } else
        {
            MainActivity.myData.activePage = idx;
            finish();
        }
    }



    private int getNewIndex()
    {
        for (int i = 0; i < radioGroup.getChildCount(); i++)
        {
            if (((RadioButton)radioGroup.getChildAt(i)).isChecked())
            {
                return i;
            }
        }
        return -1;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.managerCancelButton:
                    cancel();
                    break;
                case R.id.managerSaveButton:
                    save();
                    break;
            }
        }
    };

    private void showMessage(Message message)
    {
        boolean timeLong = false;
        String textMessage = "";
        switch (message)
        {
            case CHOOSE_A_PAGE:
                textMessage = getString(R.string.CHOOSE_A_PAGE);
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
        CHOOSE_A_PAGE
    }


}
