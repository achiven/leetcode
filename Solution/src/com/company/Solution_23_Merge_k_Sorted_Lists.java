package com.company;

public class Solution_23_Merge_k_Sorted_Lists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[3];
        ListNode temp = new ListNode(1);
        ListNode tIdx = temp;
        tIdx.next = new ListNode(4);
        tIdx = temp.next;
        tIdx.next = new ListNode(5);




    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        final int INVALID_NUMBER = 200000;

        public ListNode mergeKLists(ListNode[] lists) {
            ListNode ret = new ListNode();
            ListNode retSave = ret;
            while (true) {
                int nextVal = getNext(lists);
                if (nextVal == INVALID_NUMBER) {
                    break;
                }
                retSave.next = new ListNode(nextVal);
                retSave = retSave.next;
            }

            return ret.next;
        }

        public int getNext(ListNode[] lists) {
            int min = INVALID_NUMBER;
            int minIdx = 0;
            for (int i = 0; i < lists.length; i++) {
                // find which list has min value.
                if (lists[i] != null) {
                    if (min > lists[i].val) {
                        min = lists[i].val;
                        minIdx = i;
                    }
                }
            }

            if (min == INVALID_NUMBER) {
                return INVALID_NUMBER;
            } else {
                lists[minIdx] = lists[minIdx].next;
                return min;
            }
        }
    }
}
