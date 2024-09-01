package com.example.demo;

import java.util.Scanner;

public class q5 {
    //求和  i+(i+1)+(i+2)+(i+3)…j+(j-1)+(j-2)+(j-3)……..k
    // -108<=i,j,k<=108  并且 i,k<=j
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input i:");
        int i = sc.nextInt();
        System.out.print("Please input j:");
        int j = sc.nextInt();
        System.out.print("Please input k:");
        int k = sc.nextInt();

        float n, s1, s2;
        //计算 i 到 j 的项数
        n = Math.abs(j - i) + 1;
        //i 到 j 求和公式
        s1 = (n / 2) * (2 * i + (n - 1));

        //计算 j 到 k 的项数
        n = Math.abs(k - (j - 1)) + 1;
        //j 到 k求和公式
        s2 = (n / 2) * (2 * (j - 1) - (n - 1));
        System.out.println((int)(s1 + s2));

    }
}