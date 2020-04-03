package com.example.suanfa;

import java.util.Arrays;

/**前序 中左右 中序 左中右 后序 左右中
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName Leetcode_二叉树.java
 * @Description
 * @createTime 2020年04月01日 10:29:00
 */
public class Leetcode_二叉树 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val = x;
        }
    }

    /** 二叉树合并
     * 思想：将一棵树t2，合并到另一棵树t1
     * 递归公式：合并当前节点 + 合并左子树 + 合并右子树
     * 终止条件：t1或t1的节点为空
     *
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1== null && t2==null){
            return null;
        }
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }

    /**
     * 重建二叉树 找到根节点，然后递归找左子树和右子树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length<=0 || inorder.length<=0){
            return null;
        }
        int length = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        int left=0,right=0;
        for(int i = 0;i < length;i++){
            if(preorder[0]==inorder[i]){
                left = i;
                right = i+1;
                break;
            }
        }
        if(left!=0){
            int[] preArray = Arrays.copyOfRange(preorder,1,left+1);
            int[] midArray = Arrays.copyOfRange(inorder,0,left);
            root.left = buildTree(preArray,midArray);
         }
        if(right!=0){
            int[] preArray = Arrays.copyOfRange(preorder,right,length);
            int[] midArray = Arrays.copyOfRange(inorder,right,length);
            root.right = buildTree(preArray,midArray);
        }
        return root;
    }

    /**
     * 判断是否是对称二叉树
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return isSame(root,root);
    }
    public static boolean isSame(TreeNode left, TreeNode right){
        if(left==null && right ==null){
            return true;
        }
        if(left==null || right ==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return isSame(left.left,right.right) && isSame(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(1);
        System.out.println(isSymmetric(treeNode));
    }


}
