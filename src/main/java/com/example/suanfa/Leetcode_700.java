package com.example.suanfa;

/**
 * 递归，记得返回 即可
 */
public class Leetcode_700 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        while (root.val >= val) {
            return searchBST(root.left,val);
        }
        while (root.val < val) {
            return searchBST(root.right,val);
        }
        return null;
    }
}
