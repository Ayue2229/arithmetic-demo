package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class q4 {

    //将一串数字转为所有可能得字母组合
    public static void main(String[] args) {
        System.out.print("Please input numbers:");
        Scanner in = new Scanner(System.in);
        String numbers = in.nextLine();
//        String numbers = "1025";
        List<List<Integer>> combinationList = possibleCombinations(numbers);
        for (List<Integer> combination : combinationList) {
            StringBuilder b = new StringBuilder("");
            for (int c : combination) {
                b.append((char) (c + 96));  //将数字转为小写字母
            }
            System.out.println(combination + "==>" +b.toString());
        }
    }
    public static List<List<Integer>> possibleCombinations(String numbers) {
        List<List<Integer>> combinationList = new ArrayList<>();
        possibleCombination(numbers, 0, new ArrayList<>(), combinationList);
        return combinationList;
    }
    private static void possibleCombination(String numbers, int index, List<Integer> current, List<List<Integer>> combinationList) {
        if (index == numbers.length()) {
            combinationList.add(new ArrayList<>(current));
            return;
        }
        for (int i = index + 1; i <= numbers.length(); i++) {
            String part = numbers.substring(index, i);
//            System.out.println(part);
            //if (part.startsWith("0") && part.length() > 1) continue;
            int partInt = Integer.parseInt(part);
            //剔除不等于字母的组合
            if (partInt < 1 || partInt > 26) {
                break;
            }
            current.add(partInt);
            possibleCombination(numbers, i, current, combinationList);
            current.remove(current.size() - 1);
        }
    }
}
