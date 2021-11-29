package com.example.suanfa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 第 K 个最小的素数分数
 *  给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 */
public class Leetcode_786 {
    /**
     * 解法
     *  暴力解法
     * @param arr
     * @param k
     * @return
     */
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> list = new ArrayList<int[]>();
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                list.add(new int[]{arr[i],arr[j]});
            }
        }
        Collections.sort(list,(a,b)->a[0]*b[1]-a[1]*b[0]);
        return list.get(k-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5};
        kthSmallestPrimeFraction(arr,3);
    }
}
