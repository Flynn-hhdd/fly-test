package com.example.suanfa;

import java.util.*;

public class Leetcode_最大单词长度乘积 {

    public static int maxProduct(String[] words) {
        if (words.length < 1) {
            return 0;
        }
        Integer maxValue = 0;
        for (int i = 0; i < words.length - 1; i++) {
            List<String> array = new ArrayList<>();
            for (int j = words.length-1; j > 0; j--) {
                if (words[i].length() == 0 || words[j].length() == 0) {
                    continue;
                }
                String[] charArray = words[j].split("");
                boolean flag = true;
                for (int k = 0; k < charArray.length; k++) {
                    if (words[i].contains(charArray[k])) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    if(words[i].length()*words[j].length()>maxValue){
                        maxValue = words[i].length()*words[j].length();
                    }
                }
            }

        }
        return maxValue;
    }

    public static int maxProduct2(String[] words) {
        int len = words.length;
        int[] marks =new int[len];
        for(int idx= 0;idx<len;idx++){
            String word = words[idx];
            int t = 0;
            for(int i=0;i<word.length();i++){
                int u = word.charAt(i)-'a';
                t|=(1<<u);
            }
            marks[idx] = t;
        }
        int result = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if((marks[i]&marks[j])==0){
                    result = Math.max(result,words[i].length()*words[j].length());
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String[] words = new String[]{"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(maxProduct2(words));
    }
}
