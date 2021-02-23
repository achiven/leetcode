package com.company;

public class Solution_2_Add_Two_Numbers {

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        l1.val = 2;
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2.val = 5;
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        sol.addTwoNumbers(l1, l2);
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ret = new ListNode();
            ListNode looper = ret;

            int carry = 0;
            while (l1 != null || l2 != null) {
                int v1 = getValue(l1);
                int v2 = getValue(l2);

                // hand over the carry if exist
                int sum = v1 + v2 + carry;

                carry = sum / 10;
                sum = sum % 10;

                ret.next = new ListNode(sum);
                ret = ret.next;

                if (l1 != null)
                    l1 = l1.next;
                if (l2 != null)
                    l2 = l2.next;

            }

            return looper.next;
        }

        int getValue(ListNode list) {
            if (list != null) {
                return list.val;
            } else {
                return 0;
            }

        }
    }

    static public class ListNode {
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

}
