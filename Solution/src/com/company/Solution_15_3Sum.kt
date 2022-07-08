package com.company

fun main() {
    val solution: Solution_15_3Sum.Solution = Solution_15_3Sum.Solution()

    println(solution.threeSum(listOf(0, 0, 0, 0).toIntArray()))
    println(solution.threeSum(listOf(1, -1, -1, 0).toIntArray()))

}

class Solution_15_3Sum {

    class Solution {
        fun threeSum(nums: IntArray): List<List<Int>> {
            val ret: ArrayList<List<Int>> = ArrayList()

            nums.sort()

            if (nums.size <= 2) {
                return ret
            }

            for (i in nums.indices) {
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                    var left = i + 1
                    var right = nums.size - 1

                    while (left < right) {
                        val candidate = nums[left] + nums[i] + nums[right]
                        if (candidate == 0) {
                            ret.add(listOf(nums[i], nums[left], nums[right]))

                            while (left < right && nums[left + 1] == nums[left])
                                left++
                            while (left < right && nums[right - 1] == nums[right])
                                right--
                            left++
                            right--
                        } else if (candidate > 0) {
                            right--
                        } else {
                            left++
                        }
                    }
                }

            }

            return ret
        }
    }
}