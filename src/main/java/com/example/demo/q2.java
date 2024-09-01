package com.example.demo;

import java.util.Scanner;

public class q2 {

    //https://www.cnblogs.com/wxl845235800/p/11425298.html  维克多博士创造了一个裂变反应堆
    public static int maxEnergyGenerate(int reacCapacity, int criticalMass, int[] vol, int[] mass, int[] energy) {
        int n = vol.length; // 获取液体数量
        int[][][] dp = new int[n + 1][reacCapacity + 1][criticalMass + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= reacCapacity; j++) {
                for (int k = 1; k <= criticalMass; k++) {
                    // 不选择第 i 种液体
                    dp[i][j][k] = dp[i - 1][j][k];

                    // 选择第 i 种液体，如果体积和质量满足条件
                    if (j >= vol[i - 1] && k >= mass[i - 1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - vol[i - 1]][k - mass[i - 1]] + energy[i - 1]);
                    }
                }
            }
        }

        int maxEnergy = 0;
        for (int j = 0; j <= reacCapacity; j++) {
            for (int k = 0; k <= criticalMass; k++) {
                maxEnergy = Math.max(maxEnergy, dp[n][j][k]);
            }
        }
        return maxEnergy;
    }

    public static int maxEnergyGenerateNew(int reacCapacity, int criticalMass, int[] vol, int[] mass, int[] energy) {
        int n = vol.length;
        int[][] dp = new int[reacCapacity + 1][criticalMass + 1];

        for (int i = 0; i < n; i++) {
            for (int j = reacCapacity; j >= vol[i]; j--) {
                for (int k = criticalMass; k >= mass[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - vol[i]][k - mass[i]] + energy[i]);
                }
            }
        }
        return dp[reacCapacity][criticalMass];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // input for reacCapacity
        int reacCapacity = in.nextInt();

        // input for criticalMass
        int criticalMass = in.nextInt();

        //input for vol
        int vol_size = in.nextInt();
        int vol[] = new int[vol_size];
        for (int idx = 0; idx < vol_size; idx++) {
            vol[idx] = in.nextInt();
        }
        //input for mass
        int mass_size = in.nextInt();
        int mass[] = new int[mass_size];
        for (int idx = 0; idx < mass_size; idx++) {
            mass[idx] = in.nextInt();
        }
        //input for energy
        int energy_size = in.nextInt();
        int energy[] = new int[energy_size];
        for (int idx = 0; idx < energy_size; idx++) {
            energy[idx] = in.nextInt();
        }

        int result = maxEnergyGenerateNew(reacCapacity, criticalMass, vol, mass, energy);
        System.out.print(result);

    }
}
