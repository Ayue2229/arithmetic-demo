package com.example.demo;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * grid represents the two-dimensional grid with N rows and M columns.
 * 遍历矩阵计算房屋数量
 */
public class q8
{
    // 定义4个方向的偏移量：上、下、左、右
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int countHouses(int[][] grid) {
        int answer = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    answer++;
                    bfs(grid, i, j);
                }
            }
        }

        return answer;
    }

    // 深度优先搜索DFS： 从根节点开始一层层往下搜索直到没有节点再回到上一层搜索其他节点， 如此反复，使用先进后出的栈实现，直到栈中没有元素
    // 广度优先搜索BFS:  从根节点开始把一层搜索完毕再进行下一层搜索，使用队列实现，直到栈中没有元素
    private static void bfs(int[][] grid, int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>(); // offer, poll, peak，三种方式不会抛出异常，返回false/null
        queue.offer(new int[]{startRow, startCol}); // 添加元素到队尾
        grid[startRow][startCol] = 0;  // 标记为已访问

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); //取队首元素并删除，peak()取出但不删除
            int row = current[0];
            int col = current[1];

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValid(grid, newRow, newCol) && grid[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow, newCol}); // 相邻且等于1的
                    grid[newRow][newCol] = 0;  // 认为是同一个房子，下次不用再计算，所以标记为已访问
                }
            }
        }
    }

    private static boolean isValid(int[][] grid, int row, int col) {
        //在矩阵范围内
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // input for grid
        int grid_row = in.nextInt();
        int grid_col = in.nextInt();
        int grid[][] = new int[grid_row][grid_col];
        for (int idx = 0; idx < grid_row; idx++) {
            for (int jdx = 0; jdx < grid_col; jdx++) {
                grid[idx][jdx] = in.nextInt();
            }
        }

        int result = countHouses(grid);
        System.out.print(result);
    }
}
