package com.company;


import java.util.ArrayList;

public class Solution_200_Number_of_Islands {

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        char[][] grid2 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        };
        Solution solution = new Solution();

        int result = solution.numIslands(grid2);
        System.out.println(result);
    }

    static class Solution {
        int m = 1;
        int n = 1;

        public int numIslands(char[][] grid) {
            int landCount = 0;

            m = grid.length;
            n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        landCount++;
                        removeLand2(grid, i, j);
                    }
                }
            }

            return landCount;
        }

        class Pair<T> {
            T first;
            T second;

            public T getFirst() {
                return first;
            }

            public T getSecond() {
                return second;
            }

            Pair(T f, T s) {
                first = f;
                second = s;
            }
        }

        void removeLand0(char[][] grid, int i, int j) {
            ArrayList<Pair<Integer>> list = new ArrayList<>();

            list.add(new Pair(i, j));
            grid[i][j] = '0';

            while (!list.isEmpty()) {
                Pair pair = list.get(0);
                list.remove(0);
                int k = (int) pair.getFirst();
                int l = (int) pair.getSecond();

                // calculate next position
                // down
                if (k + 1 < m) {
                    if (grid[k + 1][l] == '1') {
                        grid[k + 1][l] = '0';
                        list.add(new Pair(k + 1, l));
                    }
                }
                // up
                if (k - 1 >= 0) {
                    if (grid[k - 1][l] == '1') {
                        grid[k - 1][l] = '0';
                        list.add(new Pair(k - 1, l));
                    }
                }

                // right
                if (l + 1 < n) {
                    if (grid[k][l + 1] == '1') {
                        grid[k][l + 1] = '0';
                        list.add(new Pair(k, l + 1));
                    }
                }

                // left
                if (l - 1 >= 0) {
                    if (grid[k][l - 1] == '1') {
                        grid[k][l - 1] = '0';
                        list.add(new Pair(k, l - 1));
                    }
                }
            }
        }

        // the fastest
        void removeLand(char[][] grid, int i, int j) {

            // up
            if (i - 1 >= 0) {
                if (grid[i - 1][j] == '1') {
                    grid[i - 1][j] = '0';
                    removeLand(grid, i - 1, j);
                }
            }
            // down
            if (j + 1 < n) {
                if (grid[i][j + 1] == '1') {
                    grid[i][j + 1] = '0';
                    removeLand(grid, i, j + 1);
                }
            }

            // right
            if (i + 1 < m) {
                if (grid[i + 1][j] == '1') {
                    grid[i + 1][j] = '0';
                    removeLand(grid, i + 1, j);
                }
            }

            // left
            if (j - 1 >= 0) {
                if (grid[i][j - 1] == '1') {
                    grid[i][j - 1] = '0';
                    removeLand(grid, i, j - 1);
                }
            }
        }

        int d[] = {0, 1, 0, -1, 0};     // d, r, l, u

        void removeLand2(char[][] grid, int i, int j) {
            if (i >= 0 && j >= 0 && i < m && j < n) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int k = 0; k < 4; k++) {
                        removeLand2(grid, i + d[k], j + d[k + 1]);
                    }
                }
            }
        }


    }
}
