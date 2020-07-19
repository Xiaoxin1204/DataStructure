package com.xiaoxin.sort;


public abstract class Sort<E extends Comparable<E>> {
    protected E[] arr;
    protected int swapCount;
    protected int cmpCount;

    public void sort(E[] arr) {
        if (arr == null || arr.length < 2) return;
        this.arr = arr;
        sort();
    }

    protected abstract void sort();


    protected void swap(int o1, int o2) {
        swapCount++;
        E tmp = arr[o1];
        arr[o1] = arr[o2];
        arr[o2] = tmp;
    }

    protected int cmp(int o1, int o2) {
        cmpCount++;
        return arr[o1].compareTo(arr[o2]);
    }

    protected int cmp(E i1, E i2) {
        cmpCount++;
        return i1.compareTo(i2);
    }
}
