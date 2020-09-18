package com.xiaoxin.sort;


import com.xiaoxin.tools.Integers;

public class _排序 {
    public static void main(String[] args) {
        Integer[] data = Integers.random(10, 1, 100);
        new CountingSort().sort(data);
        Integers.println(data);

    }
}

