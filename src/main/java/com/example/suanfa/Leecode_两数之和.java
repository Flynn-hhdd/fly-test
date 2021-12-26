package com.example.suanfa;

public class Leecode_两数之和 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        int legacy = 0;
        while (l1 != null || l2 != null || legacy != 0) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int sum = l1val + l2val + legacy;
            legacy = sum / 10;
            ListNode node = new ListNode(sum % 10);

            cur.next = node;
            cur = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val,Node node) {
            this.val = val;
            this.next = node;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3,null);

        Node node2 = new Node(5);
        node2.next = new Node(6);
        node2.next.next = new Node(7);
        node2.next.next.next = new Node(8,null);
        //123
        //5678
        // 321 + 8765
        Node result = new Node(0);
        Node tmp = result;
        int legacy = 0;
        while (node1 != null || node2 != null || legacy!=0) {
            int val = (node1 == null ? 0 : node1.val) + (node2 == null ? 0 : node2.val) + legacy;
            legacy = val / 10;
            Node node = new Node(val % 10);

            tmp.next = node;
            tmp = node;
            if (node1 != null) {
                node1 = node1.next;
            }

            if (node2 != null) {
                node2 = node2.next;
            }
        }
        System.out.println(result.next);

    }
}
