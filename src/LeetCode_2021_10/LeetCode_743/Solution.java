package LeetCode_2021_10.LeetCode_743;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/11/18
 */
public class Solution {
    public static final int N = 110;
    private int[][] graph;
    private int[] dist ;
    private boolean[] visit;
    //这里除以2 是为了避免可能发生的相加溢出
    private static final int INF = Integer.MAX_VALUE/2;

    public int networkDelayTime(int[][] times, int n, int k) {
        graph =new int[n+1][n+1];
        dist = new int[n+1];
        visit  = new boolean[n+1];
        Arrays.fill(dist,INF);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                 graph[i][j] = graph[j][i] = (i==j?0:INF);
            }
        }
        for (int[] time : times) {
            int u=time[0];
            int v=time[1];
            graph[u][v]=time[2];
        }
        
        dist[k]=0;
        for (int i = 0; i < n; i++) {
            int u=-1,minVal=INF;
            for (int j = 1; j <= n; j++) {
                if (!visit[j]&&dist[j]<minVal){
                    minVal = dist[j];
                    u = j;
                }
            }
            if (u==-1){
                break;
            }
            visit[u]=true;
            for (int v = 1; v <= n; v++) {
                 if (!visit[v]&&graph[u][v]!=INF){
                     dist[v]=Math.min(dist[v],graph[u][v]+dist[u]);
                 }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i]>ans){
                ans=dist[i];
            }
        }
        return ans==INF?-1:ans;
    }


}
