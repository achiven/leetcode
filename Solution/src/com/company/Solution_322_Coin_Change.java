package com.company;

import java.util.Arrays;
import java.util.HashMap;

class Main {

    public static void main(String[] args) {

        Solution_322_Coin_Change.Solution sol = new Solution_322_Coin_Change.Solution();

        int[] coins = {431,62,88,428};
        int ret = sol.coinChange(coins, 9084);
//        int[] coins = {2};
//        int ret = sol.coinChange(coins, 1);

//        int[] coins = {1, 2, 5};
//        int ret = sol.coinChange(coins, 11);

        System.out.println(ret);

    }
}


public class Solution_322_Coin_Change {
    static class Solution {
        public int coinChange(int[] coins, int value) {
            int max = value +1;

            int[] dp = new int[value + 1];
            Arrays.fill(dp, max);

            dp[0] = 0;      // dp[value] = used coins
            for(int i =1; i <= value; i++){
                for(int j =0; j < coins.length; j++){
                    if(coins[j] <= i){          // if the value of 'i' is bigger than the value of a coin.
                        dp[i] = Math.min(dp[i], dp[ i - coins[j]] + 1);

                        // The value of 'i' is the same as (i - coins[j]) + coins[j]
                        // coins[j] is converted to +1(a used coin)
                        // Therefore, there is dp[ i - coins[j]] + 1

                    }
                }
            }

            return dp[value] > value ? -1 : dp[value];
        }
    }


    static class Solution_fail {
        final int MAX = Integer.MAX_VALUE / 10;
        final int DEFAULT = -1;
        HashMap<Integer, Integer> map;
        public int coinChange(int[] coins, int amount) {

            Arrays.sort(coins);

            if(amount == 0)
                return 0;

            map = new HashMap<>();

            for(int i =0; i < coins.length; i++){
                map.put(coins[i], 1);
            }

            for(int i =1 ; i <= amount; i++){

                int min = MAX;

                if(map.containsKey(i))
                    continue;

                for(int j =1; j < i; j++){
                    int t2 = map.getOrDefault(i -j, MAX);
                    int t1 = map.getOrDefault(j, MAX);

                    if(t1 + t2 <= min){
                        min = t1 + t2;
                    }
                }


                map.put(amount, min);
            }

            int ret = MAX;
            ret = map.getOrDefault(amount, -1);

            if(ret >= MAX)
                return -1;

            return ret;

        }




    }

}
