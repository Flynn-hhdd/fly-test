package com.example.bingfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName CountDownLatch.java
 * @Description CountDownLatch和Cyclicbarrier概念
 * @createTime 2020年03月16日 10:38:00
 */
public class CountDownLatchTest {
    static ArrayList<String> res = new ArrayList<>();
    ReentrantLock lock = new ReentrantLock();


    public static List<String> generateParenthesis(int n) {
        dfs(n , n , "");
        return res;

    }

    public static void dfs(int left,int right,String curStr){
        if(left == 0 && right == 0){
            res.add(curStr);// 结果加入集合
            return;
        }
        if(left > 0) dfs(left - 1, right,curStr + "("); // 左大于0 拼接左括号
        if(right > left) dfs(left, right - 1, curStr + ")");//右大于左，可以拼接右括号

    }

    public static void main(String[] args) {
        generateParenthesis(3);
        System.out.println(res);
//        HashMap hashMap = new HashMap();
//        Class.forName("java.util.HashMap");
//        ClassLoader loader = ClassLoader.getSystemClassLoader();
//        loader.loadClass("java.util.HashMap");
    }
}
