package com.example.leetcodework.code;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class T20201026 {
    public static void main(String[] args){
//        smallerNumbersThanCurrent(new int[]{5,6,7,8});
//        smallerNumbersThanCurrent(new int[]{7,7,7,7});
//        smallerNumbersThanCurrent(new int[]{6,5,4,8});
//        smallerNumbersThanCurrent(new int[]{9,0});
        smallerNumbersThanCurrent(new int[]{9,0,9,0,9,0});
    }
    @NonNull
    public static int[] smallerNumbersThanCurrent(@Nullable int[] nums) {
        if((nums == null || nums.length == 0)){
            return new int[]{};
        }
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            System.out.println("当前计算的item：" + temp );
            for (int j = 0; j < nums.length; j++) {
                int temp_ = nums[j];
                System.out.println("当前比较的item：" + temp_ );

                if(temp_ < temp){
                    counts[i] = counts[i] +1;
                }
            }
        }

        for (int a:
             counts) {
            System.out.println("a:" + a);
        }
        return counts;
    }


}
