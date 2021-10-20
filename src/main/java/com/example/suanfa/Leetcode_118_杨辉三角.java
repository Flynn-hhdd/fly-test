package com.example.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_118_杨辉三角 {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> results = new ArrayList<>();

        if (numRows <= 0) {
            return results;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = Arrays.asList(new Integer[i + 1]);
            list.set(0, 1);
            list.set(i, 1);
            for (int j = 1; j < i; j++) {
                list.set(j, results.get(i - 1).get(j - 1) + results.get(i - 1).get(j));
            }
            results.add(list);
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }

}
