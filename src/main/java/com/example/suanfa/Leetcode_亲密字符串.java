package com.example.suanfa;

import java.util.HashSet;
import java.util.Set;

/**
 * 解题思路
 * 1、如果两个字符串长度不一样直接返回
 * 2、s与目标字符串存在两个以上字符不一样直接返回
 * 3、字符串完全一样，只要字符串里面有重复片段即可
 */
public class Leetcode_亲密字符串 {

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int first = -1, last = -1, size = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                size++;
                if (size > 2) {
                    return false;
                }
                if (first != -1) {
                    last = i;
                } else {
                    first = i;
                }
            }
            String a = s;
            a = a.replace(String.valueOf(a.charAt(i)),"");
            if ((a.length()!=s.length()-1) && !flag) {
                flag = true;
            }
        }
        if (s.equals(goal) && flag) {
            return true;
        }
        if (first == -1 || last == -1) {
            return false;
        }
        if ((s.charAt(first) == goal.charAt(last)) && (s.charAt(last) == goal.charAt(first))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ab"));
    }
}