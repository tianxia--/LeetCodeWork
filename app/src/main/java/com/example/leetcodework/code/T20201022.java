package com.example.leetcodework.code;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T20201022 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    @NonNull
    public static List<Integer> partitionLabels(@NonNull String S) {
        //遍历s， 从第一个字符开始，首先查找到第一个每一个字符所对应的最大下标

        int[] ends = new int[26];
        for (int i = 0; i < S.length(); i++) {
            ends[S.charAt(i) - 'a'] = i;//循环以后会把其中字符最后一次出现的位置存储进去；
        }

        int start = 0, end = 0;
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, ends[S.charAt(i) - 'a']);//计算当前字符最大位置
            if (end == i) {
                //找到该字符的最大位置
                sizes.add(end - start + 1);
                start = end + 1;
            }
        }

        return sizes;
    }
}
