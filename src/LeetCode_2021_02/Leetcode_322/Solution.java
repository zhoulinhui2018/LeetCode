package LeetCode_2021_02.Leetcode_322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int []dp=new int[amount+1];
        Arrays.fill(dp,amount+1 );
        dp[0]=0;
        for (int i=1;i<=amount;i++){
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i-coin>=0){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
