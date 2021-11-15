package LeetCode_2021_03.Leetcode_767;

import java.util.HashMap;

public class Solution {
    private boolean found=false;
    private String ans="";
    public String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c,map.getOrDefault(c, 0)+1);
        }
        int length = S.length();
        dfs("",length, map);
        return ans;
    }

    void dfs(String path,int n,HashMap<Character, Integer> map){
        if (found){
            return;
        }
        if (path.length()==n){
            ans=path;
            found=true;
            return;
        }
        char c='*';
        if (path.length()>0){
            c = path.charAt(path.length() - 1);
        }
        for (Character o : map.keySet()) {
            if (map.get(o)>0&& !o.equals(c)){
                map.put(o, map.get(o)-1);
                dfs(path+o,n, map);
                map.put(o,map.get(o)+1);
            }
        }
    }
}
