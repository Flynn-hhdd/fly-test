package com.example.suanfa;

import java.util.ArrayList;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

/**
 * 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 解题思路:
 *  1、滑动窗口
 */
public class Leetcode_438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int sumP = 0;
        for (int i = 0; i < p.length(); i++) {
            int t = 0;
            t |= (1 << (p.charAt(i) - 'a'));
            sumP += t;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int sumS = 0;
            //待优化点
            if (p.contains(s.substring(i, i + 1))) {
                for (int j = i; j < i + p.length(); j++) {
                    int t = 0;
                    t |= (1 << (s.charAt(j) - 'a'));
                    sumS += t;
                }
            }
            if (sumS == sumP) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aacbebabacd", p = "bbb";
//        System.out.println(s.charAt(0)-'a');
        System.out.println(findAnagrams(s, p));
    }
}
