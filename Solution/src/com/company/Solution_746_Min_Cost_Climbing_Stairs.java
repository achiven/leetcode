package com.company;

public class Solution_746_Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {

    }

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] totalCost = new int[cost.length];
            for (int i = 0; i < cost.length; i++) {
                totalCost[i] = 0;
            }

            totalCost[0] = cost[0];
            totalCost[1] = cost[1];

            for (int i = 2; i < cost.length; i++) {
                int c1 = totalCost[i - 1] + cost[i];
                int c2 = totalCost[i - 2] + cost[i];

                totalCost[i] = Math.min(c1, c2);
            }

            return Math.min(totalCost[totalCost.length - 1], totalCost[totalCost.length - 2]);
        }
    }
}
