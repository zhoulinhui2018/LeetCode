package LeetCode_2021_05.LeetCode_112;

import LeetCode_2021_05.TreeNode;

public class Solution {
    private boolean ans=false;
    private int target=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        target=targetSum;
        dfs(root,0);
        return ans;
    }

    void dfs(TreeNode root,int cursum){
        if (root==null){
            return;
        }
        cursum+=root.val;

        if (root.left==null&&root.right==null){
            if (cursum==target){
                ans=true;
            }
            return;
        }
        dfs(root.left,cursum);
        dfs(root.right,cursum);
    }

    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m][n];

        int ans=0;

        for (int i=0;i<m;i++){
            if (A[i]==B[0]){
                dp[i][0]=1;
            }
        }

        for (int i=0;i<n;i++){
            if (A[0]==B[i]){
                dp[0][i]=1;
            }
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (A[i]==B[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]= 0;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }

        return ans;
    }
}
