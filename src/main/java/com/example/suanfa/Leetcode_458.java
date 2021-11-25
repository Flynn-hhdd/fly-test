package com.example.suanfa;

/**
 *  k * log_2(n + 1) >= log_2(buckets)
 */

/** 反思：数学的魅力，需要关注点
 * todo 二进制、Math的api、递归用在动态规划
 * 解题思路
 * 1、根据测试轮数递推获取公式  1次 i只小猪 最大为2i次方
 * 2、每只猪 n轮下来，本身会带n+1一个状态，然后测试i只猪 就会变成 n+1 的I次方来解决这个问题
 */
public class Leetcode_458 {
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
       return (int) Math.ceil(Math.log(buckets)/Math.log( minutesToTest/minutesToDie+1));
    }

    public static void main(String[] args) {
        System.out.println(poorPigs(1000,15,60));
    }
}
