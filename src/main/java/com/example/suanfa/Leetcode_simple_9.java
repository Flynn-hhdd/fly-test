package com.example.suanfa;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName Leetcode_simple_9.java
 * @Description 回文数
 * @createTime 2019年10月21日 19:26:00
 */
public class Leetcode_simple_9 {
    public boolean isPalindrome(int x) {
        String a = String.valueOf(x);
        if(x ==0){
            return true;
        }
        int size = a.length();
        char[] arr = a.toCharArray();
        boolean flag = false;
        for(int i=0;i<=size--;i++){
            if(arr[i]==arr[size]){
                flag =  true;
            }else {
                flag =  false;
                return flag;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Leetcode_simple_9 simple_9 = new Leetcode_simple_9();
////        Scanner scanner = new Scanner(System.in);
////        int aa = scanner.nextInt();
        System.out.println("是否为回文："+simple_9.isPalindrome(11));
    }
}
