package com.xiaoxin.sort;

/**
 * @Author Lijx
 * @Date 2020/7/26 16:39
 **/
public class QuickSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, arr.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        //获取轴点元素的位置
        int mid = pivotIndex(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    private int pivotIndex(int begin, int end) {
        //为了降低最坏情况出现的概率，轴点随机取
        swap(begin, begin + (int) (Math.random() * (end - begin)));
        E pivot = arr[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, arr[end]) < 0) {
                    end--;
                } else {
                    arr[begin++] = arr[end];
                    break;
                }
            }
            while (begin < end) {
                if (cmp(pivot, arr[begin]) > 0) {
                    begin++;
                } else {
                    arr[end--] = arr[begin];
                    break;
                }
            }
        }
        arr[begin] = pivot;
        return begin;
    }
}
