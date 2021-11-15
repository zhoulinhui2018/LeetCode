package LeetCode_2021_02.Leetcode_438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int valid=0;
        int left=0,right=0;
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        while (right<s.length()){
            char c1 = s.charAt(right);
            right++;
            if (need.containsKey(c1)){
                window.put(c1, window.getOrDefault(c1,0)+1);
                if (window.get(c1).equals(need.get(c1))){
                    valid++;
                }
            }
            while (right-left==p.length()){
                if (valid==need.size()){
                    ans.add(left);
                }
                char c2=s.charAt(left);
                left++;
                if (need.containsKey(c2)){
                    if (window.get(c2).equals(need.get(c2))){
                        valid--;
                    }
                    window.put(c2,window.get(c2)-1);
                }
            }
        }
        return ans;
    }
}
