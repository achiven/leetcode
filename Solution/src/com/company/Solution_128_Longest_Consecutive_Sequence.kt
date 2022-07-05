package com.company

class Solution_128_Longest_Consecutive_Sequence {

    fun main() {

    }

    class Solution {
        fun longestConsecutive(nums: IntArray): Int {
            val setArray = nums.toSet()

            var longestConsecutiveSequence = 0
            for (num in setArray) {
                if (!setArray.contains(num -1)) {
                    var currentSequence = 0
                    var currentNum = num

                    while (setArray.contains(currentNum)) {
                        currentNum++
                        currentSequence++
                    }

                    if (longestConsecutiveSequence < currentSequence) {
                        longestConsecutiveSequence = currentSequence
                    }
                }
            }

            return longestConsecutiveSequence
        }
    }
}