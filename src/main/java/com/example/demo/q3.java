package com.example.demo;


import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

public class q3 {


    public static void main(String[] args) {
        //每两个单词一行，统计需要的行数

        System.out.print("Please input text:");
        Scanner in = new Scanner(System.in);
        // input for text
        String text = in.nextLine();


        char[] chars = text.toCharArray();
        StringBuilder s1 = new StringBuilder("");


        for (char aChar : chars) {
            //认为是一个单词 例如 "re-check"
            if ('-' == aChar) {
                continue;
            }
            //标点符号做分割 例如 "Tom?ok?"
            if ('.' == aChar || '!' == aChar || ',' == aChar || '?' == aChar) {
                s1.append(" ");
            } else {
                s1.append(aChar);
            }
        }

        System.out.println("s1=" + s1);
        String[] s2 = s1.toString().replace("  ", " ").split(" ");
        System.out.println(Arrays.asList(s2));

        System.out.println((int) Math.ceil((double) s2.length/2));

//        int c = 0;
//        for (String st : s2) {
//            System.out.println(st);
//            int j = 0;
//            char[] chars1 = st.toCharArray();
//            for (char ch : chars1) {
//                System.out.println(ch);
        //((ord(j)>=65 and ord(j)<=90) 大写+64， (ord(j)>=97 and ord(j)<=122)) 小写+96
//                if (!Character.isUpperCase(ch) && !Character.isLowerCase(ch)) {
//                    j = 1;
//                    break;
//                }
//            }
//            if (j == 0) {
//                c++;
//            }
//        }
//        System.out.println((c-1)/2 + 1);
        //sfd, fie- i-?dsf ASD?
        //sfd, <<fie>> i-?dsf ASD?
    }
}
