package com.friend.partnermatching.utils;

import java.util.List;

/**
 * 算法工具类
 */
public class AlgorithmUtils {

    public static long minDistance(List<String> tagList1, List<String> tagList2) {
        int m = tagList1.size();
        int n = tagList2.size();

        if (m * n == 0) { //有一个串是空串
            return m + n;
        }

        long[][] dp = new long[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (tagList1.get(i - 1).equals(tagList2.get(j - 1))) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1] - 1)) + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }

//    public static int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//
//        if (m * n == 0) { //有一个串是空串
//            return m + n;
//        }
//
//        int[][] dp = new int[m + 1][n + 1];
//
//        for (int i = 0; i <= m; i++) {
//            dp[i][0] = i;
//        }
//
//        for (int j = 0; j <= n; j++) {
//            dp[0][j] = j;
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1] - 1)) + 1;
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
//                }
//            }
//        }
//
//        return dp[m][n];
//    }
}
