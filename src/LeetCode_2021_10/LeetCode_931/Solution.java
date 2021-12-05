package LeetCode_2021_10.LeetCode_931;

import java.util.Arrays;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/12/4
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = j == 0 ? 99999 : dp[i - 1][j - 1];
                int b = dp[i - 1][j];
                int c = j == n - 1 ? 99999 : dp[i - 1][j + 1];
                dp[i][j] = matrix[i][j] + min(a, b, c);
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
