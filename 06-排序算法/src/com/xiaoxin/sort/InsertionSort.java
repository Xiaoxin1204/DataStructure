package com.xiaoxin.sort;


public class InsertionSort<E extends Comparable<E>> extends Sort<E> {

//
//    @Override
//    protected void sort() {
//        for (int begin = 1; begin < arr.length; begin++) {
//            int cur = begin;
//            while (cur > 0 && cmp(cur, cur - 1) < 0) {
//                swap(cur, cur - 1);
//                cur--;
//            }
//        }
//    }

//    /**
//     * 优化
//     */
//    @Override
//    protected void sort() {
//        for (int begin = 1; begin < arr.length; begin++) {
//            int cur = begin;
//            E v = arr[cur];
//            while (cur > 0 && cmp(v, arr[cur-1]) < 0) {
//                arr[cur] = arr[cur-1];
//                cur--;
//            }
//            arr[cur] = v;
//        }
//    }


    @Override
    protected void sort() {
        for (int i = 1; i < arr.length; i++) {
            insert(i,search(i));
        }
    }

    private void insert(int source, int dest) {
            E v = arr[source];
            for (int i = source; i > dest; i--) {
                arr[i] = arr[i - 1];
            }
            arr[dest] = v;
    }

    /**
     * 利用二分搜索找到index位置元素的插入位置
     * 已经排好序的数组区间为[0,index)
     *
     * @param index
     */
    private int search(int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(arr[index], arr[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
