package com.example.suanfa;

import static com.sun.tools.javac.jvm.ByteCodes.ineg;
import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName Leetcode_旋转矩阵.java
 * @Description TODO
 * @createTime 2020年04月07日 11:02:00
 */
public class Leetcode_旋转矩阵 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = n - 1;
        for (int i = 0; i < n / 2; i++, m--) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }

    }
}
