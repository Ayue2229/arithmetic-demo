package com.example.demo;

import java.util.Scanner;

public class q1 {
    //name 在text中出现的次数
    public static int  secretInfo(String text, String name)
    {
        int  answer = 0;
        // Write your code here
        String lowercaseText = text.toLowerCase();
        String lowercaseName = name.toLowerCase();
        int index = 0;
        while (index < lowercaseText.length()) {
            index = lowercaseText.indexOf(lowercaseName, index);
            if (index == -1) {
                break;
            }
            answer++;
            index += lowercaseName.length();
        }
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input text:");
        // input for text
        String text = in.nextLine();

        // input for name
        Scanner in1 = new Scanner(System.in);
        System.out.print("Please input name:");
        String name = in1.nextLine();

        int result = secretInfo(text, name);
        System.out.print(result);

    }
}