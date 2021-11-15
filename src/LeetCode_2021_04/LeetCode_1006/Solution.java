package LeetCode_2021_04.LeetCode_1006;

public class Solution implements Cloneable{
    public int clumsy(int N) {
        int cur=N;
        for (int i=0;i<N-1;i++){
            int temp=N-i-1;
            switch (i%4){
                case 0:
                    cur=cur*temp;
                    break;
                case 1:
                    cur=cur/temp;
                    break;
                case 2:
                    cur=cur+temp;
                    break;
                case 3:
                    cur=cur-temp;
                    break;
                default:
            }
        }
        return cur;
    }

    public int trap(int[] height) {
        int n = height.length;
        if (height.length==0){
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0]=0;
        for (int i = 1; i < height.length; i++) {
            left[i]=Math.max(left[i-1],height[i-1]);
        }
        right[n-1]=0;
        for (int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i+1]);
        }
        int ans=0;
        for (int i = 1; i < height.length-1; i++) {
            int h = height[i];
            if (Math.min(left[i],right[i])>h){
                ans+=Math.min(left[i],right[i])-h;
            }
        }
        return ans;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Solution solution = new Solution();
        Solution solution1= (Solution) solution.clone();
        int clumsy = solution.clumsy(10);
        System.out.println(clumsy);
    }

}
