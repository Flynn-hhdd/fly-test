package com.example.suanfa.sort;

import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length-1);
    }

    private static void process(int[] array, int left, int right) {
        if(left == right){
            return;
        }
        int mid = (left + right) /2;
        //优化点
        mid = left+(right-left)>>1;
        process(array, left, mid);
        process(array, mid + 1, right);
        sort(array, left, mid, right);
    }

    private static void sort(int[] array, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            //利用i++ 就很牛逼
            help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }
        while (p1<=mid){
            help[i++] = array[p1++];
        }
        while (p2<=right){
            help[i++] = array[p2++];
        }
        for(i = 0;i<help.length;i++){
            array[left+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 7, 3, 8, 5, 2};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
