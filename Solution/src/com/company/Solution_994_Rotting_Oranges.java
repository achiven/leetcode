package com.company;

import java.util.ArrayList;

public class Solution_994_Rotting_Oranges {

    static class Solution {
        int matrix[] = {-1, 0, 1, 0, -1};

        public int orangesRotting(int[][] grid) {
            ArrayList<int[]> rottenList = new ArrayList<>();
            int rottenCount = 0;

            // find first rotten orange
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        rottenList.add(new int[]{i, j});
                        grid[i][j] = 0;         // clear rotten
                    }
                }
            }

            while (!rottenList.isEmpty()) {
                ArrayList<int[]> tList = new ArrayList<>();
                while (!rottenList.isEmpty()) {
                    int[] pair = rottenList.get(0);
                    rottenList.remove(0);
                    int i = pair[0];
                    int j = pair[1];

                    for (int k = 0; k < matrix.length - 1; k++) {
                        if (i + matrix[k] >= 0 && i + matrix[k] < grid.length && j + matrix[k + 1] >= 0 && j + matrix[k + 1] < grid[0].length) {
                            if (grid[i + matrix[k]][j + matrix[k + 1]] == 1) {
                                tList.add(new int[]{i + matrix[k], j + matrix[k + 1]});
                                grid[i + matrix[k]][j + matrix[k + 1]] = 0;
                            }
                        }
                    }
                }

                if (!tList.isEmpty()) {
                    rottenList = tList;
                    rottenCount++;
                } else {
                    break;
                }

            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }

            return rottenCount;


            // check there is a fresh orange
        }
    }
}
