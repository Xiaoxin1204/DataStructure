package com.xiaoxin;

public class Main {
    public static void main(String[] args) {
        //0,1,1,2,3,5,8
        System.out.println(fb(4));
    }

    //斐波那契数
    public static int fb(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
