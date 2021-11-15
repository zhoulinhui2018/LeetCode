package LeetCode_2020_01.LeetCode_009;

public class Solution {
    public boolean isPalindrome(int x) {
        StringBuffer stringBuffer=new StringBuffer(String.valueOf(x));
        String string= stringBuffer.reverse().toString();
        return string.equals(stringBuffer.reverse().toString());
    }

    public boolean isPalindrome2(int x){
        if (x<0||(x%10)==0&&x!=0){
            return false;
        }
        int revertedNumber=0;
        while (x>revertedNumber){
            revertedNumber=revertedNumber*10+x%10;
            x/=10;
        }
        return x==revertedNumber||revertedNumber/10==x;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isPalindrome2(120));
    }
}
