package com.tiger;

import com.company.leetcode.ListNode;


public class Main{

    public static void main(String[] args) {
        ListNode listNde1 = new ListNode(4);
        ListNode listNde2 = new ListNode(5);
        ListNode listNde3 = new ListNode(3);
        ListNode listNde4 = new ListNode(1);
        ListNode listNde5 = new ListNode(2);

        listNde1.next = listNde2;
        listNde2.next = listNde3;
        listNde3.next = listNde4;
        listNde4.next = listNde5;

        solution2 s = new solution2();
        s.lineUp(listNde1);
        while(listNde1!=null){
            System.out.println(listNde1);
            listNde1 = listNde1.next;
        }
    }

}
class solution2 {
    /**
     * 排队
     * @param head ListNode类 头结点
     * @return ListNode类
     */
    public ListNode lineUp (ListNode head) {
        ListNode p = head, q = head.next, second = q;
        while (p != null && q != null){
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;
            if(q == null || q.next == null)
                break;
        }
        p.next = second;
        return head;
    }
}
