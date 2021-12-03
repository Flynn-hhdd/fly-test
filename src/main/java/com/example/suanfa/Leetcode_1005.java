package com.example.suanfa;

import java.util.Arrays;

public class Leetcode_1005 {
    public static int largestSumAfterKNegations(int[] nums, int k) {

        int sum = 0;
        //第一次排序
        Arrays.sort(nums);
        //负数变正
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp < 0 && k > 0) {
                nums[i] = temp * (-1);
                k--;
            }
            //中间有0直接sum+=结果就可
            if (temp == 0) {
                k = 0;
            }
            sum += nums[i];
        }
        //再排序
        Arrays.sort(nums);
        //k%2==0  两种，一种是k==0 一种是k>0且k为偶数，这时候没有负数
        // 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。
        return  sum - (k % 2 == 0 ? 0 : 2 * nums[0]);
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,6,9,-3,3};
        System.out.println(largestSumAfterKNegations(array, 2));
    }
}
