package com.example.suanfa;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CombinationSum {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(getResult(5, array));
    }

    private static int getResult(int target, int[] array) {
        int len = array.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return 0;
        }

        Arrays.sort(array);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(array, 0, len, target, res, path);
        log.info("---={}", res);
        int result = res.get(0).size();
        for (List<Integer> rr:res){
            result = Math.min(result, rr.size());
        }
        return result;

    }

    private static void dfs(int[] array, int begin, int len, int target, List<List<Integer>> res, Deque<Integer> path) {
        //叶子结点<0 直接返回
        if (target < 0) {
            return;
        }
        //==0 拿到结果，path入库
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (target - array[i] < 0) {
                break;
            }
//            if (i > begin && array[i] == array[i + 1]) {
//                continue;
//            }
            path.addLast(array[i]);
//            dfs(array, i + 1, len, target - array[i], res, path);
            dfs(array, i , len, target - array[i], res, path);
            path.removeLast();
        }

    }
}
