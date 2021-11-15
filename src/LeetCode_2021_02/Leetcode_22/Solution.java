package LeetCode_2021_02.Leetcode_22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("",0,0,n);
        return ans;
    }

    void dfs(String s,int left,int right,int num){
        if (left<right){
            return;
        }
        if (left==num&&right==num){
            ans.add(s);
            return;
        }
        if (left<num){
            dfs(s+"(",left+1,right,num);
        }
        if (right<num){
            dfs(s+")",left, right+1, num);
        }
    }
}
