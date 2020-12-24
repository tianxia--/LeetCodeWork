package com.example.leetcodework.test;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test_排序 {
    public static void main(String[] args){
        List<String> res = new ArrayList<>();
        res.add("G6119-001");
        res.add("G7119-002");
        res.add("G7119-001");
        res.add("GA119-008");
        res.add("GA200-010");
        res.add("GB119-001");
        res.add("GB119-100问问");
        res.add("GB119-100哈哈");
        res.add("PA20-100");
        res.add("PB20-100");
        res.add("B20-100");
        res.add("Z20-100");
        sort(res);
        for (String s:
             res) {
            System.out.println(s);
        }
    }

    /**
     * G6119-001
     * P203
     * @param res
     */
    public static void sort(@NonNull List<String> res){
        HashMap map = new HashMap();
//        for (int i = 0; i < res.size(); i++) {
//            String temp = res.get(i);
//            String[] temps = temp.split("[-]");
//            Collections.sort();
//        }
        Collections.sort(res);
    }
}
