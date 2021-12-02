package LeetCode_2021_10.LeetCode_875;

import java.util.Arrays;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/11/25
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = (int) 1e9;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (calTime(piles, mid) < h) {
                right = mid - 1;
            } else if (calTime(piles, mid) > h) {
                left = mid + 1;
            } else if (calTime(piles, mid) == h) {
                right = mid - 1;
            }
        }
        return left;
    }

    public int calTime(int[] piles, int k) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            int pile = piles[i];
            time += pile / k;
            if (pile % k > 0) {
                time++;
            }
        }
        return time;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (calDay(weights, mid) < days) {
                right = mid - 1;
            } else if (calDay(weights, mid) > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int calDay(int[] weights, int carry) {
        int day = 0;
        int curWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];
            if (curWeight + weight > carry) {
                day++;
                curWeight = weight;
                continue;
            }
            curWeight += weight;
        }
        return day + 1;
    }


    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(nums, mid) < m) {
                right=mid-1;
            } else if (f(nums, mid) > m) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return left;
    }

    private int f(int[] nums, int k) {
        int ans = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (sum + num > k) {
                sum = 0;
                ans++;
            }
            sum += num;
        }
        return ans;
    }



    public int minTime(int[] time, int m) {
        int left = Arrays.stream(time).max().getAsInt();
        int right = Arrays.stream(time).sum();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f2(time, mid) < m) {
                right=mid-1;
            } else if (f2(time, mid) > m) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return left;
    }

    private int f2(int[] nums, int k) {
        int ans = 1;
        int sum = 0;
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            maxValue = Math.max(maxValue,num);
            if (sum + num - maxValue > k) {
                sum = 0;
                maxValue = num;
                ans++;
            }
            sum += num;
        }
        return ans;
    }



}
