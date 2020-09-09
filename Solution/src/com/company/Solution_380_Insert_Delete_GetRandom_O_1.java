package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_380_Insert_Delete_GetRandom_O_1 {
    class Solution {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        java.util.Random rand = new java.util.Random();

        /**
         * Initialize your data structure here.
         */
        public Solution() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                list.add(val);
                int idx = list.size() - 1;

                map.put(val, idx);

                return true;

            }

            return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int idx = map.get(val);

                int lastone = list.get(list.size() - 1);
                list.set(idx, lastone);
                map.put(lastone, idx);

                map.remove(val);
                list.remove(list.size() - 1);   // the removal of the last one is to avoid arraycopy() in remove().
                return true;
            }

            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
