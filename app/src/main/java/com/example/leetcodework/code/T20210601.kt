package com.example.leetcodework.code

import kotlin.jvm.JvmStatic

object T20210601 {
    @JvmStatic
    fun main(args: Array<String>) {
        val list: MutableList<Array<Array<Int>>> = mutableListOf(arrayOf(arrayOf(1,2,3,4,5), arrayOf(2,3,4,5,6), arrayOf(5,4,3,2,1)))
        list.add(arrayOf(arrayOf(1,1,1,1,1), arrayOf(2,2,2,2,2), arrayOf(3,3,3,3,3)))
        computeSorce(2,3,list)
    }

    fun computeSorce(people: Int, num : Int, list : MutableList<Array<Array<Int>>>){
        System.out.println("current books size :$num  score: ${list.size}")

        for (i in 0.. people -1){
            val result = computePeopleScore(num,list[i])
            var a = result[0];
            var b = result[0]
            var positionA = 0
            var positionB = 0
            for (i in 0..result.size -1){
                val temp = result[i]
                if(temp < a){
                    a = temp
                    positionA = i
                }else if(temp < b){
                    b = temp
                    positionB = i
                }
            }
            System.out.println("current last score: $positionA  $positionB")
        }
    }


    fun computePeopleScore(bookNum:Int, bookScoreArray: Array<Array<Int>>): IntArray {
        val result = IntArray(5)
        for (i in 0..result.size - 1){
            var temp = result[i]//当前作者该种类的默认分数
            for (j in 0..bookNum-1 ){
                val tempScore:Int = bookScoreArray[j][i]
                System.out.println("current $i type book score $tempScore")
                if(temp < tempScore){
                    result[i] = tempScore
                    temp = result[i]
                }
            }

            System.out.println("compute $i type book final score ${result[i]} ")
        }
        return result
    }
}