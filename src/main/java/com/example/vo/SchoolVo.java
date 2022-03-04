package com.example.vo;

import lombok.Data;

import java.util.*;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName SchoolVo.java
 * @Description TODO
 * @createTime 2019年11月15日 16:48:00
 */
@Data
public class SchoolVo {
    private long id;
    private String schoolName;
    private String schoolDescribe;


    public static void main(String[] args) {
       int[] array = new int[]{1,2,3,4,5,7};
        System.out.println(getResult(5,array));
    }

    private static int getResult(int target,int[] array){
        int i = 0 ,n = array.length-1,sum = 0;
        Arrays.sort(array);
        List<Integer> resultArray = new ArrayList<>();
        int start = 0;
        while (i<n){
            if(sum<target){
                sum+=array[i];
            }
            i++;
            if(sum == target){
                resultArray.add(i);
            }
            if(sum>target){
                start++;
                i = start;
            }
        }
        Collections.sort(resultArray);
        return resultArray.get(0);

    }

}

