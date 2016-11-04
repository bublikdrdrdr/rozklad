package com.bublik.rozklad;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Bublik on 05-Oct-16.
 */
public class MyRender {

    AppCompatActivity appCompatActivity;
    LinearLayout linearLayout;
    MyData myData;

    public MyRender(AppCompatActivity appCompatActivity, LinearLayout linearLayout)
    {
        this.linearLayout = linearLayout;
        this.appCompatActivity = appCompatActivity;
    }

    public Integer getBackgroundColor()
    {
        if (myData==null) return null;
        if (myData.activePage<0) return null;
        if (myData.myPages.length <= myData.activePage) return null;
        if (!myData.myPages[myData.activePage].imageBackground)
        {
            return myData.myPages[myData.activePage].backgroundColor;
        } else
        {
            return Color.TRANSPARENT;
        }
    }

    public void showAll()
    {
        if (myData==null) return;
        if ((myData.myPages.length<=myData.activePage) || (myData.activePage<0)) return;
        final MyPage currentPage = myData.myPages[myData.activePage];

        if (currentPage.imageBackground)
        {
            linearLayout.setBackground(appCompatActivity.getDrawable(currentPage.backgroundDrawableId));
        } else
        {
            linearLayout.setBackgroundColor(currentPage.backgroundColor);
        }

        LinearLayout.LayoutParams scrollParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ScrollView scrollView = new ScrollView(appCompatActivity);
        scrollView.setLayoutParams(scrollParams);

        ScrollView.LayoutParams nLinearParams = new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.WRAP_CONTENT);
        LinearLayout nLinearLayout = new LinearLayout(appCompatActivity);
        nLinearLayout.setLayoutParams(nLinearParams);
        linearLayout.addView(scrollView);
        scrollView.addView(nLinearLayout);
        nLinearLayout.setOrientation(LinearLayout.VERTICAL);

        appCompatActivity.setTitle(currentPage.name);

        LinearLayout lastBlock;
        LinearLayout lastLine;
        TextView lastText;
        LinearLayout.LayoutParams lastTextParams;
        Space textSpace = new Space(appCompatActivity);
        LinearLayout.LayoutParams spaceParams = new LinearLayout.LayoutParams(0,0,1f);
        textSpace.setLayoutParams(spaceParams);


        int DAY_NUMBER = getDayNumber();
        LinearLayout.LayoutParams lastBlockParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lastBlockParams.setMargins(0,0,0,0);
        lastBlockParams.gravity = Gravity.CENTER;
        LinearLayout.LayoutParams lastLineParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lastLineParams.setMargins(0,0,0,0);
        lastLineParams.gravity = Gravity.CENTER;

        int dpBlock;
        int pxBlock;
        int dpLine;
        int pxLine;

