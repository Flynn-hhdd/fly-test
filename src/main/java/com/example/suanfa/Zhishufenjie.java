package com.example.suanfa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName 质数分解.java
 * @Description TODO
 * @createTime 2020年03月13日 12:40:00
 */
public class Zhishufenjie {
    public static Object[] get(int sn){
        ArrayList arrayList = new ArrayList<>();
        int k = 2;
        while (sn>=k){
            if (sn%k==0){
                sn = sn/k;
                arrayList.add(k);
            }else {
                k++;
            }

        }
        return arrayList.toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(get(60)));
    }
}
