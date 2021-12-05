package LeetCode_2021_10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/11/17
 */
public class UnionFind {
    private int count;
    private int[] parent;


    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        // 最初每棵树只有一个节点

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        // 将两棵树合并为一棵
        parent[rootP] = rootQ;
        // parent[rootQ] = rootP 也可以
        count--;
    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

//    private int find(int x) {
//        while (parent[x] != x) {
//            // 进行路径压缩
//            parent[x] = parent[parent[x]];
//            x = parent[x];
//        }
//        return x;
//    }

    private int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    public int minCostConnectPoints(int[][] points) {

        int[][] newPoints = new int[points.length][points.length];
        int N = points.length;
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                newPoints[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                newPoints[j][i] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        //lowcast存放与连接图中顶点的最小值
        int[] lowcast = new int[N];
        List<Integer> count = new ArrayList<>();
        count.add(0);
        lowcast[0] = -1;
        for (int i = 1; i < N; i++) {
            lowcast[i] = newPoints[i][0];
        }
        while (count.size() < N) {
            //选取lowcast数组中与已在图中的顶点最小距离的点
            int minDistance = Integer.MAX_VALUE;
            int flag = 0;
            for (int i = 0; i < N; i++) {
                if (lowcast[i] > 0 && lowcast[i] < minDistance) {
                    flag = i;
                    minDistance = lowcast[i];
                }
            }
            //将选取的点加入图中
            count.add(flag);
            //计入最短距离
            res += minDistance;
            //更新lowcast
            for (int j = 0; j < N; j++) {
                if (j == flag) {
                    lowcast[j] = -1;
                } else {
                    if (lowcast[j] != -1)
                        lowcast[j] = Math.min(lowcast[j], newPoints[j][flag]);
                }
            }
        }
        return res;

    }


}
