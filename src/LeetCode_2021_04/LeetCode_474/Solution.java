package LeetCode_2021_04.LeetCode_474;

public class Solution{
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        int[] mm = new int[strs.length];
        int[] nn = new int[strs.length];
        for (int i=0;i<strs.length;i++) {
            int[] count = count(strs[i]);
            mm[i]=count[0];
            nn[i]=count[1];
        }
        for (int i=1;i<=strs.length;i++){
            for (int j=0;j<=m;j++){
                for (int k=0;k<=n;k++){
                    dp[i][j][k]=dp[i-1][j][k];
                    if (j-mm[i-1]>=0&&k-nn[i-1]>=0){
                        dp[i][j][k]= Math.max(dp[i][j][k],1+dp[i-1][j-mm[i-1]][k-nn[i-1]]);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    int[] count(String s){
        int count1=0,count0=0;
        for (char c : s.toCharArray()) {
            if (c=='0'){
                count0++;
            }else {
                count1++;
            }
        }
        return new int[]{count0,count1};
    }
}
