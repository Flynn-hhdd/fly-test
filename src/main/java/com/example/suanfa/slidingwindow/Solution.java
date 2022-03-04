package com.example.suanfa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int lengthOfLongestSubstring(String s){
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for(int start = 0,end = 0;end <s.length();end++){
            char right = s.charAt(end);
            map.put(right,map.getOrDefault(right,0)+1);
            while (map.get(right) >1){
                char left = s.charAt(start);
                map.put(left,map.get(left)-1);
                start++;
            }
            ans = Math.max(ans,end-start+1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
