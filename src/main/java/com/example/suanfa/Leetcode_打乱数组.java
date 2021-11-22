package com.example.suanfa;

import java.util.*;

public class Leetcode_打乱数组 {
    class Solution {
        int[] nums;
        int[] original;

        public Solution(int[] nums) {
            this.nums = nums;
            this.original = nums.clone();
        }

        public int[] reset() {
            System.arraycopy(nums, 0, original, 0, nums.length);
            return original;
        }

        public int[] shuffle() {
            int[] shuffleArray = new int[nums.length];
            ArrayList<Integer> list = new ArrayList<>(shuffleArray.length);
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int j = random.nextInt(list.size());
                shuffleArray[i] = list.remove(j);
            }
            return shuffleArray;
        }

    }
}
