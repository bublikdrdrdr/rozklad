package com.bublik.rozklad;

import java.util.ArrayList;

/**
 * Created by Bublik on 05-Oct-16.
 */
public class MyData {
    public MyPage[] myPages;
    public int activePage;

    public void fromBytes(byte[] arr) {
        int pagesNumber;
        int i = 0;
        pagesNumber = Settings_v2.ByteConverter.getInt(arr, i);
        i += 4;

        myPages = new MyPage[pagesNumber];
        for (int j = 0; j < pagesNumber; j++) {
            myPages[j] = new MyPage();
            myPages[j].backgroundColor = Settings_v2.ByteConverter.getInt(arr, i);
            i += 4;
            myPages[j].backgroundDrawableId = Settings_v2.ByteConverter.getInt(arr, i);
            i += 4;
            myPages[j].imageBackground = Settings_v2.ByteConverter.getBoolean(arr, i);
            i += 1;

            int nameLength= Settings_v2.ByteConverter.getInt(arr, i);
            i+=4;
            myPages[j].name = Settings_v2.ByteConverter.getString(arr, i,nameLength);
            i+=nameLength;


            int blockNumber = Settings_v2.ByteConverter.getInt(arr, i);
            i += 4;

            myPages[j].myBlocks = new MyBlock[blockNumber];
            for (int p = 0; p < blockNumber; p++) {
                myPages[j].myBlocks[p] = new MyBlock();

                myPages[j].myBlocks[p].backgroundColor = Settings_v2.ByteConverter.getInt(arr, i);
                i += 4;
                myPages[j].myBlocks[p].borderColor = Settings_v2.ByteConverter.getInt(arr, i);
                i += 4;
                myPages[j].myBlocks[p].borderSize = Settings_v2.ByteConverter.getInt(arr, i);
                i += 4;
                myPages[j].myBlocks[p].dayOfWeek = Settings_v2.ByteConverter.getInt(arr, i);
                i += 4;
                myPages[j].myBlocks[p].heightAdd = Settings_v2.ByteConverter.getInt(arr, i);
                i += 4;
                myPages[j].myBlocks[p].highlightBorderColor = Settings_v2.ByteConverter.getInt(arr, i);
                i += 4;
                myPages[j].myBlocks[p].highlightColor = Settings_v2.ByteConverter.getInt(arr, i);
                i += 4;
                myPages[j].myBlocks[p].highlightOnDay = Settings_v2.ByteConverter.getBoolean(arr, i);
                i += 1;

                int lineNumber = Settings_v2.ByteConverter.getInt(arr, i);
                i += 4;

                myPages[j].myBlocks[p].myLines = new MyLine[lineNumber];
                for (int k = 0; k < lineNumber; k++) {
                    myPages[j].myBlocks[p].myLines[k] = new MyLine();
                    myPages[j].myBlocks[p].myLines[k].backgroundColor = Settings_v2.ByteConverter.getInt(arr, i);
                    i += 4;
                    myPages[j].myBlocks[p].myLines[k].heightAdd = (int)Settings_v2.ByteConverter.getInt(arr, i);
                    i += 4;

                    int labelNumber = Settings_v2.ByteConverter.getInt(arr, i);
                    i += 4;

                    myPages[j].myBlocks[p].myLines[k].myLabels = new MyLabel[labelNumber];

                    for (int l = 0; l < labelNumber; l++) {
                        myPages[j].myBlocks[p].myLines[k].myLabels[l] = new MyLabel();
                        myPages[j].myBlocks[p].myLines[k].myLabels[l].backgroundColor = Settings_v2.ByteConverter.getInt(arr, i);
                        i += 4;
                        myPages[j].myBlocks[p].myLines[k].myLabels[l].bold = Settings_v2.ByteConverter.getBoolean(arr, i);
                        i += 1;
                        myPages[j].myBlocks[p].myLines[k].myLabels[l].color = Settings_v2.ByteConverter.getInt(arr, i);
                        i += 4;
                        myPages[j].myBlocks[p].myLines[k].myLabels[l].size = Settings_v2.ByteConverter.getFloat(arr, i);
                        i += 4;
                        myPages[j].myBlocks[p].myLines[k].myLabels[l].align = Settings_v2.ByteConverter.getByte(arr, i);
                        i+=1;

                        int textStringSize = Settings_v2.ByteConverter.getInt(arr, i);
                        i += 4;
                        myPages[j].myBlocks[p].myLines[k].myLabels[l].text = Settings_v2.ByteConverter.getString(arr, i, textStringSize);
                        i += textStringSize;
                    }
                }
            }
        }
    }

