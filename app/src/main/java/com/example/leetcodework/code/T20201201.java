package com.example.leetcodework.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class T20201201 {
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
        treeNode.left = null;
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> list = postorderTraversal(treeNode);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        order(root,res);
        return res;
    }
    public static void order(TreeNode root, ArrayList<Integer> left){
        if(root == null){
            return;
        }
        order(root.left,left);
        order(root.right,left);

        left.add(root.val);
    }
}
