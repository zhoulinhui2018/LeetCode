package LeetCode_2021_03.Leetcode_415;

import java.util.Collections;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m=triangle.get(0).size();
        int [][]dp=new int[n][m];
        dp[0][0]=triangle.get(0).get(0);
        int ans = Integer.MAX_VALUE;
        for (int i=1;i<n;i++){
            for (int j=0;j<=i;j++){
                if (j==0){
                    dp[i][j]=triangle.get(i).get(j)+dp[i-1][j];
                }else if (j==i){
                    dp[i][j]=triangle.get(i).get(j)+dp[i-1][j-1];
                }else {
                    dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
                if (i==n-1){
                    ans=Math.min(ans,dp[i][j]);
                }
            }
        }

        return ans;
    }
}
