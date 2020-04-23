package com.example.service.impl;

import com.sun.tools.javac.util.List;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName School.java
 * @Description TODO
 * @createTime 2020年03月30日 14:30:00
 */
public class SchoolAndLesson {

    // 学校数据
    @Data
    class school{
        int shoolid;
        String schoolname; //学校名字
    }

    //上课数据
    @Data
    class lesson{
        int schoolid;
        int studentCount; //学生数量
    }


    @Data
    class TreeNode{
        int val = 0;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static int getLast(int num) {
        long start = System.currentTimeMillis();
        int n = 1;
        while (num - n > 0) {
            num -= n;
            n = n * 2;
        }
        System.out.println(System.currentTimeMillis()-start);
        return num;
    }

    public static int get(int num){
        long start = System.currentTimeMillis();
        int n = (int) (Math.log(num)/Math.log(2));
        int m =  (int) (num+1-Math.pow(2,n));
        System.out.println(System.currentTimeMillis()-start);
        return  m;
    }

    public static void main(String[] args) {
//        System.out.println(Math.log(4));
        System.out.println((float) Math.log(4)/Math.log(Math.E));
    }


}
