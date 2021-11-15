package LeetCode_2021_04.LeetCode_88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0){
            return;
        }
        int[] temp = new int[m + n];
        int i=0,j=0,k=0;
        while (i<m&&j<n){
            if (nums1[i]<=nums2[j]){
                temp[k++]=nums1[i++];
            }else {
                temp[k++]=nums2[j++];
            }
        }
        if (i<m){
            System.arraycopy( nums1,i,temp,k,k-i);
        }
        if (j<n){
            System.arraycopy(nums2,j,temp,k,n-j);
        }
        for (int h=0;h<m+n;h++){
            nums1[h]=temp[h];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []num1={1};
        int[] num2={};
        solution.merge(num1,1,num2, 0);
    }
}
