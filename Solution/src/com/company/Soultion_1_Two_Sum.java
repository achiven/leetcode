package com.company;

import java.util.HashMap;

public class Soultion_1_Two_Sum {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int[] result = solution.twoSum(nums, -8);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }


    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            int gap = 999999999;
            int[] ret = new int[2];

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        ret[0] = i;
                        ret[1] = j;
                        return ret;
                    }
                }
            }

            return ret;
        }

        public int[] twoSum2(int[] nums, int target) {
            int[] ret = new int[2];

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    ret[0] = i;
                    ret[1] = map.get(target - nums[i]);

                    return ret;
                } else {
                    map.put(nums[i], i);
                }

            }

            return ret;
        }

    }
}
