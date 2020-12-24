package com.example.leetcodework.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3  1219
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class T20201114 {

    public static void main(String[] args){
        System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10",2));
        System.out.println(removeKdigits("1111112",2));
        System.out.println(removeKdigits("000101",2));
        System.out.println(removeKdigits("9341134",6));
    }
    /**
     * 通过字符串单调不变，也就是说，通过从左到右，删除左边的数大于右边的数，并且达到k值的个数。然后剩余的字符串就是最小字符串。
     * 可以通过栈来进行计算，遍历字符串，对char 进行入栈，如果position 为0，那么直接入栈，如果position > 0,那么判断上一个char 是否大于当前的char，
     * 如果大于，那么需要把上一个入栈的char 进行出栈。然后继续遍历，直到结束。
     * 遍历结束后要注意，是否存在前导0，如果存在，那么需要移除。前导0可能不止一个。
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < num.length() ;i++){
            char temp = num.charAt(i);
            while(!stack.isEmpty() && stack.peekLast() > temp && k != 0){
                stack.pollLast();
                k--;
            }

            stack.addLast(temp);
        }

        if(k > 0){
            for (int i = 0; i < k; i++) {
                stack.pollLast();
            }
        }

        if(stack.isEmpty()){
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        boolean isLeadZero = true;
        while (!stack.isEmpty()){
            Character c = stack.pollFirst();
            if(c == '0' &&isLeadZero){
                continue;
            }else{
                isLeadZero = false;
            }
            builder.append(c);
        }

        String result = builder.toString();

        if(result.length() == 0){
            return "0";
        }
        return builder.toString();
    }
}
