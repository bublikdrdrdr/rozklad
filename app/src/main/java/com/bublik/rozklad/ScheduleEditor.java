package com.bublik.rozklad;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ScheduleEditor extends AppCompatActivity {


        TextView currentLabelState; //напис, який показеє, список яких об'єктів ми редгуємо (блок, напис, сторінка)
        ScrollView elementsListScrollView; //скрол для списку елементів
        LinearLayout elementsList; //список елеметнів
        HorizontalScrollView navigatoinBar; //скрол кнопок навігації
        Button editButton, deleteButton, addButton, backButton, nextButton, moveButton; //кнопки навігації
        LinearLayout pageProperties; //редактор 1 сторінки
        EditText editPageName;
        CheckBox checkImageBackgroundPage;
        LinearLayout colorBackgroundLayout;
        LinearLayout imageBackgroundLayout;
        EditText editPageColor;
        Button buttonChoosePageColor;
        EditText editPageImageID;
        Button buttonChoosePageImage;
        Button buttonSavePage, buttonCancelPage;
        ScrollView blockProperties;
        EditText editBlockBackgroundColor;
        Button buttonChooseBlockBackgroundColor;
        EditText editBlockBorderColor;
        Button buttonChooseBlockBorderColor;
        EditText editBlockBorderThickness;
        Button buttonChooseBlockBorderThickness;
        EditText editBlockHeightAdd;
        Button buttonChooseBlockHeightAdd;
        CheckBox checkHighlightBlock;
        LinearLayout onHighlight;
        EditText editHighlightBackgroundColorBlock;
        Button buttonChooseHighlightBackgroundColorBlock;
        EditText editHighlightBorderColorBlock;
        Button buttonChooseHighlightBorderColorBlock;
        EditText editDayNumber;
        Button buttonSaveBlock, buttonCancelBlock;
        ScrollView lineProperties;
        EditText editLineBackgroundColor;
        Button buttonChooseLineBackgroundColor;
        EditText editLineHeightAdd;
        Button buttonChooseLineHeightAdd;
        Button buttonSaveLine, buttonCancelLine;
        ScrollView labelProperties;
        EditText editLabelText;
        EditText editLabelTextColor;
        Button buttonChooseLabelTextColor;
        EditText editLabelBackgroundColor;
        Button buttonChooseLabelBackgroundColor;
        EditText editLabelTextSize;
        Button buttonChooseLabelTextSize;
        CheckBox checkLabelBold;
        RadioButton radioLeftLabel;
        RadioButton radioCenterLabel;
        RadioButton radioRightLabel;
        Button buttonSaveLabel;
        Button buttonCancelLabel;
        LinearLayout movingTool;
        EditText editPreviousPosition;
        EditText editNextPosition;
        Button buttonSaveMoving;
        Button buttonCancelMoving;


    private void createVariables()
    {
        currentLabelState = (TextView) findViewById(R.id.currentStateLabel);
        elementsListScrollView = (ScrollView) findViewById(R.id.elementsListScrollView);
        elementsList = (LinearLayout) findViewById(R.id.elementsList);
        navigatoinBar = (HorizontalScrollView) findViewById(R.id.navigationBar);
        editButton = (Button) findViewById(R.id.editButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        addButton = (Button) findViewById(R.id.addButton);
        backButton = (Button) findViewById(R.id.backButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        moveButton = (Button) findViewById(R.id.moveButton);
        pageProperties = (LinearLayout) findViewById(R.id.pageProperties);
        editPageName = (EditText) findViewById(R.id.editPageName);
        checkImageBackgroundPage = (CheckBox) findViewById(R.id.checkImageBackgroundPage);
        colorBackgroundLayout = (LinearLayout) findViewById(R.id.colorBackgroundLayout);
        imageBackgroundLayout = (LinearLayout) findViewById(R.id.imageBackgroundLayout);
        editPageColor = (EditText) findViewById(R.id.editPageColor);
        buttonChoosePageColor = (Button) findViewById(R.id.buttonChoosePageColor);
        editPageImageID = (EditText) findViewById(R.id.editPageImageID);
        buttonChoosePageImage = (Button) findViewById(R.id.buttonChoosePageImage);
        buttonSavePage = (Button) findViewById(R.id.buttonSavePage);
        buttonCancelPage = (Button) findViewById(R.id.buttonCancelPage);
        blockProperties = (ScrollView) findViewById(R.id.blockProperties);
        editBlockBackgroundColor = (EditText) findViewById(R.id.editBlockBackgroundColor);
        buttonChooseBlockBackgroundColor = (Button) findViewById(R.id.buttonChooseBlockBackgroundColor);
        editBlockBorderColor = (EditText) findViewById(R.id.editBlockBorderColor);
        buttonChooseBlockBorderColor = (Button) findViewById(R.id.buttonChooseBlockBorderColor);
        editBlockBorderThickness = (EditText) findViewById(R.id.editBlockBorderThickness);
        buttonChooseBlockBorderThickness = (Button) findViewById(R.id.buttonChooseBlockBorderThickness);
        editBlockHeightAdd = (EditText) findViewById(R.id.editBlockHeightAdd);
        buttonChooseBlockHeightAdd = (Button) findViewById(R.id.buttonChooseBlockHeightAdd);
        checkHighlightBlock = (CheckBox) findViewById(R.id.checkHighlightBlock);
        onHighlight = (LinearLayout) findViewById(R.id.onHighlight);
        editHighlightBackgroundColorBlock = (EditText) findViewById(R.id.editHighlightBackgroundColorBlock);
        buttonChooseHighlightBackgroundColorBlock = (Button) findViewById(R.id.buttonChooseHighlightBackgroundColorBlock);
        editHighlightBorderColorBlock = (EditText) findViewById(R.id.editHighlightBorderColorBlock);
        buttonChooseHighlightBorderColorBlock = (Button) findViewById(R.id.buttonChooseHighlightBorderColorBlock);
        editDayNumber = (EditText) findViewById(R.id.editDayNumber);
        buttonSaveBlock = (Button) findViewById(R.id.buttonSaveBlock);
        buttonCancelBlock = (Button) findViewById(R.id.buttonCancelBlock);
        lineProperties = (ScrollView) findViewById(R.id.lineProperties);
        editLineBackgroundColor = (EditText) findViewById(R.id.editLineBackgroundColor);
        buttonChooseLineBackgroundColor = (Button) findViewById(R.id.buttonChooseLineBackgroundColor);
        editLineHeightAdd = (EditText) findViewById(R.id.editLineHeightAdd);
        buttonChooseLineHeightAdd = (Button) findViewById(R.id.buttonChooseLineHeightAdd);
        buttonSaveLine = (Button) findViewById(R.id.buttonSaveLine);
        buttonCancelLine = (Button) findViewById(R.id.buttonCancelLine);
        labelProperties = (ScrollView) findViewById(R.id.labelProperties);
        editLabelText = (EditText) findViewById(R.id.editLabelText);
        editLabelTextColor = (EditText) findViewById(R.id.editLabelTextColor);
        buttonChooseLabelTextColor = (Button) findViewById(R.id.buttonChooseLabelTextColor);
        editLabelBackgroundColor = (EditText) findViewById(R.id.editLabelBackgroundColor);
        buttonChooseLabelBackgroundColor = (Button) findViewById(R.id.buttonChooseLabelBackgroundColor);
        editLabelTextSize = (EditText) findViewById(R.id.editLabelTextSize);
        buttonChooseLabelTextSize = (Button) findViewById(R.id.buttonChooseLabelTextSize);
        checkLabelBold = (CheckBox) findViewById(R.id.checkLabelBold);
        radioLeftLabel = (RadioButton) findViewById(R.id.radioLeftLabel);
        radioCenterLabel = (RadioButton) findViewById(R.id.radioCenterLabel);
        radioRightLabel = (RadioButton) findViewById(R.id.radioRightLabel);
        buttonSaveLabel = (Button) findViewById(R.id.buttonSaveLabel);
        buttonCancelLabel = (Button) findViewById(R.id.buttonCancelLabel);
        movingTool = (LinearLayout) findViewById(R.id.movingTool);
        editPreviousPosition = (EditText) findViewById(R.id.editPreviousPosition);
        editNextPosition = (EditText) findViewById(R.id.editNextPosition);
        buttonSaveMoving = (Button) findViewById(R.id.buttonSaveMoving);
        buttonCancelMoving = (Button) findViewById(R.id.buttonCancelMoving);

    }

    private void setOnClickListeners()
    {
        editButton.setOnClickListener(onClickListener);
        deleteButton.setOnClickListener(onClickListener);
        addButton.setOnClickListener(onClickListener);
        backButton.setOnClickListener(onClickListener);
        nextButton.setOnClickListener(onClickListener);
        moveButton.setOnClickListener(onClickListener);
        buttonChoosePageColor.setOnClickListener(onClickListener);
        buttonChoosePageImage.setOnClickListener(onClickListener);
        buttonSavePage.setOnClickListener(onClickListener);
        buttonCancelPage.setOnClickListener(onClickListener);
        buttonChooseBlockBackgroundColor.setOnClickListener(onClickListener);
        buttonChooseBlockBorderColor.setOnClickListener(onClickListener);
        buttonChooseBlockBorderThickness.setOnClickListener(onClickListener);
        buttonChooseBlockHeightAdd.setOnClickListener(onClickListener);
        buttonChooseHighlightBackgroundColorBlock.setOnClickListener(onClickListener);
        buttonChooseHighlightBorderColorBlock.setOnClickListener(onClickListener);
        buttonSaveBlock.setOnClickListener(onClickListener);
        buttonCancelBlock.setOnClickListener(onClickListener);
        buttonChooseLineBackgroundColor.setOnClickListener(onClickListener);
        buttonChooseLineHeightAdd.setOnClickListener(onClickListener);
        buttonSaveLine.setOnClickListener(onClickListener);
        buttonCancelLine.setOnClickListener(onClickListener);
        buttonChooseLabelTextColor.setOnClickListener(onClickListener);
        buttonChooseLabelBackgroundColor.setOnClickListener(onClickListener);
        buttonChooseLabelTextSize.setOnClickListener(onClickListener);
        buttonSaveLabel.setOnClickListener(onClickListener);
        buttonCancelLabel.setOnClickListener(onClickListener);
        buttonSaveMoving.setOnClickListener(onClickListener);
        buttonCancelMoving.setOnClickListener(onClickListener);

        checkImageBackgroundPage.setOnClickListener(onClickListener);

        editPreviousPosition.addTextChangedListener(textWatcherPrev);
        editNextPosition.addTextChangedListener(textWatcherNext);

        checkHighlightBlock.setOnClickListener(onClickListener);
    }

    ListModes listMode;
    UIModes uiMode;
    MyData currentData; //get on create

    public static Context scheduleEditorContext;
    @Override
    public void finish() {
        MainActivity.myData = currentData;
        scheduleEditorContext = null;
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_editor);
        scheduleEditorContext = this;

        currentData = MainActivity.myData;


        createVariables();
        setOnClickListeners();
        setToStart();
        setMode();
    }

    private void setToStart()
    {
        listMode = ListModes.PAGE;
        uiMode = UIModes.NO_ACTION;
    }

    enum ListModes {PAGE, BLOCK, LINE, LABEL}
    enum UIModes {NO_ACTION, MOVE, EDIT}


    private void setMode()
    {
        setCaption();
        invisibleAll();
        switch (uiMode)
        {
            case NO_ACTION:
                navigatoinBar.setVisibility(View.VISIBLE);
                break;
            case MOVE:
                movingTool.setVisibility(View.VISIBLE);
                break;
            case EDIT:
                switch (listMode)
                {
                    case PAGE:
                        pageProperties.setVisibility(View.VISIBLE);
                        fillPageProperties();
                        break;
                    case BLOCK:
                        blockProperties.setVisibility(View.VISIBLE);
                        fillBlockProperties();
                        break;
                    case LINE:
                        lineProperties.setVisibility(View.VISIBLE);
                        fillLineProperties();
                        break;
                    case LABEL:
                        labelProperties.setVisibility(View.VISIBLE);
                        fillLabelProperties();
                        break;
                }
                break;
        }
        loadList();
        highlightListItem(chosenListItem);
    }

    private void fillBlockProperties()
    {
        if (chosenListItem!=-1)
        {
            MyBlock current = currentData.myPages[chPage].myBlocks[chosenListItem];
            editBlockBackgroundColor.setText(colorToString(current.backgroundColor));
            editBlockBorderColor.setText(colorToString(current.borderColor));
            editBlockBorderThickness.setText(Integer.toString(current.borderSize));
            editBlockHeightAdd.setText(Integer.toString(current.heightAdd));
            checkHighlightBlock.setChecked(current.highlightOnDay);
            blockPropertiesDayBlockVisibility(current.highlightOnDay);
            editHighlightBackgroundColorBlock.setText(colorToString(current.highlightColor));
            editHighlightBorderColorBlock.setText(colorToString(current.highlightBorderColor));
            editDayNumber.setText(Integer.toString(current.dayOfWeek));
        }
    }

    private void fillLineProperties()
    {
        if (chosenListItem!=-1)
        {
            MyLine current = currentData.myPages[chPage].myBlocks[chBlock].myLines[chosenListItem];
            editLineBackgroundColor.setText(colorToString(current.backgroundColor));
            editLineHeightAdd.setText(Integer.toString(current.heightAdd));
        }
    }

    private void fillLabelProperties()
    {
        if (chosenListItem!=-1)
        {
            MyLabel current = currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[chosenListItem];
            editLabelText.setText(current.text);
            editLabelTextColor.setText(colorToString(current.color));
            editLabelBackgroundColor.setText(colorToString(current.backgroundColor));
            editLabelTextSize.setText(Float.toString(current.size));
            checkLabelBold.setChecked(current.bold);

            ((RadioGroup)radioLeftLabel.getParent()).clearCheck();
            switch (current.align)
            {
                case -1:
                    radioLeftLabel.setChecked(true);
                    break;
                case 0:
                    radioCenterLabel.setChecked(true);
                    break;
                case 1:
                    radioRightLabel.setChecked(true);
                    break;
            }
        }
    }

    private void fillPageProperties()
    {
        if (chosenListItem!=-1)
        {
            MyPage current = currentData.myPages[chosenListItem];
            pagePropertiesColorBlockVisible(!current.imageBackground);
            checkImageBackgroundPage.setChecked(current.imageBackground);
            if (current.imageBackground)
            {
                editPageImageID.setText(Integer.toString(current.backgroundDrawableId));
            } else
            {
                editPageColor.setText(colorToString(current.backgroundColor));
            }
            editPageName.setText(current.name);
        }
    }

    long lastTime = 0;
    long maxDuration = 1000;
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTime < maxDuration)
        {
            super.onBackPressed();
        } else
        {
            lastTime = System.currentTimeMillis();
            showMessage(Message.CLICK_ONE_MORE_TIME);
        }

    }

    private boolean checkColorFormat(String s)
    {
        //ff220099
        if (s.length()!=8) return false;
        String symbols = "0123456789abcdef";
        s = s.toLowerCase();
        for (int i = 0; i < 8; i++)
        {
            if (symbols.indexOf(s.charAt(i))<0)
            {
                return false;
            }
        }
        return true;
    }

    private boolean checkIdFormat(String s)
    {
        String symbols = "0123456789-";
        for (int i = 0; i < 8; i++)
        {
            if (symbols.indexOf(s.charAt(i))<0)
            {
                return false;
            }
        }
        try
        {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    private boolean checkPageProperties()
    {
        if (!checkImageBackgroundPage.isChecked())
        {
            if (!checkColorFormat(editPageColor.getText().toString()))
            {
                showMessage(Message.BAD_COLOR_FORMAT);
                return false;
            }
        } else
        {
            if (!checkIdFormat(editPageColor.getText().toString()))
            {
                showMessage(Message.BAD_ID_FORMAT);
                return false;
            }
        }
        return true;
    }

    public String colorToString(int color)
    {
        String res = Integer.toHexString(color);
        int l = res.length();
        for (int i = 0; i < 8-l; i++)
        {
            res = "0" + res;
        }
        return res;
    }

    public Integer stringToColor(String s)
    {
        try {
            return (int) Long.parseLong(s, 16);
        } catch (Exception e)
        {
            showMessage(Message.BAD_COLOR_FORMAT);
        }
        return null;
    }

    private void pagePropertiesColorBlockVisible(boolean vis)
    {
        if (vis)
        {
            colorBackgroundLayout.setVisibility(View.VISIBLE);
            imageBackgroundLayout.setVisibility(View.GONE);
        } else {
            colorBackgroundLayout.setVisibility(View.GONE);
            imageBackgroundLayout.setVisibility(View.VISIBLE);
        }
    }

    private void invisibleAll()
    {
        navigatoinBar.setVisibility(View.GONE);
        pageProperties.setVisibility(View.GONE);
        blockProperties.setVisibility(View.GONE);
        lineProperties.setVisibility(View.GONE);
        labelProperties.setVisibility(View.GONE);
        movingTool.setVisibility(View.GONE);
        checkImageBackgroundPage.setChecked(false);
        colorBackgroundLayout.setVisibility(View.VISIBLE);
        imageBackgroundLayout.setVisibility(View.GONE);

    }

    private void clearUserData()
    {
        editBlockBorderColor.setText("");
        editBlockBackgroundColor.setText("");
        editPageImageID.setText("");
        editPageColor.setText("");
        editPageName.setText("");
        editBlockBorderThickness.setText("");
        editBlockHeightAdd.setText("");
        editHighlightBackgroundColorBlock.setText("");
        editHighlightBorderColorBlock.setText("");
        editLineBackgroundColor.setText("");
        editLineHeightAdd.setText("");
        editLabelBackgroundColor.setText("");
        editLabelText.setText("");
        editLabelTextColor.setText("");
        editLabelTextSize.setText("");
    }

    private void setCaption()
    {
        String modeName = "";
        switch (listMode)
        {
            case PAGE:
                modeName = getResources().getString(R.string.currentStateLabelTextPages);
                break;
            case BLOCK:
                modeName = getResources().getString(R.string.currentStateLabelTextBlocks);
                break;
            case LINE:
                modeName = getResources().getString(R.string.currentStateLabelTextLines);
                break;
            case LABEL:
                modeName = getResources().getString(R.string.currentStateLabelTextLabels);
                break;
        }
        currentLabelState.setText(modeName);
    }

    private int chosenListItem = -1;


    //history
    private int chPage = -1;
    private int chBlock = -1;
    private int chLine = -1;


    private void listClick(int index)
    {
        switch (uiMode)
        {
            case NO_ACTION:
                unHighlightListItem(chosenListItem);
                chosenListItem = index;
                highlightListItem(index);

                break;
            case MOVE:
                showMessage(Message.MOVING_MODE_IS_ACTIVE);
                break;
            case EDIT:
                showMessage(Message.EDIT_MODE_IS_ACTIVE);
                break;
        }
    }

    int highlightListItemColor = 0x3700A5FF;
    private void highlightListItem(int index)
    {
        if ((index>=0) && (index<elementsList.getChildCount())) {
            elementsList.getChildAt(index).setBackgroundColor(highlightListItemColor);
        }
    }

    private void unHighlightListItem(int index)
    {
        if ((index>=0) && (index<elementsList.getChildCount()))
        {
            elementsList.getChildAt(index).setBackgroundColor(0x00FFFFFF);
        }
    }

    private void unHighlightAll()
    {
        int count = elementsList.getChildCount();
        for (int i = 0; i < count; i++)
        {
            elementsList.getChildAt(i).setBackgroundColor(0x00FFFFFF);
        }
    }


    private void loadList()
    {
        clearList(); //TODO maybe don't clear all, if it's too same
        int i;
        switch (listMode)
        {
            case PAGE:
                for (i = 0; i < currentData.myPages.length; i++)
                {
                    addItemToList(getString(R.string.item_page) + " " + Integer.toString(i+1) + " \"" +currentData.myPages[i].name+"\"");
                }
                break;
            case BLOCK:
                for (i = 0; i < currentData.myPages[chPage].myBlocks.length; i++)
                {
                    addItemToList(getString(R.string.item_block) + " "+Integer.toString(i+1));
                }
                break;
            case LINE:
                for (i = 0; i < currentData.myPages[chPage].myBlocks[chBlock].myLines.length; i++)
                {
                    addItemToList(getString(R.string.item_line) + " " + Integer.toString(i+1));
                }
                break;
            case LABEL:
                for (i = 0; i < currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels.length; i++)
                {
                    addItemToList(getString(R.string.item_label) + " " + Integer.toString(i+1) + " \"" + currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[i].text + "\"");
                }
                break;
        }
    }

    private int getListElementPadding()
    {
        return MainActivity.dpToPx(10);
    }

    private void addItemToList(String name)
    {
        int llPadding = getListElementPadding();
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        linearLayout.setLayoutParams(llParams);
        linearLayout.setPadding(llPadding, llPadding, 0, llPadding);

        TextView textView = new TextView(this);
        textView.setText(name);
        textView.setLayoutParams(tvParams);
        textView.setTextColor(0xFF000000);
        textView.setTextSize(20);

        linearLayout.addView(textView);

        linearLayout.setOnClickListener(onClickListener);

        elementsList.addView(linearLayout);
    }

    private void clearList()
    {
        elementsList.removeAllViews();
    }

    private void showMessage(Message message)
    {
        boolean timeLong = false;
        String textMessage = "";
        switch (message)
        {
            case WRONG_DAY_OF_WEEK:
                textMessage = getString(R.string.WRONG_DAY_OF_WEEK);
                break;
            case BAD_COLOR_FORMAT:
                textMessage = getString(R.string.BAD_COLOR_FORMAT);
                break;
            case BAD_ID_FORMAT:
                textMessage = getString(R.string.BAD_ID_FORMAT);
                break;
            case ITEM_IS_NOT_CHOSEN:
                textMessage = getString(R.string.ITEM_IS_NOT_CHOSEN);
                break;
            case EDIT_MODE_IS_ACTIVE:
                textMessage = getString(R.string.EDIT_MODE_IS_ACTIVE);
                break;
            case MOVING_MODE_IS_ACTIVE:
                textMessage = getString(R.string.MOVING_MODE_IS_ACTIVE);
                break;
            case LABELS_WILL_BE_SORTED:
                textMessage = getString(R.string.LABELS_WILL_BE_SORTED);
                break;
            case BAD_NUMBER_FORMAT:
                textMessage = getString(R.string.BAD_NUMBER_FORMAT);
                break;
            case LABEL_ALIGN_IS_NOT_CHOSEN:
                textMessage = getString(R.string.LABEL_ALIGN_IS_NOT_CHOSEN);
                break;
            case BAD_TEXT_SIZE_FORMAT:
                textMessage = getString(R.string.BAD_TEXT_SIZE_FORMAT);
                break;
            case CLICK_ONE_MORE_TIME:
                textMessage = getString(R.string.CLICK_ONE_MORE_TIME);
                break;
            case TEST:
                timeLong = false;
                textMessage = "test";
                break;
            default:
                break;
        }
        Toast.makeText(this, textMessage, (timeLong?Toast.LENGTH_LONG:Toast.LENGTH_SHORT)).show();
    }

    private void showMessage(String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    enum Message {
        WRONG_DAY_OF_WEEK,
        TEST,
        BAD_COLOR_FORMAT,
        BAD_ID_FORMAT,
        ITEM_IS_NOT_CHOSEN,
        EDIT_MODE_IS_ACTIVE,
        MOVING_MODE_IS_ACTIVE,
        LABELS_WILL_BE_SORTED,
        BAD_NUMBER_FORMAT,
        LABEL_ALIGN_IS_NOT_CHOSEN,
        BAD_TEXT_SIZE_FORMAT,
        CLICK_ONE_MORE_TIME
    }

    private void setPageColorVisibility()
    {
        pagePropertiesColorBlockVisible(!checkImageBackgroundPage.isChecked());
    }

    private void savePage()
    {
        if (checkPageProperties())
        {
            elementNew = false;
            currentData.myPages[chosenListItem].name = editPageName.getText().toString();
            currentData.myPages[chosenListItem].imageBackground = checkImageBackgroundPage.isChecked();
            if (!checkImageBackgroundPage.isChecked()) {
                currentData.myPages[chosenListItem].backgroundColor = stringToColor(editPageColor.getText().toString());
            } else
            {
                currentData.myPages[chosenListItem].backgroundDrawableId = Integer.parseInt(editPageImageID.getText().toString());
            }
            uiMode = UIModes.NO_ACTION;
            setMode();
        }
    }

    private void cancelPage()
    {
        //TODO: maybe clear all user data
        cancelEdit();
    }

    private void editItem()
    {
        if (chosenListItem>=0) {
            uiMode = UIModes.EDIT;
            setMode();
        } else
        {
            showMessage(Message.ITEM_IS_NOT_CHOSEN);
        }
    }

    private void addItem()
    {
        int i;
        switch (listMode)
        {
            case PAGE:
                MyPage nPage = MyPage.getDefaultPage();
                MyPage[] nPages = new MyPage[currentData.myPages.length+1];
                for (i = 0; i < currentData.myPages.length; i++)
                {
                    nPages[i] = currentData.myPages[i];
                }
                nPages[nPages.length-1] = nPage;
                currentData.myPages = nPages;
                unHighlightListItem(chosenListItem);
                chosenListItem = currentData.myPages.length-1;
                loadList();
                highlightListItem(chosenListItem);
               // scrollListToDown();
                if (currentData.myPages.length == 1) {
                    currentData.activePage = currentData.myPages.length - 1;
                }
                editItem();
                break;
            case BLOCK:
                MyBlock nBlock = MyBlock.getDefaultBlock();
                MyBlock[] nBlocks = new MyBlock[currentData.myPages[chPage].myBlocks.length+1];
                for (i = 0; i < currentData.myPages[chPage].myBlocks.length; i++)
                {
                    nBlocks[i] = currentData.myPages[chPage].myBlocks[i];
                }
                nBlocks[nBlocks.length-1] = nBlock;
                currentData.myPages[chPage].myBlocks = nBlocks;
                unHighlightListItem(chosenListItem);
                chosenListItem = currentData.myPages[chPage].myBlocks.length-1;
                loadList();
                highlightListItem(chosenListItem);
                editItem();
                break;
            case LINE:
                MyLine nLine = MyLine.getDefaultLine();
                MyLine[] nLines = new MyLine[currentData.myPages[chPage].myBlocks[chBlock].myLines.length+1];
                for (i = 0; i < currentData.myPages[chPage].myBlocks[chBlock].myLines.length; i++)
                {
                    nLines[i] = currentData.myPages[chPage].myBlocks[chBlock].myLines[i];
                }
                nLines[nLines.length-1] = nLine;
                currentData.myPages[chPage].myBlocks[chBlock].myLines = nLines;
                unHighlightListItem(chosenListItem);
                chosenListItem = currentData.myPages[chPage].myBlocks[chBlock].myLines.length-1;
                loadList();
                highlightListItem(chosenListItem);
                editItem();
                break;
            case LABEL:
                MyLabel nLabel = MyLabel.getDefaultLabel();
                MyLabel[] nLabels = new MyLabel[currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels.length+1];
                for (i = 0; i < currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels.length; i++)
                {
                    nLabels[i] = currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[i];
                }
                nLabels[nLabels.length-1] = nLabel;
                currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels = nLabels;
                unHighlightListItem(chosenListItem);
                chosenListItem = currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels.length-1;
                loadList();
                highlightListItem(chosenListItem);
                editItem();
                break;
        }
    }

    private void scrollListToDown()
    {
        //TODO: doesn't work
        elementsList.scrollTo(0,Integer.MAX_VALUE);
    }

    private void deleteItem()
    {
        if (chosenListItem>=0)
        {
            switch (listMode)
            {
                case PAGE:
                    if (chosenListItem >= currentData.myPages.length)
                    {
                        showMessage(Message.TEST);
                    } else {

                        MyPage[] npages = new MyPage[currentData.myPages.length - 1];
                        int i;
                        boolean deleted = false;
                        for (i = 0; i < npages.length; i++)
                        {
                            if (chosenListItem == i) deleted = true;

                            if (!deleted)
                            {
                                npages[i] = currentData.myPages[i];
                            } else
                            {
                                npages[i] = currentData.myPages[i+1];
                            }
                        }

                        currentData.myPages = npages;
                    }
                    break;
                case BLOCK:
                    if (chosenListItem >= currentData.myPages[chPage].myBlocks.length)
                    {
                        showMessage(Message.TEST);
                    } else {

                        MyBlock[] nblocks = new MyBlock[currentData.myPages[chPage].myBlocks.length - 1];
                        int i;
                        boolean deleted = false;
                        for (i = 0; i < nblocks.length; i++)
                        {
                            if (chosenListItem == i) deleted = true;

                            if (!deleted)
                            {
                                nblocks[i] = currentData.myPages[chPage].myBlocks[i];
                            } else
                            {
                                nblocks[i] = currentData.myPages[chPage].myBlocks[i+1];
                            }
                        }

                        currentData.myPages[chPage].myBlocks = nblocks;
                    }
                    break;

                case LINE:
                    if (chosenListItem >= currentData.myPages[chPage].myBlocks[chBlock].myLines.length)
                    {
                        showMessage(Message.TEST);
                    } else {

                        MyLine[] nlines = new MyLine[currentData.myPages[chPage].myBlocks[chBlock].myLines.length - 1];
                        int i;
                        boolean deleted = false;
                        for (i = 0; i < nlines.length; i++)
                        {
                            if (chosenListItem == i) deleted = true;

                            if (!deleted)
                            {
                                nlines[i] = currentData.myPages[chPage].myBlocks[chBlock].myLines[i];
                            } else
                            {
                                nlines[i] = currentData.myPages[chPage].myBlocks[chBlock].myLines[i+1];
                            }
                        }

                        currentData.myPages[chPage].myBlocks[chBlock].myLines = nlines;
                    }
                    break;
                case LABEL:
                    if (chosenListItem >= currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels.length)
                    {
                        showMessage(Message.TEST);
                    } else {

                        MyLabel[] nlabels = new MyLabel[currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels.length - 1];
                        int i;
                        boolean deleted = false;
                        for (i = 0; i < nlabels.length; i++)
                        {
                            if (chosenListItem == i) deleted = true;

                            if (!deleted)
                            {
                                nlabels[i] = currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[i];
                            } else
                            {
                                nlabels[i] = currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[i+1];
                            }
                        }

                        currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels = nlabels;
                    }
                    break;
            }
            chosenListItem = -1;
            loadList();
        }
    }

    private void moveItem()
    {
        if (chosenListItem>=0) {
            uiMode = UIModes.MOVE;
            setMode();
            if (listMode==ListModes.LABEL)
            {
                showMessage(Message.LABELS_WILL_BE_SORTED);
            }
        } else
        {
            showMessage(Message.ITEM_IS_NOT_CHOSEN);
        }

    }

    private void cancelMoving() {
        cancelEdit();
    }


    private void saveMoving()
    {
        int nPosition = -1;
        if (editPreviousPosition.getText().toString().equals(""))
        {
            int nP = 0;
            try {
                nP = Integer.parseInt(editNextPosition.getText().toString());
            } catch (Exception e)
            {
                return;
            }
            nP--;
            if ((nP<0) || (nP>=elementsList.getChildCount())) return;
            nPosition = nP;
        } else
        {
            int nP = 0;
            try{
                nP = Integer.parseInt(editPreviousPosition.getText().toString());
            } catch (Exception e)
            {
                return;
            }
            nP--;
            if ((nP<0) || (nP>=elementsList.getChildCount())) return;
            nPosition = nP;
        }

        // nPosition - new position of choosed element
        switch (listMode)
        {
            case PAGE:
                MyPage oldPageFromThisPosition;

                LinkedList<MyPage> list = new LinkedList<>();

                for (int i = 0; i < currentData.myPages.length; i++)
                {
                    list.add(currentData.myPages[i]);
                }

                oldPageFromThisPosition = list.get(chosenListItem);
                list.remove(chosenListItem);
                list.add(nPosition, oldPageFromThisPosition);

                Iterator<MyPage> iterator = list.iterator();
                for (int i = 0; i < currentData.myPages.length; i++)
                {
                    currentData.myPages[i] = iterator.next();
                }
                break;
            case BLOCK:
                MyBlock oldBlockFromThisPosition;

                LinkedList<MyBlock> listB = new LinkedList<>();

                for (int i = 0; i < currentData.myPages[chPage].myBlocks.length; i++)
                {
                    listB.add(currentData.myPages[chPage].myBlocks[i]);
                }

                oldBlockFromThisPosition = listB.get(chosenListItem);
                listB.remove(chosenListItem);
                listB.add(nPosition, oldBlockFromThisPosition);

                Iterator<MyBlock> iteratorB = listB.iterator();
                for (int i = 0; i < currentData.myPages[chPage].myBlocks.length; i++)
                {
                    currentData.myPages[chPage].myBlocks[i] = iteratorB.next();
                }
                break;
            case LINE:
                MyLine oldLineFromThisPosition;

                LinkedList<MyLine> listLI = new LinkedList<>();

                for (int i = 0; i < currentData.myPages[chPage].myBlocks[chBlock].myLines.length; i++)
                {
                    listLI.add(currentData.myPages[chPage].myBlocks[chBlock].myLines[i]);
                }

                oldLineFromThisPosition = listLI.get(chosenListItem);
                listLI.remove(chosenListItem);
                listLI.add(nPosition, oldLineFromThisPosition);

                Iterator<MyLine> iteratorLI = listLI.iterator();
                for (int i = 0; i < currentData.myPages[chPage].myBlocks[chBlock].myLines.length; i++)
                {
                    currentData.myPages[chPage].myBlocks[chBlock].myLines[i] = iteratorLI.next();
                }
                break;

            case LABEL:
                MyLabel oldLabelFromThisPosition;

                LinkedList<MyLabel> listLA = new LinkedList<>();

                for (int i = 0; i < currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels.length; i++)
                {
                    listLA.add(currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[i]);
                }

                oldLabelFromThisPosition = listLA.get(chosenListItem);
                listLA.remove(chosenListItem);
                listLA.add(nPosition, oldLabelFromThisPosition);

                Iterator<MyLabel> iteratorLA = listLA.iterator();
                for (int i = 0; i < currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels.length; i++)
                {
                    currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[i] = iteratorLA.next();
                }

                sortLabels();
                break;
        }
        uiMode = UIModes.NO_ACTION;
        chosenListItem = nPosition;
        setMode();

    }

    private void sortLabels()
    {
        try
        {
            MyLabel[] labelsToSort = currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels;
            LabelComparator labelComparator = new LabelComparator();
            Arrays.sort(labelsToSort,  labelComparator);
        } catch (Exception e)
        {
            return;
        }
    }

    private void nextItem()
    {
        if (chosenListItem==-1)
        {
            showMessage(Message.ITEM_IS_NOT_CHOSEN);
            return;
        }
        switch (listMode)
        {
            case PAGE:
                chPage = chosenListItem;
                chosenListItem = -1;
                listMode = ListModes.BLOCK;
                break;
            case BLOCK:
                chBlock = chosenListItem;
                chosenListItem = -1;
                listMode = ListModes.LINE;
                break;
            case LINE:
                chLine = chosenListItem;
                chosenListItem = -1;
                listMode = ListModes.LABEL;
                break;
            case LABEL://TODO: maybe show message
                return;

        }
        setMode();
    }

    private void backItem()
    {
        switch (listMode)
        {
            case PAGE://TODO: maybe show message
                break;
            case BLOCK:
                chPage = -1;
                chosenListItem = -1;
                listMode = ListModes.PAGE;
                break;
            case LINE:
                chBlock = -1;
                chosenListItem = -1;
                listMode = ListModes.BLOCK;
                break;
            case LABEL:
                chLine = -1;
                chosenListItem = -1;
                listMode = ListModes.LINE;
                break;
        }
        setMode();
    }

    private void saveBlock()
    {
        if (checkBlockProperties())
        {
            elementNew = false;
            currentData.myPages[chPage].myBlocks[chosenListItem].backgroundColor = stringToColor(editBlockBackgroundColor.getText().toString());
            currentData.myPages[chPage].myBlocks[chosenListItem].borderColor = stringToColor(editBlockBorderColor.getText().toString());
            currentData.myPages[chPage].myBlocks[chosenListItem].borderSize = Integer.parseInt(editBlockBorderThickness.getText().toString());
            currentData.myPages[chPage].myBlocks[chosenListItem].heightAdd = Integer.parseInt(editBlockHeightAdd.getText().toString());

            currentData.myPages[chPage].myBlocks[chosenListItem].highlightOnDay = checkHighlightBlock.isChecked();

            if (checkHighlightBlock.isChecked()) {
                currentData.myPages[chPage].myBlocks[chosenListItem].highlightColor = stringToColor(editHighlightBackgroundColorBlock.getText().toString());
                currentData.myPages[chPage].myBlocks[chosenListItem].highlightBorderColor = stringToColor(editHighlightBorderColorBlock.getText().toString());
                currentData.myPages[chPage].myBlocks[chosenListItem].dayOfWeek = Integer.parseInt(editDayNumber.getText().toString());
            }
            uiMode = UIModes.NO_ACTION;
            setMode();
        }
    }

    private void cancelBlock()
    {
        cancelEdit();
    }

    private void saveLine()
    {
        if (checkLineProperties())
        {
            elementNew = false;
            currentData.myPages[chPage].myBlocks[chBlock].myLines[chosenListItem].backgroundColor = stringToColor(editLineBackgroundColor.getText().toString());
            currentData.myPages[chPage].myBlocks[chBlock].myLines[chosenListItem].heightAdd = Integer.parseInt(editLineHeightAdd.getText().toString());
            uiMode = UIModes.NO_ACTION;
            setMode();
        }
    }

    private void cancelLine()
    {
        cancelEdit();
    }

    private boolean checkLineProperties()
    {
        if (!checkColorFormat(editLineBackgroundColor.getText().toString()))
        {
            showMessage(Message.BAD_COLOR_FORMAT);
            return false;
        }
        if (!checkInt(editLineHeightAdd.getText().toString()))
        {
            showMessage(Message.BAD_NUMBER_FORMAT);
            return false;
        }
        return true;
    }

    private boolean checkBlockProperties()
    {
        if (!checkColorFormat(editBlockBackgroundColor.getText().toString()))
        {
            showMessage(Message.BAD_COLOR_FORMAT);
            return false;
        }
        if (!checkColorFormat(editBlockBorderColor.getText().toString()))
        {
            showMessage(Message.BAD_COLOR_FORMAT);
            return false;
        }
        if (!checkInt(editBlockBorderThickness.getText().toString()))
        {
            showMessage(Message.BAD_NUMBER_FORMAT);
            return false;
        }
        if (!checkInt(editBlockHeightAdd.getText().toString()))
        {
            showMessage(Message.BAD_NUMBER_FORMAT);
            return false;
        }
        if (checkHighlightBlock.isChecked())
        {
            if (!checkColorFormat(editHighlightBackgroundColorBlock.getText().toString()))
            {
                showMessage(Message.BAD_COLOR_FORMAT);
                return false;
            }
            if (!checkColorFormat(editHighlightBorderColorBlock.getText().toString()))
            {
                showMessage(Message.BAD_COLOR_FORMAT);
                return false;
            }
            if (!checkDay(editDayNumber.getText().toString()))
            {
                showMessage(Message.WRONG_DAY_OF_WEEK);
                return false;
            }
        }

        return true;
    }

    private boolean checkInt(String s)
    {
        try
        {
            Integer.parseInt(s);
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    private boolean checkFloat(String s)
    {
        try
        {
            Float.parseFloat(s);
        }catch (Exception e)
        {
            return false;
        }
        return true;
    }

    private boolean checkDay(String s)
    {
        int d = -1;
        try
        {
            d = Integer.parseInt(s);
            if ((d < 1) || d > 7)
            {
                return false;
            }
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    private void setBlockDayVisibility()
    {
        blockPropertiesDayBlockVisibility(checkHighlightBlock.isChecked());
    }

    private void blockPropertiesDayBlockVisibility(boolean vis)
    {
        if (vis)
        {
            onHighlight.setVisibility(View.VISIBLE);
        } else
        {
            onHighlight.setVisibility(View.GONE);
        }
    }

    private void cancelEdit()
    {
        if (elementNew) {
            deleteItem(); //TODO: хз
        }
        elementNew = false;
        uiMode = UIModes.NO_ACTION;
        setMode();
    }

    private void saveLabel()
    {
        if (checkLabelProperties())
        {
            elementNew = false;
            currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[chosenListItem].text = editLabelText.getText().toString();
            currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[chosenListItem].color = stringToColor(editLabelTextColor.getText().toString());
            currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[chosenListItem].size = Float.parseFloat(editLabelTextSize.getText().toString());
            currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[chosenListItem].bold = checkLabelBold.isChecked();
            currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[chosenListItem].backgroundColor = stringToColor(editLabelBackgroundColor.getText().toString());
            byte align;
            if (radioLeftLabel.isChecked())
            {
                align = -1;
            } else
            {
                if (radioCenterLabel.isChecked())
                {
                    align= 0;
                } else
                {
                    align = 1;
                }
            }
            currentData.myPages[chPage].myBlocks[chBlock].myLines[chLine].myLabels[chosenListItem].align = align;

            sortLabels();


            uiMode = UIModes.NO_ACTION;
            setMode();
        }
    }

    private void cancelLabel()
    {
        cancelEdit();
    }



    private boolean checkLabelProperties()
    {
        if (!checkColorFormat(editLabelTextColor.getText().toString()))
        {
            showMessage(Message.BAD_COLOR_FORMAT);
            return false;
        }
        if (!checkColorFormat(editLabelBackgroundColor.getText().toString()))
        {
            showMessage(Message.BAD_COLOR_FORMAT);
            return false;
        }
        if (!checkFloat(editLabelTextSize.getText().toString()))
        {
            showMessage(Message.BAD_TEXT_SIZE_FORMAT);
            return false;
        }

        if ( (radioLeftLabel.isChecked() || radioCenterLabel.isChecked() || radioRightLabel.isChecked()) == false)
        {
            showMessage(Message.LABEL_ALIGN_IS_NOT_CHOSEN);
            return false;
        }
        return true;
    }

    boolean elementNew = false;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.buttonSavePage:
                    savePage();
                    break;
                case R.id.checkImageBackgroundPage:
                    setPageColorVisibility();
                    break;
                case R.id.buttonCancelPage:
                    cancelPage();
                    break;
                case R.id.editButton:
                    editItem();
                    break;
                case R.id.addButton:
                    elementNew = true;
                    addItem();
                    break;
                case R.id.deleteButton:
                    deleteItem();
                    break;
                case R.id.moveButton:
                    moveItem();
                    break;
                case R.id.buttonCancelMoving:
                    cancelMoving();
                    break;
                case R.id.buttonSaveMoving:
                    saveMoving();
                    break;
                case R.id.nextButton:
                    nextItem();
                    break;
                case R.id.backButton:
                    backItem();
                    break;
                case R.id.buttonSaveBlock:
                    saveBlock();
                    break;
                case R.id.checkHighlightBlock:
                    setBlockDayVisibility();
                    break;
                case R.id.buttonCancelBlock:
                    cancelBlock();
                    break;
                case R.id.buttonSaveLine:
                    saveLine();
                    break;
                case R.id.buttonCancelLine:
                    cancelLine();
                    break;
                case R.id.buttonSaveLabel:
                    saveLabel();
                    break;
                case R.id.buttonCancelLabel:
                    cancelLabel();
                    break;
                default:
                    int indx = elementsList.indexOfChild(v);
                    if (indx!=-1)
                    {
                        listClick(indx);
                       // Toast.makeText(scheduleEditorContext, "item click " + Integer.toString(indx), Toast.LENGTH_SHORT).show();
                    }
            }
        }
    };


    private void onPositionTextChanged(boolean prev)
    {
        boolean OK = false;
        //TODO last
        if (prev)
        {
            Integer nn = null;
            try
            {
                nn = Integer.parseInt(editPreviousPosition.getText().toString());
                if ((nn<=0) || (nn>=elementsList.getChildCount())) {
                    nn = null;
                }
            } catch (Exception e)
            {
                nn = null;
            }

            if (nn==null)
            {
                editNextPosition.setText("");
            } else
            {
                editNextPosition.setText(Integer.toString(nn+1));
            }
        } else
        {
            Integer nn = null;
            try
            {
                nn = Integer.parseInt(editNextPosition.getText().toString());
                if ((nn<=1) || (nn>elementsList.getChildCount())) nn = null;
            } catch (Exception e)
            {
                nn = null;
            }

            if (nn==null)
            {
                editPreviousPosition.setText("");
            } else
            {
                editPreviousPosition.setText(Integer.toString(nn-1));
            }
        }
    }



    TextWatcher textWatcherPrev = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (editPreviousPosition.isFocused()) onPositionTextChanged(true);
        }
    };

    TextWatcher textWatcherNext = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(editNextPosition.isFocused()) onPositionTextChanged(false);
        }
    };


}