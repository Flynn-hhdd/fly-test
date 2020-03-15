package com.example.suanfa;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName LeetcodeMS01.java
 * @Description 判断一个字符串中是否有重复字符
 * @createTime 2020年03月13日 13:06:00
 */
public class LeetcodeMS01 {

    public static boolean isTest(String var) {
        for(int i=0;i<var.length();i++){
            String a = var;
            a = a.replace(String.valueOf(a.charAt(i)),"");
            if(a.length()!=var.length()-1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isTest("abc"));
    }
}
