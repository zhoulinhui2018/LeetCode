package LeetCode_2021_10.LeetCode_1005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/12/3
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<State> priorityQueue = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            priorityQueue.add(new State(i,num));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (k-->0){
            State poll = priorityQueue.poll();
            list.add(poll.index);
        }
        for (Integer index : list) {
            nums[index] = -nums[index];
        }
        return Arrays.stream(nums).sum();
    }

    class State {
        int index;
        int val;

        State(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

}

