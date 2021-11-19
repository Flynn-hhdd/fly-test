package com.example.suanfa;

import java.lang.reflect.Array;
import java.util.*;

public class Leetcode_三数之和 {

    public static int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }
        for (int i = 0; i < a.length; i++) {
            int tmp = target - a[i];
            if (map.containsKey(a) && map.get(tmp) != i) {
                return new int[]{i, map.get(tmp)};
            }
        }
        return null;
    }

    public static Object[] threeSum(int[] nums, int target) {
        if (nums == null || nums.length <= 3) {
            return null;
        }
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int tmp = target - (nums[head] + nums[tail]);
                if (tmp == nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }

                }
                if (tmp <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return result.toArray();
    }
    public static List<List<Integer>> threeSumAnother(int[] nums) {

        if (nums == null || nums.length <= 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            for(int j = nums.length-1,k=1;k<j;j--,k++){
                if((nums[i]+nums[j]+nums[k])==0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] a = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> b = threeSumAnother(a);
        System.out.println(b);
    }

}
