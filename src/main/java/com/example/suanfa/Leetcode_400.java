package com.example.suanfa;

/**
 * 第N位数字
 *
 */
public class Leetcode_400 {
    public static int findNthDigit(int n) {
        long N = n;
        int digits = 1; // 位数
        long border = 9; // digits位数一共产生多少位数字
        int begin = 1;
        while(N > border*digits) {
            N -= border*digits; // N 为扣掉所有digits位数字（比如2位数）产生的数字之后还剩多少个数字
            digits++;
            border *= 10;
            begin *=10;
        }
        // 循环结束后 剩余的N都是由 digits位数 贡献的
        // 每个 digits位数 都产生了 digits个数字；
        // 因而我们求除求余就可以知道n对应的是第几个digits位数

        //offset对应的就是第几个 (9-1)/3=2 对应的102,求除获取第几个
        int offset = (int) ((N - 1) / digits);
        //求余获取这个数的第几位
        int mod = (int) ((N - 1) % digits);
        char[] target = String.valueOf(offset+begin).toCharArray();
        int ans = target[mod] - '0';

        return ans;
    }
    public static void main(String[] args) {

        //198 实际对应的100 101 102
        System.out.println(findNthDigit(198));
    }
}
