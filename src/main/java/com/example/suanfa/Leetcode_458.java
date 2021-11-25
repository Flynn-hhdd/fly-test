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


/**
 * 其实香农已经在《信息论》（信息熵）中给过我们结论了——我们一共可以进行n轮实验（n = minutesToTest / minutesToDie）：
 *
 * 经过所有实验，一只小猪能有多少种状态？第一轮就死、第二轮死、...、第n轮死，以及生还，所以一共有n + 1种状态
 * n + 1种状态所携带的信息为log_2(n + 1)比特，这也是一只小猪最多提供的信息量
 * 而”buckets瓶液体中哪一瓶是毒“这件事，也有buckets种可能性，所以需要的信息量是log_2(buckets)
 * 注：以上所有事件、状态都是先验等概的，所以可以直接对2取对数得到信息熵
 */
public class Leetcode_458 {
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
       return (int) Math.ceil(Math.log(buckets)/Math.log( minutesToTest/minutesToDie+1));
    }

    public static void main(String[] args) {
        System.out.println(poorPigs(1000,15,60));
    }
}
