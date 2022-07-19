package com.company;

public class Solution_42_Trapping_Rain_Water {
    class Solution {
        public int trap(int[] height) {
            int[] fLeft = new int[height.length];
            int[] fRight = new int[height.length];

            int bigBar = 0;
            for (int i = 0; i < height.length; i++) {
                if (bigBar < height[i]) {
                    fLeft[i] = height[i];
                    bigBar = height[i];
                } else {
                    fLeft[i] = bigBar;
                }
            }

            bigBar = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                if (bigBar < height[i]) {
                    fRight[i] = height[i];
                    bigBar = height[i];
                } else {
                    fRight[i] = bigBar;
                }
            }

            int water = 0;
            for (int i = 0; i < height.length; i++) {
                water += (Math.min(fLeft[i], fRight[i]) - height[i]);
            }

            return water;
        }
    }
}
