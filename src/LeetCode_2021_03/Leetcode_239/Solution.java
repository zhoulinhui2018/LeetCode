package LeetCode_2021_03.Leetcode_239;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    class Monotonic{
        Deque deque=new ArrayDeque<Integer>();

        void push(int n){
            while (!deque.isEmpty()&&(int)deque.peekLast()<=n){
                deque.pollLast();
            }
            deque.offer(n);
        }

        int max(){
            return (int)deque.peekFirst();
        }

        void pop(int n){
            if (!deque.isEmpty()&&(int)deque.peekFirst()==n){
                deque.pollFirst();
            }
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int []ans=new int[nums.length-k+1];
        Monotonic monotonic = new Monotonic();
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i<k-1){
                monotonic.push(num);
            }else {
                monotonic.push(num);
                ans[j++]=monotonic.max();
                monotonic.pop(nums[i-k+1]);
            }
        }
        return ans;
    }
}
