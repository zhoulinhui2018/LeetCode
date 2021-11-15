package LeetCode_2021_02.Leetcode_70;

public class Solution {
    public int climbStairs(int n) {
        if (n<=2){
            return n;
        }
        int n1=1,n2=1;
        for (int i=1;i<n;i++){
            int temp=n1+n2;
            n1=n2;
            n2=temp;
        }
        return n2;
    }
}
