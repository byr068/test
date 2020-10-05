package com.offer;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

class TreeNode{
    public int val;
    TreeNode left;
    TreeNode right;
    public  TreeNode(int val){
        this.val = val;
    }
}
public class isBinarySearchTree {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();
        TreeNode root = new TreeNode(9);
        TreeNode root1 = new TreeNode(7);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(10);
        TreeNode root5 = new TreeNode(3);
        root.left = root1;
        root1.right = root2;
        root1.left = root3;
        root.right = root4;
        root4.right = root5;
        boolean flag = isBST(root);
        System.out.println(flag);
    }
    static boolean flag = true;
    static int temp = 0;
    static boolean isBST(TreeNode root){
        if(root==null)return true;
        Stack<TreeNode> s1 = new Stack<>();
        TreeNode pre = null;
        while(root!=null||!s1.isEmpty()){
            while(root!=null){
                s1.push(root);
                root = root.left;
            }
            root = s1.pop();
            if(pre != null && root.val <= pre.val)return false;
            pre = root;
            root = root.right;
        }
        return flag;
    }
}
