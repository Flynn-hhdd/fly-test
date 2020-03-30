package com.example.suanfa;

/**
 * 单链表反转
 * 我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
 * 第二个指针 cur 指向 head，然后不断遍历 cur。
 * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
 * 都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。
 *。
 */
public class ListNodeReverse {

    public static ListNode reverseList(ListNode head) {
        if(head ==null || head.next ==null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head.next;
        ListNode tmp = null;
        while (cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        ListNode final1 = reverseList(listNode1);
        System.out.println(final1.toString());
    }
}
