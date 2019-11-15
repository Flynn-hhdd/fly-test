package com.example.suanfa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName Leetcode.java
 * @Description TODO
 * @createTime 2019年11月01日 10:54:00
 */
public class Leetcode {
    public static int len(int k,int n){
        if(n<1){
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1;i<=n;i++){
            stringBuilder.append(String.valueOf(i));
        }
        Pattern pattern = compile("foodName");
        return 0;
    }
    public static void main(String[] args) {

        System.out.println(len(1,12));
    }
}
