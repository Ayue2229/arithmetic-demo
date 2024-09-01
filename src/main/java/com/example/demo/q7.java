package com.example.demo;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 计算两个圆的相交面积
 * sqrt: 平方根，根号4=2，根号9=3
 * 圆的面积：π * r²
 * 扇形的面积：圆心角n° * π * r² / 360°
 * π = 360°
 * 三角形面积 = 三角形的面积等于两邻边及其夹角正弦值的乘积的一半。  AC * BC * sinC / 2
 *
 * 正弦： 在任意一个平面三角形中，各边和它所对角的正弦值的比相等且等于外接圆的直径”，即a/sinA = b/sinB =c/sinC = 2r=D
 * 余弦： 任何一边的平方等于其他两边平方的和减去这两边与它们夹角的余弦的积的两倍。  cosA = (b² + c² - a²) / 2bc, 其他边同理, 角邻边的平方和
 * 正切： 使用任意平面三角形，但直角三角形中，tan∠A = ∠A的对边 / ∠A的直角邻边
 *
 *
 *
 * 最终：两个扇形-两倍的三角形
 */
public class q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入变量
        int centerX1 = scanner.nextInt();
        int centerY1 = scanner.nextInt();
        int radius1 = scanner.nextInt();
        int centerX2 = scanner.nextInt();
        int centerY2 = scanner.nextInt();
        int radius2 = scanner.nextInt();

        // 计算2个圆心距离
        double distance = Math.sqrt(Math.pow(centerX2 - centerX1, 2) + Math.pow(centerY2 - centerY1, 2));

        // 开始计算相交面积
        double area = checkArea(radius1, radius2, distance);

        System.out.printf("%.6f%n", area);

        scanner.close();
    }

    private static double checkArea(int r1, int r2, double d) {
        // 没有相交或者是包含关系
        if (d >= r1 + r2) return 0;
        if (d <= Math.abs(r1 - r2)) return Math.PI * Math.min(r1, r2) * Math.min(r1, r2);


        //https://blog.csdn.net/aaakkk_1996/article/details/81746858
        // 计算扇形的圆心角
        double angle1 = 2 * Math.acos((r1 * r1 + d * d - r2 * r2) / (2 * r1 * d));
        double angle2 = 2 * Math.acos((r2 * r2 + d * d - r1 * r1) / (2 * r2 * d));

        //扇形的面积：r1 * r1 * angle / 2   =  圆心角n° * π * r² / 360°
        //三角形面积: r1 * r1 * sin(angle)/2
        //扇形 - 三角形面积
        double area1 = 0.5 * r1 * r1 * (angle1 - Math.sin(angle1));
        double area2 = 0.5 * r2 * r2 * (angle2 - Math.sin(angle2));

        return area1 + area2;
    }
}
