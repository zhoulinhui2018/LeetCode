package LeetCode_2020_01.LeetCode_005;

public class test_01 {
}

class Solution {
    public String longestPalindrome(String s) {
        if (s==null||s.length()==0){
            return "";
        }
        int start=0,end=0;
        for (int i=0;i<s.length();i++){
            int l1=extendFromCenter(s,i,i);
            int l2=extendFromCenter(s,i,i+1);
            int l=Math.max(l1,l2);
            if (l>end-start){
                start=i-(l-1)/2;
                end=i+l/2;
            }
        }return s.substring(start,end+1);
    }

    private int extendFromCenter(String s,int left,int right){
        int l=left,r=right;
        while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}