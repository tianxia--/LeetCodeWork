package com.example.leetcodework.code;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T20201023 {
    public static void main(String args[]){
        ListNode node = new ListNode(-129);
        ListNode node_2 = new ListNode(-129);
//        ListNode node_3 = new ListNode(2);
//        ListNode node_4 = new ListNode(1);
        node.next = node_2;
//        node_2.next = node_3;
//        node_3.next = node_4;
        System.out.println("当前回文的状态：" + isPalindrome(null));
    }
    public static boolean isPalindrome(@Nullable ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> temps = new ArrayList<>();
        ListNode temp_node = head;
        while (temp_node != null) {
            temps.add(temp_node.val);
            temp_node = temp_node.next;
        }

        int start = 0;
        int end = temps.size() - 1;
        boolean isHUi = true;

        while (start != end && end < temps.size() &&start < end) {
            System.out.println("start:" +start +", end:" + end);
            if (temps.get(start).equals(temps.get(end))) {
                //首尾位置相同，目前算是回文
                start = start + 1;
                end = end - 1;
            } else {
                isHUi = false;
                return isHUi;
            }
        }

        return isHUi;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @NonNull
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
