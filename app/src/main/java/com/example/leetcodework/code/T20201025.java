package com.example.leetcodework.code;

import androidx.annotation.Nullable;

/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T20201025 {

    public static void main(String[] args){
//        int[] A = {2,1,4,7,3,2,5};
//        longestMountain(A);
//        int[] A = {7,3,2,2};
//        int[] A = {2,5,6,8,4,2,1};
//        int[] A = {2,0,2,0};
//        int[] A = {554,639,596,820};
        int[] A = {1,2,3,4,5,6,7,8,9};
        System.out.println("山脉长度：" +longestMountain(A));
    }
    public static int longestMountain(@Nullable int[] A) {
        if(A == null || A.length == 0){
            return  0;
        }

        int[] right = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            int temp = A[i];
            int temp_right = A[i - 1];
            if(temp  > temp_right){
                //初始化right中都为0，如果i= 1，i= 2都成立的话
                // i = 1; right[1] = right[0] +1 = 0 + 1 = 1;
                // i = 2; right[2] = right[1] +1 = 1 + 1 = 2
                right[i] = right[i - 1] +1;
            }
        }

        int[] left = new int[A.length];
        for (int i = A.length - 2; i >= 0; i--) {
            int temp = A[i];
            int temp_left = A[i + 1];
            if(temp  > temp_left){
                //初始化left中都为0，如果i= A.length -2，i= A.length -3都成立的话
                // i = A.length -2; right[length -2] = right[length -1] +1 = 0 + 1 = 1;
                // i = A.length -3; right[2] = right[1] +1 = 1 + 1 = 2
                left[i] = left[i + 1] +1;
            }
        }

        int max = 0;
        for (int i = 1; i < A.length -1; i++) {
            if(right[i] == 0 || left[i] == 0){
                continue;
            }
            max = Math.max(max,(left[i] + right[i] + 1));
        }

        System.out.println("当前山脉：" +max);
        if(max < 3){
            max = 0;
        }
        return max;
    }
}
