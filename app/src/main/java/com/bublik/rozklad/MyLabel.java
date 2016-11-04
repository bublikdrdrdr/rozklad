package com.bublik.rozklad;

/**
 * Created by Bublik on 05-Oct-16.
 */
public class MyLabel {
    public String text;

    //TODO: add sorting labels by align
    int color;
    float size;
    boolean bold;
    int backgroundColor;
    byte align; // -1 = left, 0 - center, 1 = right

    public static final byte ALIGN_LEFT = -1;
    public static final byte ALIGN_CENTER = 0;
    public static final byte ALIGN_RIGHE = 1;

    public static MyLabel getDefaultLabel()
    {
        MyLabel ret = new MyLabel();
        ret.align = ALIGN_LEFT;
        ret.backgroundColor = 0x00FFFFFF;
        ret.bold = false;
        ret.color = 0xFF000000;
        ret.size = 18;
        ret.text = "text";
        return ret;
    }
}
