package com.example.suanfa;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 */

/**
 * 解题思路
 * 1、字符串每个字符出现的次数放在map
 * 2、从0~9寻找规律，z,w,u,x,g这些只出现一次且数字为0,2,4,6,8
 * 3、num里面都是数字出现的次数，从0~9拼接nums即可
 */
public class Leetcode_423 {

    public static String originalDigits(String s) {

        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }

        int[] num = new int[10];
        // 0 2 4 6 8这几个数，只出现在一个字母中
        num[0] = map.getOrDefault('z',0);
        num[2] = map.getOrDefault('w',0);
        num[4] = map.getOrDefault('u',0);
        num[6] = map.getOrDefault('x',0);
        num[8] = map.getOrDefault('g',0);

        // 3 5 7出现在h f s，可以由8 4 6推算出
        num[3] = (map.getOrDefault('h',0)) - num[8];
        num[5] = (map.getOrDefault('f',0)) - num[4];
        num[7] = (map.getOrDefault('s',0)) - num[6];

        // 1 由 0 2 4推出
        num[1] = (map.getOrDefault('o',0)) - num[0] - num[2] - num[4];
        // nine 根据i算
        num[9] = (map.getOrDefault('i',0)) - num[5] - num[6] - num[8];
        StringBuilder stringBuilder = new StringBuilder();
       for(int i = 0;i<10;i++){
          for(int j=0;j<num[i];j++){
              stringBuilder.append(i);
          }
       }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
    }
}
