package LeetCode_2020_01.LeetCode_011;

public class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        double maxArea=0;
        double currArea=0;
        while (left<right){
            currArea=(right-left)*(height[left]<=height[right]?height[left]:height[right]);
            maxArea=Math.max(maxArea,currArea);
            if (height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
        }return (int)maxArea;
    }


        public int maxArea2(int[] height) {
            int maxarea = 0, l = 0, r = height.length - 1;
            while (l < r) {
                maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
                if (height[l] < height[r]) {
                    l++;
                }
                else{
                    r--;
                }
            }
            return maxarea;
        }



}
