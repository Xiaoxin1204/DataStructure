package com.xiaoxin.sort;


public class BubbleSort extends Sort {

    @Override
    protected void sort() {
        for (int end = arr.length - 1; end > 0; end--) {
            //优化，如果数组本来有序或局部有序，记录上次交换索引，有序部分就不扫描了
            int sortIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sortIndex = begin;
                }
            }
            end = sortIndex;
        }
    }
}
