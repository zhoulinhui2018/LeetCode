package LeetCode_2021_03.Leetcode_1415;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    private int kk;
    private String ans="";
    public String getHappyString(int n, int k) {
        StringBuilder path = new StringBuilder();
        this.kk=k;
        dfs(0,n,path);
        return ans;
    }

    void dfs(int index,int n,StringBuilder path){
        if(index==n){
            kk--;
            if (kk==0){
                ans=path.toString();
            }
            return;
        }
        for (int i=0;i<3;i++){

            if (path.length()>0&&'a'+i==path.charAt(path.length()-1)){
                continue;
            }
            path.append((char)('a'+i));
            dfs(index+1,n,path);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String happyString = solution.getHappyString(3, 9);
        System.out.println(happyString);
    }
}
