package LeetCode_2021_03.Leetcode_357;

public class Solution {

    private int ans=0;

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {return 1;}
        int[] used = new int[10];
        dfs(0,n,used);
        return ans+1;
    }

    void dfs(int depth,int n,int[] used){
        if (depth==n){
            return;
        }
        for (int i=0;i<10;i++){
            if (used[i]==1){
                continue;
            }
            if (i==0&&depth==0){
                continue;
            }
            ans++;
            used[i]=1;
            dfs(depth+1,n,used);
            used[i]=0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countNumbersWithUniqueDigits(2);
        System.out.println(i);
    }

}
