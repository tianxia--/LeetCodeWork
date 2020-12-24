package com.example.leetcodework.code;

/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 * 通过次数156,438提交次数259,950
 */
public class T20201122 {

    //Definition for a binary tree node.
    public static class TreeNode {
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


    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode treeNode_1 = new TreeNode(1);
        treeNode_1.left = new TreeNode(2);
        System.out.println(isSameTree(treeNode,treeNode_1));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


    public static String getTreeValues(TreeNode p) {
        TreeNode left = p.left;
        TreeNode right = p.right;
        String temp = p.val +"";
        if (left != null) {
            temp = left.left + getTreeValues(left);
        }

        System.out.println("current add left value：" + temp);
        if (right != null) {
            temp = right.right + getTreeValues(right);
        }
        System.out.println("current add right value：" + temp);

        if (temp.equals("")) {
            return "";
        } else {
            return temp;
        }
    }
}
