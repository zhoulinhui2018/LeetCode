package LeetCode_2020_01.LeetCode_003;

import java.util.HashMap;
import java.util.Map;

public class test_01 {
}

class Solution{
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        int n=s.length();
        for (int i=0,j=0;j<n;j++){
            if (map.containsKey(s.charAt(j))){
                i=Math.max(i,map.get(s.charAt(j)));
            }
            ans=Math.max(ans, j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }
}
