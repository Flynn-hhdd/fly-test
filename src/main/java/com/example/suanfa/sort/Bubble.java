package com.example.suanfa.sort;

import java.util.Arrays;

public class Bubble {

    /**
     * 第一版
     * @param array
     */
    private static void sort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 第二版
     * @param array
     */
    private static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    /**
     * 第三版优化
     * @param array
     */
    private static void sort2(int[] array){
        boolean flag;
        for(int i = 0;i< array.length-1;i++){
            flag = false;
            for(int j = array.length-1;j>i;j--){
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 7, 3, 8, 5, 2};
        sort2(array);
        System.out.println(Arrays.toString(array));
    }
}
