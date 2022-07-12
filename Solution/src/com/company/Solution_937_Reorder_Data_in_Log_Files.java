package com.company;

import java.util.*;

public class Solution_937_Reorder_Data_in_Log_Files {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] str = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};

        solution.reorderLogFiles(str);
    }

    static class Solution {
        public String[] reorderLogFiles(String[] logs) {
            ArrayList<String> digList = new ArrayList<>();
            ArrayList<String> letList = new ArrayList<>();

            for (int i = 0; i < logs.length; i++) {
                String cur = logs[i];
                int blankIdx = cur.indexOf(" ");
                // if it is disit, add digList
                if (cur.charAt(blankIdx + 1) >= '0' && cur.charAt(blankIdx + 1) <= '9') {
                    digList.add(cur);
                } else {
                    // else add letList
                    // make id to last of letter-log
                    String subStr = cur.substring(blankIdx, cur.length()) + " " + cur.substring(0, blankIdx);
                    letList.add(subStr);
                }
            }

            String[] ret = new String[logs.length];

            // sort letList
            // sort all
            letList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    // extract a log without id
                    // compare
                    String str1, str2;

                    int idIdx = o1.lastIndexOf(" ");
                    str1 = o1.substring(0, idIdx);

                    idIdx = o2.lastIndexOf(" ");
                    str2 = o2.substring(0, idIdx);

                    int ret = str1.compareTo(str2);

                    if (ret == 0) {
                        return o1.compareTo(o2);
                    } else {
                        return ret;
                    }
                }
            });

            // make id to first of letter-log
            for (int i = 0; i < letList.size(); i++) {
                String cur = letList.get(i);
                int idIdx = cur.lastIndexOf(" ");
                ret[i] = cur.substring(idIdx + 1, cur.length()) + cur.substring(0, idIdx);
            }

            // add digList to ret
            for (int i = letList.size(); i < ret.length; i++) {
                ret[i] = digList.get(i - letList.size());
            }
            return ret;
        }
    }
}
