package com.example.suanfa;

import java.util.Arrays;

public class Leetcode_前序中序输出后序 {

    static int  time = 0;
    

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        void addLeft(TreeNode left) {
            this.left = left;
        }

        void addRight(TreeNode right) {
            this.right = right;
        }

    }


    public static void  test() {
        int[] pre = new int[]{3, 5, 2, 8, 6, 4, 7, 1};
        int[] mid = new int[]{2, 5, 8, 3, 4, 6, 7, 1};
        TreeNode tree = toTree(pre, mid);
        print(tree);

        System.out.println();
        System.out.println(time);
    }

    static void print(TreeNode node) {
        if (node.left != null) {
            print(node.left);
        }
        if (node.right != null) {
            print(node.right);
        }
        System.out.print(node.value+" ");
    }

    public static TreeNode toTree(int[] pre, int[] mid) {
        int length = pre.length;
        TreeNode tree = new TreeNode(pre[0]);
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < length; i++) {
            if (mid[i] == pre[0]) {
                //根据根节点在中序中的位置，确定在中序中左子树的范围
                leftIndex = i;
                //确定在中序中右子树的范围
                rightIndex = i == length - 1 ? 0 : i + 1;
                break;
            }
        }
        if (leftIndex != 0) {
            //左子树的先序数组
            int[] leftPre = Arrays.copyOfRange(pre, 1, leftIndex + 1);
            //左子树的中序数组
            int[] leftMid = Arrays.copyOfRange(mid, 0, leftIndex);
            tree.addLeft(toTree(leftPre, leftMid));
        }
        if (rightIndex != 0) {
            //右子树的先序数组
            int[] rightPre = Arrays.copyOfRange(pre, rightIndex, length);
            //右子树的中序数组
            int[] rightMid = Arrays.copyOfRange(mid, rightIndex, length);
            tree.addRight(toTree(rightPre, rightMid));
        }
        return tree;
    }

    public static void main(String[] args) {
        test();
    }



    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,  inorder, (long)Integer.MAX_VALUE + 1);
    }
    static int pre = 0;
    static int in = 0;
    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
        time++;
        //到达末尾返回 null
        if(pre == preorder.length){
            return null;
        }
        //到达停止点返回 null
        //当前停止点已经用了，in 后移
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int root_val = preorder[pre++];
        TreeNode root = new TreeNode(root_val);
        //左子树的停止点是当前的根节点
        root.left = buildTreeHelper(preorder,  inorder, root_val);
        //右子树的停止点是当前树的停止点
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }

}

