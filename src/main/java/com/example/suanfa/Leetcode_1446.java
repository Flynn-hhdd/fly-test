package com.example.suanfa;

import java.util.*;

/*
给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
请你返回字符串的能量。
输入：s = "abbcccddddeeeeedcba"
输出：5
解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 */
public class Leetcode_1446 {
    public static int maxPower(String s) {
        Map<String,Integer> map = new HashMap<>();
        String[] array = s.split("");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            if (array[i+1].equals(array[i])) {
                list.add(array[i+1]);
            }
            if(!(array[i+1].equals(array[i])) || (i==array.length-2)){
                int size = map.getOrDefault(array[i], 0);
                if(size <= list.size()){
                    map.put(array[i], list.size()+1);
                }
                list.removeAll(list);
            }
        }
        if(map.size()==0){
            if(list.size()!=0){
                return list.size()+1;
            }
            return 1;
        }
        return Collections.max(map.values());
    }

    public static void main(String[] args) {
        System.out.println(maxPower("wwlediwnugkktnlhmvfkewbiursjzbyqzcpmdwwfkgyowmfdbmaonmpzhmwbftvenpbtdlwurrusjsvwwflmkfrlzytponmouqflsuvoglynndulcoumfnewlgchmvtotyxvmrhqmddsdolbugpmtabacfedehdgxrkjvyfafrgjmadbidpykkktzixacmylqjhwzlrwgasywtfcpdartduvgbvmuq"));
    }

}
