package com.company;

public class Solution_2_Add_Two_Numbers2 {

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
        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            // make string
            // first will be placed at the end.
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            ListNode ret = new ListNode(-1);
            while (l1 != null) {
                sb.append(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                sb2.append(l2.val);
                l2 = l2.next;
            }

            if (sb.length() < sb2.length()) {
                StringBuilder temp = sb;
                sb = sb2;
                sb2 = temp;
            }

            if (sb.length() > sb2.length()) {
                int sub = sb.length() - sb2.length();
                StringBuilder sbZero = new StringBuilder();

                for (int i = 0; i < sub; i++) {
                    sbZero.append("0");
                }

                sb2 = new StringBuilder(sb2 + sbZero.toString());
            }
            int carry = 0;
            ListNode loop = ret;
            for (int i = 0; i < sb.length(); i++) {
                int one = sb.charAt(i) - '0';
                int two = sb2.charAt(i) - '0';
                int val = (one + two + carry) % 10;
                carry = (one + two + carry) / 10;
                loop.next = new ListNode(val);
                loop = loop.next;
            }
            // make list node

            if (carry == 1) {
                loop.next = new ListNode(carry);
            }

            return ret.next;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ret = new ListNode();

            int carry = 0;
            ListNode loop = ret;
            while (l1 != null || l2 != null) {
                int one = getValue(l1);
                int two = getValue(l2);

                int sum = one + two + carry;
                int cur = sum % 10;
                carry = sum / 10;

                loop.next = new ListNode(cur);
                loop = loop.next;

                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            if (carry == 1) {
                loop.next = new ListNode(carry);
            }

            return ret.next;
        }

        public int getValue(ListNode listNode) {
            if (listNode == null) {
                return 0;
            } else {
                return listNode.val;
            }
        }
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
}
