package com.example.suanfa;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leecode_N叉树最大深度 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }
        return depth + 1;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public static int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;
            while (size > 0) {
                Node node = queue.poll();
                if (node.children != null) {
                    for (Node children : node.children) {
                        queue.offer(children);
                    }
                    size--;
                }
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {


    }
}
