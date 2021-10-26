package com.example.suanfa;

import lombok.val;

import java.util.List;

public class Leetcode_82_删除有序链表重复数据2 {
     class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        //前提整体是个顺序链表
        //保留头节点，后面继续递归
        if(head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
        }else {
            ListNode tmp = head.next;
            while (tmp!=null && tmp.val==head.next.val){
                tmp = tmp.next;
            }
            head = deleteDuplicates(tmp);
        }

        return head;
    }
}
