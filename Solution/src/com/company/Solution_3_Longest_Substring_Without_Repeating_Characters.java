package com.company;

import java.util.HashSet;
import java.util.Set;

public class Solution_3_Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring2("pwwkew"));
//        System.out.println(solution.lengthOfLongestSubstring("aabaab!bb"));


    }

    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            StringBuilder sb = new StringBuilder();
            int longest = 0;

            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);

                int pos = sb.indexOf(String.valueOf(cur));
                sb.append(cur);

                // if existed
                if (pos != -1) {
                    sb = new StringBuilder(sb.substring(pos + 1, sb.length() - 1));
                }

                if (longest < sb.length()) {
                    longest = sb.length();
                }
            }

            return longest;
        }

        public int lengthOfLongestSubstring2(String s) {
            int i = 0, j = 0, max = 0;
            Set<Character> set = new HashSet<>();

            while (j < s.length()) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    max = Math.max(max, set.size());

                } else {
                    set.remove(s.charAt(i++));
                }
            }

            return max;
        }
    }
}
