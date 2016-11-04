package com.bublik.rozklad;

/**
 * Created by Bublik on 05-Oct-16.
 */
public class MySettings {

    Settings_v2 settings_v2;
    public MySettings(Settings_v2 settings_v2) {
        this.settings_v2 = settings_v2;
        checkFile();
    }

    private void checkFile()
    {

        if (settings_v2.get(FILE_STRUCTURED_ID)==null)
        {
            makeNewFileStructure();
        } else
        {
            if ((Boolean)settings_v2.get(FILE_STRUCTURED_ID)==false)
            {
                makeNewFileStructure();
            }
        }
    }

    final int FILE_STRUCTURED_ID = 2;
    final int BYTE_ARRAY_ID = 4;
    final int ACTIVE_PAGE_NUMBER_ID = 5;

    private void makeNewFileStructure()
    {
        for (int i = 0; i < 100; i++)
        {
            settings_v2.remove(i);
        }
        settings_v2.set(FILE_STRUCTURED_ID, true);
        settings_v2.set(BYTE_ARRAY_ID, Settings_v2.ByteConverter.getArray((int)0));
        settings_v2.set(ACTIVE_PAGE_NUMBER_ID,(int)-1);
    }

    public MyData checkSettings() {
        byte[] arr = getByteArray();
        if (arr == null)
        {
            return null;
        }
        MyData ret = new MyData();
        ret.fromBytes(arr);
        ret.activePage = (int)settings_v2.get(ACTIVE_PAGE_NUMBER_ID);
        return ret;
    }

    private byte[] getByteArray()
    {
        return (byte[])settings_v2.get(BYTE_ARRAY_ID);
    }

    public void saveNewData(MyData data)
    {
        settings_v2.set(BYTE_ARRAY_ID, data.toBytes());
        settings_v2.set(ACTIVE_PAGE_NUMBER_ID, data.activePage);
        settings_v2.Save();
    }
}
