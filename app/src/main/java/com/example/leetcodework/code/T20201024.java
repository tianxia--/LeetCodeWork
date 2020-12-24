package com.example.leetcodework.code;

import androidx.annotation.NonNull;

import java.util.Arrays;

/**
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。
 * 我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
 * 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * 示例 2：
 *
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 * 示例 3：
 *
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 * 示例 4：
 *
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 *  
 *
 * 提示：
 *
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/video-stitching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T20201024 {

    public static void main(String args[]){
//        [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
//        int[][] videos= {
//                {0,2},
//                {4,6},
//                {8,10},
//                {1,9},
//                {1,5},
//                {5,9}};
//        videoStitching(videos, 10);

//        [[0,4],[2,8]], T = 9
        int[][] videos = {
                {0,2},
                {4,9}};

        System.out.println("当前结果：" + videoStitching(videos,9));
    }
    /**
     * 通过动态规划的原理，因为当前视频时长为T ,那么以这个时间来计算每一个视频片段在T的时间段所处的位置
     * ，然后计算其中可以覆盖整个时间段的所有的情况，然后计算所有情况中的最新值
     *
     * @param clips
     * @param T
     * @return
     */
    public static int videoStitching(@NonNull int[][] clips, int T) {
        int dp[] = new int[T+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            System.out.println("\n  positon = ------------" + i );

            for (int j = 0; j < clips.length; j++) {
                int[] temp = clips[j];
                if(temp[0] < i && temp[1] >= i){
                    dp[i] = Math.min(dp[i], dp[temp[0]] +1 );
                }
                System.out.println("计算过程：temp0:" + temp[0] +", temp1:" + temp[1] +"," +dp[i]);
            }
        }

        if(dp[T] == Integer.MAX_VALUE){
            return  -1;
        }

        return dp[T];
    }
}
