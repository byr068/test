package com.tencent;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int q1len=in.nextInt();
            ListNode q1=new ListNode(-1);
            ListNode q1cur=q1;
            for (int i=0;i<q1len;i++){
                q1cur.next=new ListNode(in.nextInt());
                q1cur=q1cur.next;
            }
            int q2len=in.nextInt();
            ListNode q2=new ListNode(-1);
            ListNode q2cur=q2;
            for (int i=0;i<q2len;i++){
                q2cur.next=new ListNode(in.nextInt());
                q2cur=q2cur.next;
            }

            q1cur=q1.next;
            q2cur=q2.next;
            while (q1cur!=null&&q2cur!=null){
                if (q1cur.val==q2cur.val){
                    System.out.print(q1cur.val+" ");
                    q1cur=q1cur.next;
                    q2cur=q2cur.next;
                }else if (q1cur.val>q2cur.val){
                    q1cur=q1cur.next;
                }else {
                    q2cur=q2cur.next;
                }
            }

        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

}
