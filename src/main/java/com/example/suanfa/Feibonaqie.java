package com.example.suanfa;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName Feibonaqie.java
 * @Description TODO
 * @createTime 2020年03月17日 10:57:00
 */
public class Feibonaqie {

    public static int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1, pre = 1, temp = 0;
        for (int i = 3; i < n; i++) {
            temp = res;
            res = pre + res;
            pre = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] array = new int[n];

    }
}
