package com.example.suanfa;

import java.util.Scanner;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName Leetcode_simple_7.java
 * @Description 整数反转(需要考虑溢出问题)
 * @createTime 2019年10月18日 19:28:00
 */
public class Leetcode_simple_7 {
    public int reverse(int x) {
//        try{
//        StringBuilder ss  = new StringBuilder();
//        if(x<0){
//            ss.append(String.valueOf(-x));
//            ss = ss.reverse();
//            return -Integer.parseUnsignedInt(ss.toString().replaceFirst("^0*",""));
//        }
//        if(x==0){
//            return x;
//        }
//        if(x>0){
//            ss = ss.append(String.valueOf(x)).reverse();
//            return Integer.parseUnsignedInt(ss.toString().replaceFirst("^0*",""));
//        }}
//        catch (Exception e){
//            return 0;
//        }
//        return 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        long r = 0;
        if(x==0){
            return x;
        }
        while (x!=0){
         r = r*10+x%10;
         x/=10;
        }
        return r>max ||r <min ?0:(int) r;
    }

    public static void main(String[] args) {
        Leetcode_simple_7 simple_7 = new Leetcode_simple_7();
        Scanner scanner = new Scanner(System.in);
        int aa = scanner.nextInt();
        System.out.println("反转后的结果为"+simple_7.reverse(aa));
    }
}
