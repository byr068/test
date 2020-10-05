package com.offer;

import java.util.LinkedList;
import java.util.Scanner;

public class 繁殖最近公共祖先 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            LinkedList<String> list =new LinkedList<>();
            for(String s:str.split(" ")){
                list.addLast(s);
            }
            TreeNode root = helper(list);
            String str2 = in.nextLine();
            String[] strs = str2.split(" ");
            TreeNode left = new TreeNode(Integer.parseInt(strs[0]));
            TreeNode right = new TreeNode(Integer.parseInt(strs[1]));
            TreeNode res = lowestCommonAncestor(root,left,right);
            System.out.println(res.val);
        }
    }
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null||root.val==p.val||root.val==q.val)return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null)return right;
        if(right==null)return left;
        return root;
    }
    static TreeNode helper(LinkedList<String> list){
        if(list.isEmpty())return null;
        if(list.getFirst().equals("-1")){
            list.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.removeFirst()));
        root.left = helper(list);
        root.right = helper(list);
        return root;
    }
}
/**
 * class TreeNode{
 *     public int val;
 *     TreeNode left;
 *     TreeNode right;
 *     public  TreeNode(int val){
 *         this.val = val;
 *     }
 * }
 */