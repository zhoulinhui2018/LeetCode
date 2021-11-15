package LeetCode_2021_03.Leetcode_416;

import java.security.interfaces.ECKey;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%2==1){
            return false;
        }
        int target=sum/2;
        boolean [][]dp=new boolean[nums.length+1][target+1];
        for (int i=0;i<=nums.length;i++){
            dp[i][0]=true;
        }

        for (int i=1;i<=nums.length;i++){
            for (int j=1;j<=target;j++){
                if (j<nums[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    D[i][j]=D[i-1][j-1];
                }else {
                    int left = D[i - 1][j] + 1;
                    int down = D[i][j - 1] + 1;
                    int left_down = D[i - 1][j - 1];
                    D[i][j] = Math.min(left, Math.min(down, left_down));
                }
            }
        }
        return D[n][m];
    }

}
