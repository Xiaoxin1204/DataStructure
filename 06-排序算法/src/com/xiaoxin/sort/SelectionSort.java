package com.xiaoxin.sort;


public class SelectionSort extends Sort {
    @Override
    protected void sort() {
        for (int end = arr.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 0; begin <= end; begin++) {
                if (cmp(begin, maxIndex) >= 0) {
                    maxIndex = begin;
                }
            }
            swap(end, maxIndex);
        }
    }


}
