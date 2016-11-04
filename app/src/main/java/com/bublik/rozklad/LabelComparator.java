package com.bublik.rozklad;

import java.util.Comparator;

/**
 * Created by Bublik on 29-Oct-16.
 */
public class LabelComparator implements Comparator<MyLabel> {
    @Override
    public int compare(MyLabel o1, MyLabel o2) {
        if (o1.align==o2.align) return 0;
        if (o1.align < o2.align) return -1; else return 1;
    }
}
