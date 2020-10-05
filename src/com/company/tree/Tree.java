package com.company.tree;


import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    TreeNode last;//上一行最后元素
    TreeNode nlast;//本行最后元素
    public void printTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        last = root;	//记录当前层最后一个节点
        nlast = root;	//记录下一层的最后一个节点
        while (!queue.isEmpty()) {
            TreeNode t = queue.peek();
            System.out.print(queue.poll().val + " ");
            if (t.left != null) {
                queue.offer(t.left);
                nlast = t.left;
            }
            if (t.right != null) {
                queue.offer(t.right);
                nlast = t.right;
            }
            // 如果当前输出结点是最右结点，那么换行
            if (last == t) {
                System.out.println();
                last = nlast;
            }
        }
    }

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        Tree test = new Tree();
        test.printTree(root);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data,TreeNode left,TreeNode right){
        this.val = data;
        this.left = left;
        this.right = right;
    }
    TreeNode(int val){
        this.val = val;
    }
}