        for (int i = 0; i < currentPage.myBlocks.length; i++)
        {
            lastBlock = new LinearLayout(appCompatActivity);
            lastBlock.setOrientation(LinearLayout.VERTICAL);
            lastBlock.setLayoutParams(lastBlockParams);
            dpBlock = (int)(currentPage.myBlocks[i].heightAdd/2.);
            pxBlock = MainActivity.dpToPx(dpBlock);
            lastBlock.setPadding(0, pxBlock, 0, pxBlock);
            lastBlock.setVisibility(View.VISIBLE);

            if ((currentPage.myBlocks[i].highlightOnDay)&&(currentPage.myBlocks[i].dayOfWeek==DAY_NUMBER))
            {
                final int finalI = i;
                Drawable drawable = new Drawable() {
                    @Override
                    public void draw(Canvas canvas) {
                        Paint borderPaint = new Paint();
                        borderPaint.setStyle(Paint.Style.STROKE);
                        borderPaint.setColor(currentPage.myBlocks[finalI].highlightBorderColor);
                        borderPaint.setStrokeWidth(MainActivity.dpToPx(currentPage.myBlocks[finalI].borderSize));

                        Paint fillPaint = new Paint();
                        fillPaint.setStyle(Paint.Style.FILL);
                        fillPaint.setColor(currentPage.myBlocks[finalI].highlightColor);

                        Rect rect = new Rect(0,0,canvas.getWidth(), canvas.getHeight());

                        canvas.drawRect(rect, fillPaint);
                        canvas.drawRect(rect, borderPaint);
                    }

                    @Override
                    public void setAlpha(int alpha) {

                    }

                    @Override
                    public void setColorFilter(ColorFilter colorFilter) {

                    }

                    @Override
                    public int getOpacity() {
                        return 0;
                    }
                };
                lastBlock.setBackground(drawable);
                //TODO: fix border rect coordinates
            } else
            {
                final int finalI = i;
                Drawable drawable = new Drawable() {
                    @Override
                    public void draw(Canvas canvas) {
                        Paint borderPaint = new Paint();
                        borderPaint.setStyle(Paint.Style.STROKE);
                        borderPaint.setColor(currentPage.myBlocks[finalI].borderColor);
                        borderPaint.setStrokeWidth(currentPage.myBlocks[finalI].borderSize);

                        Paint fillPaint = new Paint();
                        fillPaint.setStyle(Paint.Style.FILL);
                        fillPaint.setColor(currentPage.myBlocks[finalI].backgroundColor);

                        Rect rect = new Rect(0,0,canvas.getWidth(), canvas.getHeight());

                        canvas.drawRect(rect, fillPaint);
                        canvas.drawRect(rect, borderPaint);
                    }

                    @Override
                    public void setAlpha(int alpha) {

                    }

                    @Override
                    public void setColorFilter(ColorFilter colorFilter) {

                    }

                    @Override
                    public int getOpacity() {
                        return 0;
                    }
                };
                //TODO: here too
                lastBlock.setBackground(drawable);
            }
            nLinearLayout.addView(lastBlock);


            //if not last, add space
            if (i<currentPage.myBlocks.length-1)
            {
                nLinearLayout.addView(getSpaceBetweenBlocks());
            }



            for (int j = 0; j < currentPage.myBlocks[i].myLines.length; j++)
            {
                lastLine = new LinearLayout(appCompatActivity);
                lastLine.setLayoutParams(lastLineParams);
                lastLine.setOrientation(LinearLayout.HORIZONTAL);
                dpLine = (int)(currentPage.myBlocks[i].myLines[j].heightAdd/2.);
                pxLine = MainActivity.dpToPx(dpLine);
                lastLine.setPadding(0, pxLine, 0, pxLine);
                lastLine.setBackgroundColor(currentPage.myBlocks[i].myLines[j].backgroundColor);

                lastBlock.addView(lastLine);

                int lastAlign = -2;//not setted
                boolean hasNext = false;
                int nextAlign = -2;



                for (int k = 0; k < currentPage.myBlocks[i].myLines[j].myLabels.length; k++)
                {
                    lastText = new TextView(appCompatActivity);
                    lastTextParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    lastTextParams.gravity = Gravity.CENTER;
                    if (k<currentPage.myBlocks[i].myLines[j].myLabels.length-1)
                    {
                        hasNext = true;
                        nextAlign = currentPage.myBlocks[i].myLines[j].myLabels[k].align;
                    } else
                    {
                        hasNext = false;
                        nextAlign = -2;
                    }
                    lastText.setText(currentPage.myBlocks[i].myLines[j].myLabels[k].text);
                    lastText.setTextColor(currentPage.myBlocks[i].myLines[j].myLabels[k].color);
                    lastText.setBackgroundColor(currentPage.myBlocks[i].myLines[j].myLabels[k].backgroundColor);
                    lastText.setTextSize(currentPage.myBlocks[i].myLines[j].myLabels[k].size);
                    if (currentPage.myBlocks[i].myLines[j].myLabels[k].bold) {
                        lastText.setTypeface(null, Typeface.BOLD);
                    } else
                    {
                        lastText.setTypeface(null, Typeface.NORMAL);
                    }


                    switch (currentPage.myBlocks[i].myLines[j].myLabels[k].align)
                    {
                        case -1://current: left align
                            switch (lastAlign)
                            {
                                case -2://just add without space
                                    lastLine.addView(lastText);
                                    break;
                                case -1:
                                    lastLine.addView(lastText);
                                    break;
                                default:
                                    //blyat...
                                    System.exit(0);
                                    break;
                            }
                            break;
                        case 0://current: center align
                            switch (lastAlign)
                            {
                                case -2:
                                    lastLine.addView(getWeightSpace());
                                    lastLine.addView(lastText);
                                    if ((nextAlign==-2) || (nextAlign==1))
                                    {
                                        lastLine.addView(getWeightSpace());
                                    }
                                    break;
                                case -1:
                                    lastLine.addView(getWeightSpace());
                                    lastLine.addView(lastText);
                                    if ((nextAlign==-2) || (nextAlign==1))
                                    {
                                        lastLine.addView(getWeightSpace());
                                    }
                                    break;
                                case 0:
                                    lastLine.addView(lastText);
                                    if ((nextAlign==-2) || (nextAlign==1))
                                    {
                                        lastLine.addView(getWeightSpace());
                                    }
                                    break;
                                default:
                                    System.exit(0);
                                    break;
                            }
                            break;
                        case 1://current: right align
                            switch (lastAlign)
                            {
                                case -2:
                                    lastLine.addView(getWeightSpace());
                                    lastLine.addView(lastText);
                                    break;
                                case -1:
                                    lastLine.addView(getWeightSpace());
                                    lastLine.addView(lastText);
                                    break;
                                case 0:
                                    lastLine.addView(lastText);
                                    break;
                                case 1:
                                    lastLine.addView(lastText);
                                    break;
                            }
                            break;
                        default: appCompatActivity.finish();
                            break;
                    }
                    lastAlign = currentPage.myBlocks[i].myLines[j].myLabels[k].align;
                }
            }
        }
    }

    private Space getWeightSpace()
    {
        Space ret = new Space(appCompatActivity);
        LinearLayout.LayoutParams lP = new LinearLayout.LayoutParams(0,0,1f);
        ret.setLayoutParams(lP);
        return ret;
    }

    private Space getSpaceBetweenBlocks()
    {
        Space ret = new Space(appCompatActivity);
        LinearLayout.LayoutParams lP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, MainActivity.dpToPx(10));
        ret.setLayoutParams(lP);
        return ret;
    }

    private int getDayNumber()
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int w = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if (w==0) w = 7;
        return w;
    }
}
