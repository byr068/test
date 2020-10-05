package com.company.tree;

public class BinaryTreeDemo {
    public static void main(String[] args){
        //先创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林聪");
        HeroNode node5 = new HeroNode(5,"关胜");

        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
//        //
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        //
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        //
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

        //删除节点
        System.out.println("删除前，前序遍历：");
        binaryTree.preOrder();
        binaryTree.delNote(3);
        System.out.println("删除h后，前序遍历：");
        binaryTree.preOrder();
    }
}
//定义二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //删除节点
    public void delNote(int no){
        if(root!=null){
            if(root.getNo()==no){
                //如果只有一个root节点，这里立即判断root是不是要删除的节点
                root = null;
            }else{
                //递归删除
                root.delNote(no);
            }
        }else{
            System.out.println("空树，不能删除");
        }
    }
    //前序遍历
        public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
}
//先创建HeroNode节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //
    //
    public void delNote(int no){

        //2、如果当前节点的左子节点不为空，并且左子节点就是要删除节点，就将this.left=null;并且就返回(结束递归返回)
        if(this.left !=null&&this.left.no==no) {
            this.left = null;
            return;
        }
        //3.如果当前节点的右子节点不为空，并且右子节点就是要删除节点，就将this.right=null;并且就返回(结束递归返回)
        if(this.right !=null&&this.right.no==no) {
            this.right = null;
            return;
        }
        //4.我们就需要向左子树进行递归删除
        if(this.left!=null){
            this.left.delNote(no);
        }
        //5.则应当向右子树进行递归删除
        if(this.right!=null){
            this.right.delNote(no);
        }
    }
    //编写前序遍历的方法
    public void preOrder(){
        System.out.println(this);//先输出父节点
        //递归像左子树前序遍历
        if(this.left!=null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //编写中序遍历的方法
    public void infixOrder(){
        //递归左子树中序遍历
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        //递归右子树中序遍历
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    //编写后序遍历的方法
    public void postOrder(){
        //递归左子树后序遍历
        if(this.left!=null){
            this.left.postOrder();
        }
        //递归右子树后序遍历
        if(this.right!=null){
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }
}