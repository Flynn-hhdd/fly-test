package com.example.suanfa;

import java.util.Arrays;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName QuickSort.java
 * @Description TODO
 * @createTime 2020年03月13日 12:33:00
 */
public class Leetcode_快排 {

    public static void sort1(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort1(array, left, i - 1);
        sort1(array, i + 1, right);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,5,7,3,8,5,2};
        sort1(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
