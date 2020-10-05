package com.offer;

import com.temp;

import java.util.Scanner;

public class 反转链表 {
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.split(" ");
        if(str==null||str.length==0){
            return;
        }
        int[] arr = new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i] =  Integer.valueOf(str[i]);
        }
        ListNode head = new ListNode(arr[0]);
        ListNode root = head;
        for(int i=1;i<arr.length;i++){
            ListNode temp  = new ListNode(arr[i]);
            root.next = temp;
            root = temp;
        }

        ListNode res = reverseList(head);
        while(res!=null){
            if(res.next==null){
                System.out.print(res.data);
            }else{
                System.out.print(res.data+"->");
            }
            res = res.next;
        }
    }

}
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(){
    }
    public ListNode(int _data){
        data = _data;
    }
}


