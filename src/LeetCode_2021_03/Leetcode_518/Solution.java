package LeetCode_2021_03.Leetcode_518;

public class Solution {
    public int change(int amount, int[] coins) {
        int []dp=new int[amount+1];
        dp[0]=1;
        for (int i=1;i<=amount;i++){
            for (int coin : coins) {
                if (i>=coin){
                    dp[i]+=dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
}
