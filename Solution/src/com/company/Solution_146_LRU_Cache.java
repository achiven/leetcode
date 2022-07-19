package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_146_LRU_Cache {

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);

//        ["LRUCache", "put",   "put", "get", "put", "get", "put", "get", "get", "get"]
//        [[2],         [1, 1], [2, 2], [1],  [3, 3], [2],  [4, 4], [1],  [3],    [4]]
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));     // -1?
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));

    }

    static class LRUCache {
        int capa = 0;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int lru = 0;

        public LRUCache(int capacity) {
            capa = capacity;
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public int get(int key) {
            lru = key;
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {

            if (get(key) == -1) {           // doesn't exist
                if (list.size() == capa) {
//                    System.out.println(list.get(0) + " " + key);
                    map.remove(lru);
                    list.remove(list.indexOf(lru));
                }
                list.add(key);
                map.put(key, value);
            } else {                        // exist
                map.put(key, value);
            }
            lru = key;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
