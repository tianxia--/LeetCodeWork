package com.example.leetcodework.code;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.List;

/**
 * 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T20201020 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
//        ListNode node_2 = new ListNode(2);
//        ListNode node_3 = new ListNode(3);
//        ListNode node_4 = new ListNode(4);
//        ListNode node_5 = new ListNode(5);
//        node.next = node_2;
//        node_2.next = node_3;
//        node_3.next = node_4;
//        node_4.next = node_5;
//        System.out.println(node.toString());
        reorderList(node);
        System.out.println(node.toString());

    }

    public static class ListNode {
        int val;
        @Nullable
        ListNode next;

        ListNode() {
        }

        ;

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

    /**
     * 对列表进行重排
     * 以下实现效率不高
     * 可以通过计算链表中点，然后对右端链表进行反转，然后左右俩端进行合并
     * 12345   A:123 B:45 （反转后B:54）
     * 合并  A0 + B0 + A1+B1 + A2 = 15243
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        //通过HashMap 保存链表的所有数据，计算链表的长度，然后通过改变节点的next节点，调整链表的顺序。
        HashMap<Integer, ListNode> nodeList = new HashMap<>();
        int nodeListLength = 0;
        for (ListNode node = head; ; ) {
            if (node == null) {
                break;
            }
            nodeList.put(nodeListLength, node);
            nodeListLength = nodeListLength + 1;
            node = node.next;
        }

        int temp = nodeListLength / 2 + nodeListLength % 2;
        //通过for 循环遍历进行链表重排
        for (int i = 0; i < temp; i++) {
            ListNode node = nodeList.get(new Integer(i));
            if(node == null){
                break;
            }
//            12345
//            5-2 -0 = 3  5
//            5-2-1= 2   3
//            5 -2 - 2 = 1;

            ListNode lastNode = nodeList.remove(new Integer(nodeListLength - 2 - i));

            ListNode nextNode ;
            if (lastNode != null) {
                nextNode = lastNode.next;
                lastNode.next = null;
            }else{
                break;
            }
            System.out.println("当前val ：" +nextNode.val );
            if (nextNode == null) {//如果要插入的node为空，那么说明已经结束
                break;
            }
            ListNode newNextNode = node.next;//新的next节点，要放到nextNode后边

            node.next = nextNode;

            if (newNextNode == null) {//如果当前next node为空，那么也应该结束
                break;
            }
            nextNode.next = newNextNode;

        }

        head = nodeList.get(new Integer(0));
    }
}
