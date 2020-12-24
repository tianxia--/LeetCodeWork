package com.example.leetcodework.code;

/**
 * 478. 在圆内随机生成点
 * 给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
 *
 * 说明:
 *
 * 输入值和输出值都将是浮点数。
 * 圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
 * 圆周上的点也认为是在圆中。
 * randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。
 * 示例 1：
 *
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1,0,0],[],[],[]]
 * 输出: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 * 示例 2：
 *
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[10,5,-7.5],[],[],[]]
 * 输出: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
 * 输入语法说明：
 *
 * 输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有三个参数，圆的半径、圆心的 x 坐标、圆心的 y 坐标。randPoint 没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 *
 * 通过次数3,944提交次数9,382
 */
public class T20201115 {
    public static void main(String[] args){
        System.out.println(Math.sqrt(4));
        System.out.println(Math.pow(2,3));
        Solution solution = new Solution(10,0,0);
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            System.out.println("x:" + point[0] +",y:" + point[1]);
        }
    }
    public static class Solution{
        double rad, xc, yc;
        public Solution(double radius, double x_center, double y_center) {
            rad = radius;
            xc = x_center;
            yc = y_center;
        }

        public double[] randPoint() {
            double d = rad * Math.sqrt(Math.random());
            double theta = Math.random() * 2 * Math.PI;
            return new double[]{d * Math.cos(theta) + xc, d * Math.sin(theta) + yc};
        }

        /**
         * 通过拒绝采样来实现该功能，随机出某个点，然后判断是否在圆上。
         * 通过随机某一个点，然后以该点到原点的x 轴的距离的平方 + y轴的距离的平方，然后开平方，
         * 计算出来的就是该点距离原点的距离，然后判断该距离是否<=圆的半径。
         * @return
         */
        public double[] randPoint2() {
            double x0 = xc - rad;
            double y0 = yc - rad;

            while(true) {
                double xg = x0 + Math.random() * rad * 2;
                double yg = y0 + Math.random() * rad * 2;
                if (Math.sqrt(Math.pow((xg - xc) , 2) + Math.pow((yg - yc), 2)) <= rad)
                    return new double[]{xg, yg};
            }
        }
    }
}
