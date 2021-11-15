package LeetCode_2021_04.LeetCode_85;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] left = new int[m][n];
        for (int i=0;i<m;i++){
            left[i][0]=matrix[i][0]=='1'?1:0;
        }
        for (int i=0;i<m;i++){
            for (int j=1;j<n;j++){
                left[i][j]=matrix[i][j]=='0'?0:left[i][j-1]+1;
            }
        }
        int ans=0;
        for(int j=0;j<n;j++){
            int[] down = new int[m];
            int[] up = new int[m];
            Arrays.fill(down,m);
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i=0;i<m;i++){
                int cur=left[i][j];
                while (!stack.isEmpty()&&left[stack.peekLast()][j]>=cur){
                    down[stack.peekLast()]=i;
                    stack.pollLast();
                }
                up[i]=stack.isEmpty()?-1:stack.peekLast();
                stack.offer(i);
            }
            for (int i=0;i<m;i++){
                int temp=left[m][j]*(down[m]-up[m]-1) ;
                ans=Math.max(ans,temp);
            }
        }
        return ans;
    }
}
