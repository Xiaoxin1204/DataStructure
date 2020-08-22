package com.xiaoxin.sort;


public class MergeSort<E extends Comparable<E>> extends Sort<E> {

    private E[] leftArray;

    @Override
    protected void sort() {
        leftArray = (E[]) new Comparable[arr.length >> 1];
        sort(0, arr.length);
    }

    public void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;
        if (le - li >= 0) System.arraycopy(arr, begin + li, leftArray, li, le - li);
        //如果左边还没有结束
        while (li < le) {
            if (ri < re && cmp(arr[ri], leftArray[li]) < 0) {
                arr[ai++] = arr[ri++];
            } else {
                arr[ai++] = leftArray[li++];
            }
        }
    }
}
