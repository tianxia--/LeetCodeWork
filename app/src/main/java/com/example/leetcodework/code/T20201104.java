package com.example.leetcodework.code;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 *
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 */
public class T20201104 {

    /**
     * 示例intervals = [[1,3],[6,9]], newInterval = [2,5]
     * @param intervals
     * @param newInterval
     * @return
     */
    @NonNull
    public int[][] insert(@NonNull int[][] intervals, int[] newInterval) {
        int left = newInterval[0];//2
        int right = newInterval[1];//5

        List<int[]> result = new ArrayList<>();
        boolean placed = false;
        for (int[] temp: intervals) {// 1,3 ; 6,9
            int temp_left = temp[0];// 1; 6
            int temp_right = temp[1];//3;9
            if(temp_left > right){//当前插入的数字在该区间的右边
                if(!placed){
                    result.add(new int[]{left,right});
                    placed = true;
                }
                result.add(temp);
            }else if(temp_right <left){//当前插入的数字在该区间的左边
                result.add(temp);
            }else{//存在交集
                left = Math.min(left,temp_left);
                right = Math.max(right,temp_right);
            }
        }

        if(!placed){
            result.add(new int[]{left, right});
        }

        int[][] end = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            end[i] = result.get(i);
        }

        return end;
    }
}
