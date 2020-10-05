package com;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class haioweilai {
    public static void main(String[] args) {


    }
    public String notReCuPreOrder (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        if(root==null)return list.toString();
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            root = s1.pop();
            list.add(root.val);
            if(root.right!=null){
                s1.push(root.right);
            }
            if(root.left!=null){
                s1.push(root.left);
            }
        }
        return StringUtils.join(list,",");
    }
}
class TreeNode {
   int val = 0;
   TreeNode left = null;
    TreeNode right = null;
    private TreeNode(int x){
    }
  }
