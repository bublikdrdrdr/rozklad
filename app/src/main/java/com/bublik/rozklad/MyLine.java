package com.bublik.rozklad;

/**
 * Created by Bublik on 05-Oct-16.
 */
public class MyLine {
    public MyLabel[] myLabels;
    int backgroundColor;
    int heightAdd;

    public static MyLine getDefaultLine()
    {
        MyLine ret = new MyLine();
        ret.backgroundColor = 0x00FFFFFF;
        ret.heightAdd = 2;
        ret.myLabels = new MyLabel[0];
        return ret;
    }
}
