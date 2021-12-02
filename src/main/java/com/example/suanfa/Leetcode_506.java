package com.example.suanfa;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_506 {
    public static String[] findRelativeRanks(int[] score) {
        String[] array = new String[score.length];
        int[] ss = score.clone();
        Arrays.sort(score);
        Map<Integer, String> map = new HashMap<>();
        for (int i = score.length - 1; i >= 0; i--) {
            map.put(score[i], String.valueOf(score.length-i));
            if (i == score.length - 1) {
                map.put(score[i], "Gold Medal");
            }
            if (i == score.length - 2) {
                map.put(score[i], "Silver Medal");
            }
            if (i == score.length - 3) {
                map.put(score[i], "Bronze Medal");
            }
        }
        for (int i = 0; i < ss.length; i++) {
            array[i] = map.get(ss[i]);
        }

        return array;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5, 4, 3, 2, 1};
        System.out.println(findRelativeRanks(test));
    }
}
