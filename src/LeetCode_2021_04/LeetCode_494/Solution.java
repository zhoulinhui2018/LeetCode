package LeetCode_2021_04.LeetCode_494;

import javafx.scene.layout.Priority;

import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target+1];

        for (int j=0;j<=target;j++){
            if (nums[j]==target){
                dp[1][j]=1;
            }
        }

        for (int i=2;i<=nums.length;i++){
            for (int j=0;j<=target;j++){
                if (j-nums[i-1]>=0&&j+nums[i-1]<=target){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j + nums[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j + nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        System.out.println(Integer.compare(1, 2));
        List<String> strings = Arrays.asList("a", "b", "c","aa");
        Collections.sort(strings,(a,b)->
                a.compareTo(b));
        for (String string : strings) {
            System.out.println(string);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((a,b)->b.compareTo(a));
        queue.add("a");
        queue.add("b");
        queue.add("c");
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
