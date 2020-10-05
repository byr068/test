package com.company.leetcode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        this.val = x;
    }

    //为了显示方便
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
class SingledList{
    //先初始化一个头结点
    private ListNode head = new ListNode(0);

    public void add(ListNode listNode){

        ListNode temp =head ;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //退出while循环，链表指向最后
        temp.next=listNode;
    }

    //显示链表
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
       ListNode temp = head.next;
        while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

}