package com.example.leetcodework.code;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;

/**
 * 删除链表的倒数第N个节点:
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T20201018 {
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node_2 = new ListNode(2);
//        ListNode node_3 = new ListNode(3);
//        ListNode node_4 = new ListNode(4);
//        ListNode node_5 = new ListNode(5);
        node.next = node_2;
//        node_2.next = node_3;
//        node_3.next = node_4;
//        node_4.next = node_5;

        Solution solution = new Solution();
        ListNode node_result = solution.removeNthFromEnd(node,2);
        if(node_result != null) {
            System.out.println("当前头结点：" + node_result.toString());
        }else{
            System.out.println("当前头结点不存在或者已经删除");
        }
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
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

    static class Solution {
        @Nullable
        public ListNode removeNthFromEnd(@Nullable ListNode head, int n) {
            HashMap<Integer,ListNode> nodeList = new HashMap<>();

            int size = -1;
            if(head != null){
                size = 0;
                nodeList.put(size,head);
            }
            while (head.next != null){
                size = size +1;
                nodeList.put(size,head.next);
                head = head.next;
            }

            System.out.println("当前链表的size :" + size);
            System.out.println("当前链表的size :" + nodeList.size());
            //需要判断size 是否大于n 如果小于n的话，说明无法删除
            int temp = size - (n - 1);
            int head_index = 0;
            if(temp >=0){
                //删除以后要把链表重新链接起来
                ListNode last = nodeList.get(new Integer(temp -1));//上一个node
                ListNode current_remove = nodeList.get(new Integer(temp));
                ListNode next = current_remove.next;
                if(last != null){
                    last.next = next;
                }
                if(temp == 0){
                    head_index = head_index +1;
                }
                nodeList.remove(temp);//删除一定要用Integer来封装
            }

            ListNode head_result = nodeList.get(new Integer(head_index));
            return head_result;
        }
    }
}
