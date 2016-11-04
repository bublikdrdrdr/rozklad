package com.bublik.rozklad;

/**
 * Created by Bublik on 05-Oct-16.
 */
public class MyPage {
    public MyBlock[] myBlocks;
    int backgroundColor;
    boolean imageBackground;
    int backgroundDrawableId;
    String name;

    public static MyPage getDefaultPage(String name)
    {
        MyPage ret = new MyPage();
        ret.backgroundColor = 0xFFDDDDDD;
        ret.imageBackground = false;
        ret.backgroundDrawableId = 0;
        ret.name = name;
        ret.myBlocks = new MyBlock[0];
        return ret;
    }

    public static MyPage getDefaultPage()
    {
        return getDefaultPage("page");
    }
}
