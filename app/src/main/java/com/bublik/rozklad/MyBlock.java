package com.bublik.rozklad;

/**
 * Created by Bublik on 05-Oct-16.
 */
public class MyBlock {
    public MyLine[] myLines;
    int backgroundColor;
    int borderColor;
    int borderSize;
    int heightAdd;
    int highlightColor;
    int highlightBorderColor;
    boolean highlightOnDay;
    int dayOfWeek;

    public static MyBlock getDefaultBlock()
    {
        MyBlock ret = new MyBlock();
        ret.backgroundColor = 0x00FFFFFF;
        ret.borderColor = 0xFF000000;
        ret.borderSize = 2;
        ret.dayOfWeek = 7;
        ret.heightAdd = 10;
        ret.highlightOnDay = false;
        ret.highlightColor = 0x2000A5FF;
        ret.highlightBorderColor = 0xFFFF7C26;
        ret.myLines = new MyLine[0];
        return ret;
    }
}
