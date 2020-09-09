package com.company;

public class Solution_7_Reverse_Integer {
    class Solution {
        public int reverse(int x) {
            if(x == 0)
                return 0;

            boolean isPositive = x > 0 ? true : false;

            if(!isPositive)
                x = -x;

            long ret = 0;
            int num = x;

            int rest = 0;
            for( ; num > 0; num = num/10){
                rest = num %10;

                ret = ret * 10;
                ret += rest;
            }


            if(ret >= Integer.MIN_VALUE && ret <= Integer.MAX_VALUE){
                if(isPositive)
                    return (int)ret;

                return (int)-ret;
            }

            return 0;

        }
    }

}
