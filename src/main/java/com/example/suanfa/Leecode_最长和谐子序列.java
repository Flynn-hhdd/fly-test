package com.example.suanfa;

import java.util.HashMap;
//    和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
//    现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
//    数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
//    输入：nums = [1,3,2,2,5,2,3,7]
//    输出：5
//    解释：最长的和谐子序列是 [3,2,2,2,3]

/**
 * 1、取数组中每个数字的出现次数
 * 2、循环机选 n&n+1 在数组中是否出现以及出现的数字大小
 */
public class Leecode_最长和谐子序列 {

    public static int findLHS(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i],0)+1);
        }
        int result = 0;
      for(int key: hashMap.keySet()){
          int val = hashMap.get(key);
          if(hashMap.containsKey(key+1)){
              result = Math.max(result,val+hashMap.get(key+1));
          }
      }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,2,5,2,3,7};
        System.out.println(findLHS(array));
    }
}
