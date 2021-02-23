package com.company;

public class Solution_415_Add_Strings {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.addStrings("0", "0"));

    }


    static class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();

            int carry = 0;
            int p1 = num1.length() - 1;
            int p2 = num2.length() - 1;
            while (p1 >= 0 || p2 >= 0) {
                int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
                int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
                int value = (x1 + x2 + carry) % 10;
                carry = (x1 + x2 + carry) / 10;
                res.append(value);
                p1--;
                p2--;
            }

            if (carry != 0)
                res.append(carry);

            return res.reverse().toString();
        }
    }


    static class Solution2 {        // mine
        public String addStrings(String num1, String num2) {
            StringBuffer ret = new StringBuffer();

            int carry = 0;
            int p1 = num1.length() - 1;
            int p2 = num2.length() - 1;
            int size = Math.max(p1, p2);

            for (int i = 0; i < size + 1; i++) {
                int min = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
                int big = p2 >= 0 ? num2.charAt(p2) - '0' : 0;

                int sum = carry + min + big;

                int rest = sum % 10;
                carry = sum / 10;

                ret.append(rest);

                p1--;
                p2--;
            }

            if (carry >= 1) {

                ret.append("1");
            }

            return ret.reverse().toString();

        }


    }
}
