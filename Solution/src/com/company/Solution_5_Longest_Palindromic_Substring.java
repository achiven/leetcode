package com.company;

public class Solution_5_Longest_Palindromic_Substring {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
//        System.out.println(solution.longestPalindrome("aacabdkacaa"));

    }

    static class Solution {
        public String longestPalindrome(String s) {
            String t = new String(s);
            StringBuilder sb = new StringBuilder();
            String longest = "";

            if (s.length() == 1) {
                return s;
            }

            longest = s.charAt(0) + "";

            // 1 -> 3
            for (int i = 0; i < t.length(); i++) {
                sb = new StringBuilder();
                for (int j = 1; j < t.length(); j++) {
                    if (i + j < t.length() && i - j >= 0) {
                        if (t.charAt(i - j) == t.charAt(i + j)) {
                            if (sb.length() == 0) {
                                sb = new StringBuilder(t.charAt(i) + "");
                            }
                            sb.insert(0, t.charAt(i -j));
                            sb.append(t.charAt(i + j));

                            if (longest.length() < sb.length()) {
                                longest = sb.toString();
                            }
                        } else {
                            sb = new StringBuilder();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }


            // 2 -> 4
            for (int i = 0; i < t.length() - 1; i++) {
                sb.append(t.charAt(i));
                sb.append(t.charAt(i + 1));
                int left = i - 1;
                int right = i + 2;

                if (t.charAt(i) == t.charAt(i + 1)) {
                    if (longest.length() < sb.length()) {
                        longest = new String(sb);
                    }
                    while (left >= 0 && right < t.length()) {
                        if (t.charAt(left) == t.charAt(right)) {
                            sb.insert(0, t.charAt(left));
                            sb.append(t.charAt(right));

                            if (longest.length() < sb.length()) {
                                longest = sb.toString();
                            }
                        } else {
                            sb = new StringBuilder();
                            break;
                        }

                        left--;
                        right++;
                    }
                }
            }

            return longest;
        }
    }
}
