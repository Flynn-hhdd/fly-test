package com.example.suanfa;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 最笨方法：
 *  set存储L+R字符串
 */
public class Leetcode_519 {
    private int resetM ;
    private int resetN;
    private Set<String> set;

    public Leetcode_519(int m, int n) {
        resetM = m;
        resetN = n;
        this.set = new HashSet<>();
    }

    public int[] flip() {
        int L = new Random().nextInt(resetM);
        int R = new Random().nextInt(resetN);
        while (set.contains(L+","+R)){
            L= new Random().nextInt(resetM);
            R = new Random().nextInt(resetN);
        }
        set.add(L+","+R);
        return new int[]{L,R};
    }

    public void reset() {
        this.set = new HashSet<>();
    }

    public static void main(String[] args) {
        Leetcode_519 obj = new Leetcode_519(3, 1);
        System.out.println( obj.flip());
        System.out.println( obj.flip());
        System.out.println( obj.flip());
        System.out.println( obj.flip());
        System.out.println( obj.flip());
        obj.reset();
    }

    /**
     * int[] result;
     *         int m = 0;
     *         int n = 0;
     *         while (L<resetM && n<=R){
     *             if(array[L][n] == 0){
     *                 array[L][n] = 1;
     *                 result = new int[]{L,n};
     *                 L ++;
     *                 return result;
     *             }
     *             n+=1;
     *         }
     *         while (R<=resetN && m<=L){
     *             if(array[R][m] == 0){
     *                 array[R][m] = 1;
     *                 result = new int[]{R,m};
     *                 R ++;
     *                 return result;
     *             }
     *             m+=1;
     *         }
     *         return null;
     */
}
