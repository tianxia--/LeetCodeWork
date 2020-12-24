package com.example.leetcodework.code;

/**
 * 面试题 08.05. 递归乘法
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 1, B = 10
 * 输出：10
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * 提示:
 * <p>
 * 保证乘法范围不会溢出
 * 通过次数12,021提交次数17,997
 */
public class T20201202 {
    public static void main(String[] args) {
        System.out.println(multiply(100, 6));
    }

    public static int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        int min = Math.min(A, B);
        int max = Math.max(A, B);

        if (min == 1) {
            return max;
        }
        int count = 0;
        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                count += max << i;
            }
            min = min >> 1;
        }

        return count;
    }

}
