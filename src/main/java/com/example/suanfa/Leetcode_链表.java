package com.example.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName Leetcode_链表.java
 * @Description
 * @createTime 2020年03月31日 10:12:00
 */
public class Leetcode_链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;

        }
    }

    /**
     * 相交链表(借助map)
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<Integer, ListNode> map = new HashMap<>();
        while (headA != null) {
            map.put(headA.val, headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (map.containsKey(headB.val)) {
                ListNode result = new ListNode(headB.val);
                return result;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode preA = headA;
        ListNode preB = headB;
        if (headA == null || headB == null)
            return null;
        while (preA != preB) {
            if (preA != null) {
                preA = preA.next;
            } else {
                preA = headB;
            }

            if (preB != null) {
                preB = preB.next;
            } else {
                preB = headA;
            }
        }
        return preA;

    }

    /**
     * 反转单链表
     * @param head
     */
    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    public static void main(String[] args) {
//        ListNode listNode0 = new ListNode(8);
//
//        ListNode listNode1 = new ListNode(4);
//        ListNode listNode2 = new ListNode(1);
//        ListNode listNode3 = new ListNode(8);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        ListNode listNode = getIntersectionNode2(listNode0, listNode1);
//        System.out.println(listNode);
//        ListNode final1 = reverseList(listNode1);
//        System.out.println(final1.toString());
        Integer ia = Integer.valueOf(10);
        Integer ib = Integer.valueOf(10);
        Integer ic = new Integer(10);

    }
}
