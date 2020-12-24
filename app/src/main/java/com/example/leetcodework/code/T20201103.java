package com.example.leetcodework.code;

import androidx.annotation.NonNull;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 示例 1：
 * <p>
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[0,3,2,1]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * <p>
 * <p>
 * <p>
 * <p>
 * 通过次数29,190提交次数74,565
 */
public class T20201103 {
    public static void main(String[] args){
//        int[] A = {0,3,2,1};
//        int[] A = {3,5,5};
//        int[] A = {0,1,2,4,5,6,5,4,3,2,1};
        int[] A = {0,1,2,4,5,6,5,4,3,2,1,-1};
        System.out.println(validMountainArray(A));
    }
    public static boolean validMountainArray(@NonNull int[] A) {

        if(A.length == 0|| A.length == 1 || A[0] > A[1] || A[A.length - 1] > A[A.length - 2]){
            return false;
        }
        int count = 0;
        boolean isRecover = false;
        //0,3,2,1
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            int last = i +1;
            if(last <= A.length -1) {
                if (!isRecover) {//如果没有反转，那么一直做累加
                    if (temp < A[last]) {
                        count = count + 1;
                    } else if(temp == A[last]) {
                        return false;
                    }else{
                        count = count + 1;
                        isRecover = true;
                    }
                } else {
                    if (temp > A[last]) {
                        count = count + 1;
                    }else if(temp == A[last]){
                        return false;
                    }
                }
            }else{
                //结束
            }
        }
        return count == A.length - 1;
    }
}
