package com.example.leetcodework.code;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "cat sand dog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pine apple pen apple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 一个for循环，找到当前开头的首字符串，然后以首字符串为起点，
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []

 */
public class T20201027 {

    @Nullable
    public List<String> wordBreak(String s, List<String> wordDict) {


        List<String> result = new ArrayList<>();

        return null;
    }

    /**
     * 当前分割出来的字符串是否在字典中
     * @param key
     * @param wordDict
     * @return
     */
    public boolean isContact(@NonNull String key, @NonNull List<String> wordDict){
        for (int i = 0; i < wordDict.size(); i++) {
            String temp = wordDict.get(i);
            if(key.equals(temp)){
                return true;
            }
        }

        return false;
    }
}