    public byte[] toBytes() {
        ArrayList<Byte> list = new ArrayList<>(64);


        addArray(list, Settings_v2.ByteConverter.getArray((int)myPages.length));

        for (int j = 0; j < myPages.length; j++)
        {
            addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].backgroundColor));
            addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].backgroundDrawableId));
            addArray(list, Settings_v2.ByteConverter.getArray((boolean)myPages[j].imageBackground));
            byte[] pageNameArray = Settings_v2.ByteConverter.getArray(myPages[j].name);
            addArray(list, Settings_v2.ByteConverter.getArray((int)pageNameArray.length));
            addArray(list, pageNameArray);
            addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks.length));
            for (int p = 0; p < myPages[j].myBlocks.length; p++)
            {
                addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].backgroundColor));
                addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].borderColor));
                addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].borderSize));
                addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].dayOfWeek));
                addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].heightAdd));
                addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].highlightBorderColor));
                addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].highlightColor));
                addArray(list, Settings_v2.ByteConverter.getArray((boolean)myPages[j].myBlocks[p].highlightOnDay));
                addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].myLines.length));
                for (int k = 0; k < myPages[j].myBlocks[p].myLines.length; k++)
                {
                    addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].myLines[k].backgroundColor));
                    addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].myLines[k].heightAdd));
                    addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].myLines[k].myLabels.length));
                    for (int l = 0; l < myPages[j].myBlocks[p].myLines[k].myLabels.length; l++)
                    {
                        addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].myLines[k].myLabels[l].backgroundColor));
                        addArray(list, Settings_v2.ByteConverter.getArray((boolean)myPages[j].myBlocks[p].myLines[k].myLabels[l].bold));
                        addArray(list, Settings_v2.ByteConverter.getArray((int)myPages[j].myBlocks[p].myLines[k].myLabels[l].color));
                        addArray(list, Settings_v2.ByteConverter.getArray((float)myPages[j].myBlocks[p].myLines[k].myLabels[l].size));
                        addArray(list, Settings_v2.ByteConverter.getArray((byte)myPages[j].myBlocks[p].myLines[k].myLabels[l].align));

                        byte[] textByteArray = Settings_v2.ByteConverter.getArray(myPages[j].myBlocks[p].myLines[k].myLabels[l].text);
                        addArray(list, Settings_v2.ByteConverter.getArray(textByteArray.length));
                        addArray(list, textByteArray);
                    }
                }
            }
        }
        Object[] objs = list.toArray();
        byte[] bbt = toPrimitive(objs);
        return bbt;
        //return toPrimitive((Byte[])(list.toArray()));
    }

    private void addArray(ArrayList<Byte> list, byte[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            list.add(arr[i]);
        }
    }


    private byte[] toPrimitive(final Object[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new byte[0];
        }
        final byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] =((Byte)(array[i])).byteValue();
        }
        return result;
    }


    public static MyData createTestData()
    {
        MyData myData;
        myData = new MyData();
        myData.activePage = 0;
        int n = 50;
        String text = "пиздиньк";
        myData.myPages = new MyPage[1];
        myData.myPages[0] = new MyPage();
        myData.myPages[0].name = text;
        myData.myPages[0].imageBackground = false;
        myData.myPages[0].backgroundColor = 0x110000FF;
        myData.myPages[0].myBlocks = new MyBlock[50];
        for (int i = 0; i < n; i++) {

            myData.myPages[0].myBlocks[i] = new MyBlock();
            myData.myPages[0].myBlocks[i].dayOfWeek = 7;
            myData.myPages[0].myBlocks[i].highlightOnDay = true;
            myData.myPages[0].myBlocks[i].borderSize = 4;
            myData.myPages[0].myBlocks[i].heightAdd = 0;
            myData.myPages[0].myBlocks[i].highlightBorderColor = 0xFFFF0000;
            myData.myPages[0].myBlocks[i].highlightColor = 0x8FFFE5B2;
            myData.myPages[0].myBlocks[i].myLines = new MyLine[1];
            myData.myPages[0].myBlocks[i].myLines[0] = new MyLine();
            myData.myPages[0].myBlocks[i].myLines[0].backgroundColor = 0xAFFFFF00;
            myData.myPages[0].myBlocks[i].myLines[0].myLabels = new MyLabel[1];
            myData.myPages[0].myBlocks[i].myLines[0].myLabels[0] = new MyLabel();
            myData.myPages[0].myBlocks[i].myLines[0].myLabels[0].size = 20;
            myData.myPages[0].myBlocks[i].myLines[0].myLabels[0].text = text;
            myData.myPages[0].myBlocks[i].myLines[0].myLabels[0].color = 0x9F000000;
            myData.myPages[0].myBlocks[i].myLines[0].myLabels[0].bold = false;
            myData.myPages[0].myBlocks[i].myLines[0].myLabels[0].backgroundColor = 0x3F7711AA;
            myData.myPages[0].myBlocks[i].myLines[0].myLabels[0].align = MyLabel.ALIGN_LEFT;
        }
        return myData;
    }
}
