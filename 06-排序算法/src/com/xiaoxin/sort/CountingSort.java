package com.xiaoxin.sort;

/**
 * @Author Lijx
 * @Date 2020/9/17 21:59
 **/
public class CountingSort extends Sort<Integer> {

    @Override
    protected void sort() {
        //找出两个最值
        int max = arr[0];
        int min = arr[0];
        for (Integer element : arr) {
            if (max < element) {
                max = element;
            }
            if (min > element) {
                min = element;
            }
        }
        //存储每个整数出现的次数
        int[] counts = new int[max - min + 1];
        for (Integer element : arr) {
            counts[element - min]++;
        }
        //累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        Integer[] newArray = new Integer[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            newArray[--counts[arr[i] - min]] = arr[i];
        }
        System.arraycopy(newArray,0,arr,0,arr.length);
    }
}
