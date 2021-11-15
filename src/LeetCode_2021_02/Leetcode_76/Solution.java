package LeetCode_2021_02.Leetcode_76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need=new HashMap<>(),window=new HashMap<>();
        int valid=0;
        int left=0,right=0;
        int start=0,len=Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) +1);
        }
        while (right<s.length()){
            char c=s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (valid==need.size()){
                //TODO 更新
                if (right-left<len){
                    start=left;
                    len = right-left;
                }

                char c1=s.charAt(left);
                left++;
                if (need.containsKey(c1)){
                    if (need.get(c1).equals(window.get(c1))){
                        valid--;
                    }
                    window.put(c1,window.get(c1)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }


}
