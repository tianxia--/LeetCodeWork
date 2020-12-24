package com.example.leetcodework.code;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * 通过次数197,550提交次数288,262
 */
public class T20201125 {
    public static class ListNode {
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


    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        swapPairs(head);

        ListNode result = head;
        while (result !=  null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }


}
