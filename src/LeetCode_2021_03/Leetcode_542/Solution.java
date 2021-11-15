package LeetCode_2021_03.Leetcode_542;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static int[][] direct={{-1,0},{1,0},{0,-1},{0,1}};

    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] ans = new int[m][n];
        Queue<Point> queue=new LinkedList<>();
        int depth=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]==0){
                    queue.offer(new Point(i,j));
                }
            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                Point poll = queue.poll();
                int x=poll.x;
                int y=poll.y;
                for (int j=0;j<4;j++){
                    int xx=x+direct[j][0];
                    int yy=y+direct[j][1];
                    if (xx>=0&&xx<m&&yy>=0&&yy<n&&matrix[xx][yy]!=0){
                        ans[xx][yy]=depth+1;
                        matrix[xx][yy]=0;
                        queue.offer(new Point(xx,yy));
                    }
                }
            }
            depth++;
        }

        return ans;
    }

    class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix={{0,0,0},{0,1,0},{0,0,0}};
        int[][] ans = solution.updateMatrix(matrix);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}
