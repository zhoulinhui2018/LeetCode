package LeetCode_2021_03.Leetcode_329;

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] visit = new int[m][n];
        int[][] memo = new int[m][n];
        int ans=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int dfs = dfs(i, j, m, n, matrix, visit, -1, memo);
                ans=Math.max(ans,dfs);
            }
        }
        return ans;
    }

    int dfs(int i,int j,int m,int n,int[][] matrix,int[][] visit,int last,int[][] memo){
        if (i<0||i>=m||j<0||j>=n||matrix[i][j]<=last||visit[i][j]==1){
            return 0;
        }
        if (memo[i][j]!=0){
            return memo[i][j];
        }
        visit[i][j]=1;
        int left=dfs(i,j-1,m, n,matrix,visit, matrix[i][j],memo);
        int right=dfs(i,j+1,m, n,matrix,visit, matrix[i][j],memo);
        int up=dfs(i-1,j,m, n,matrix,visit, matrix[i][j],memo);
        int down=dfs(i+1,j,m, n,matrix,visit, matrix[i][j],memo);
        visit[i][j]=0;
        int max = Math.max(Math.max(left, right), Math.max(up, down));
        memo[i][j]= max +1;
        return max +1;
    }
}
