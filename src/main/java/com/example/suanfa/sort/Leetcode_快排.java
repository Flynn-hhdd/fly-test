package com.example.suanfa.sort;

import java.util.Arrays;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName QuickSort.java
 * @Description TODO
 * @createTime 2020年03月13日 12:33:00
 */
public class Leetcode_快排 {

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = partition(array, left, right);
        quickSort(array, left, base);
        quickSort(array, base + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int base = array[left];
        int i = left, j = right;
        while (i < j) {
            //找右面第一个比base小的值
            while (array[j] >= base && i < j) {
                j--;
            }
            //找左边第一个比base大的值
            while (array[i] <= base && i < j) {
                i++;
            }
            //交换
            if (i < j) {
                swap(array, i, j);
            }
        }

       swap(array,left,j);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
