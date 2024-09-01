package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        //给定一个数组长度，给定数组，找出间隔小于等于1的数组个数
        //例如给[11,11,12,15,16] 结果等于3
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int count = 0;
        int max = -1;

        for (int i = 0; i < n - 1; i++) {
            if ((arr[i + 1] - arr[i] == 0) || (arr[i + 1] - arr[i] == 1))
                count++;
            else {
                if (count + 1 > max)
                    max = count + 1;
                count = 0;
            }
        }
        System.out.println(max);
    }
}