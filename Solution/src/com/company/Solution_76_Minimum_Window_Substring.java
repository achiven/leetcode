package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        System.out.println( sol.minWindow("ADOBECODEBANC", "ABC") );
//        System.out.println( sol.minWindow("A", "A") );
        System.out.println(sol.minWindow("aa", "aa"));

    }
}
class Pair<K, V> {

    private final K key;
    private final V value;

    public static <K, V> Pair<K, V> createPair(K key, V value) {
        return new Pair<K, V>(key, value);
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}

class Solution {


    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters form s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();     // Pair == Pair class

        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(dictT.containsKey(c)){
                filteredS.add(new Pair<>(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};         // size, start pos, end pos

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while(r < filteredS.size()){
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if(dictT.containsKey(c)
                    && windowCounts.get(c).intValue() == dictT.get(c).intValue()){
                formed++;
            }

            // Try and contract the window till the point where it cases to be 'desirable'
            while( l <= r && formed == required){
                c = filteredS.get(l).getValue();

                // Save the smallest window until now.
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if(ans[0] == -1 || end - start + 1 < ans[0]){
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) -1);
                if(dictT.containsKey(c)
                        && windowCounts.get(c).intValue() < dictT.get(c).intValue()){
                    formed--;
                }
                l++;
            }
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

}

public class Solution_76_Minimum_Window_Substring {

    String ret = "";

    public String minWindow(String s, String t) {
        StringBuilder S = new StringBuilder(s);
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        int targetCnt = 0;

        if (t.length() > s.length())
            return ret;

        for (int i = 0; i < t.length(); i++) {
            int temp = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), temp + 1);
            targetCnt++;
        }

        for (int i = 0; i < S.length(); i++) {
            // expand sb
            char at = S.charAt(i);
            sb.append(at);

            if (map.get(at) != null) {
                int temp = map.get(at);

                // temp could be minus. When the value is minus, it doesn't affect targetCnt
                if (temp > 0) {
                    targetCnt--;
                }
                map.put(at, temp - 1);
            }

            // contract sb
            if (targetCnt == 0) {
                if (ret.length() > sb.length() || ret.isEmpty())
                    ret = sb.toString();

                while (sb.length() > 0) {

                    char lAt = sb.charAt(0);
                    sb.deleteCharAt(0);

                    if (map.get(lAt) != null) {
                        int temp = map.get(lAt);

                        if (temp == 0) {
                            map.put(lAt, temp + 1);
                            targetCnt++;
                            break;
                        }
                        map.put(lAt, temp + 1);
                    }

                    if (ret.length() > sb.length() || ret.isEmpty())
                        ret = sb.toString();
                }

            }

        }

        return ret;
    }

}
