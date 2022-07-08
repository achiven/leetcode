package com.company

fun main() {
    val solution = Solution_97_Interleaving_String()

    println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"))
//    println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"))
//    println(solution.isInterleave("a", "b", "ab"))
//    println(solution.isInterleave("aa", "ab", "abaa"))
//    println(solution.isInterleave("abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb", "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc", "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"))

}

class Solution_97_Interleaving_String {
//    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
//        val len1 = s1.length
//        val len2 = s2.length
//        val len3 = s3.length
//        val dp = Array(len1 + 1) { BooleanArray(len2 + 1) { false } }
//
//        if (s3.isEmpty() and s1.isEmpty() and s2.isEmpty()) {
//            return true
//        }
//
//        if (s3.length != (s1.length + s2.length)) {
//            return false
//        }
//
//        if (s1.isEmpty() || s2.isEmpty()) {
//            return (s1 + s2) == s3
//        }
//
//
//        for (i in 0 until len1 + 1) {
//            for (j in 0 until len2 + 1) {
//                if (i == 0 && j == 0) {
//                    dp[0][0] = true
//                } else if (i == 0) {
//                    if (s2[j - 1] == s3[j - 1] && dp[0][j - 1]) dp[0][j] = true
//                } else if (j == 0) {
//                    if (s1[i - 1] == s3[i - 1] && dp[i - 1][0]) dp[j][0] = true
//                } else {
//                    val char1 = s1[i - 1]
//                    val char2 = s2[j - 1]
//                    val char3 = s3[i + j - 1]
//
//                    if (char1 == char3 && dp[i - 1][j]) dp[i][j] = true
//                    if (char2 == char3 && dp[i][j - 1]) dp[i][j] = true
//                }
//
//            }
//        }
//
//
//        return dp[len1][len2]
//    }
//
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        val len3 = s3.length
        if (len3 != len1 + len2) return false
        if (len1 == 0) return s2 == s3
        if (len2 == 0) return s1 == s3

        // dp[i][j] is true if the first i chars from s1 and first j chars from s2
        // can interleave to produce first i + j chars of s3
        val dp = Array(len1 + 1) { BooleanArray(len2 + 1) }
        for (i in 0..len1) {
            for (j in 0..len2) {
                if (i == 0 && j == 0) {
                    dp[0][0] = true
                }
                else if (i == 0) {
                    if (s2[j - 1] == s3[j - 1] && dp[0][j - 1]) dp[0][j] = true
                } else if (j == 0) {
                    if (s1[i - 1] == s3[i - 1] && dp[i - 1][0]) dp[i][0] = true
                } else {
                    val char1 = s1[i - 1]
                    val char2 = s2[j - 1]
                    val char3 = s3[i + j - 1]
                    if (char1 == char3 && dp[i - 1][j]) dp[i][j] = true
                    if (char2 == char3 && dp[i][j - 1]) dp[i][j] = true
                }
            }
        }
        return dp[len1][len2]
    }
}