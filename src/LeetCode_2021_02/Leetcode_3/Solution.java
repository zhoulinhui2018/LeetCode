package LeetCode_2021_02.Leetcode_3;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        if (s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0,right=0;
        while (right<s.length()){
            char c1 = s.charAt(right);
            right++;
            map.put(c1,map.getOrDefault(c1,0)+1);
            while (map.get(c1).equals(2)){
                char c2 = s.charAt(left);
                left++;
                map.put(c2, map.get(c2)-1);
            }
            ans=Math.max(ans,right-left);
        }
        return ans;
    }
}
