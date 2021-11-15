package LeetCode_2021_05.LeetCode_528;

import java.util.Random;

public class Solution {
    private int sum=0;
    private int[] weight;
    public Solution(int[] w) {
        for (int i : w) {
            sum+=i;
        }
        weight=w;
    }

    public int pickIndex() {
        Random random = new Random();
        int rand = random.nextInt(sum) + 1;
        for (int i = 0; i < weight.length; i++) {
            int wei = weight[i];
            if (rand-wei>0){
                rand=rand-wei;
            }else {
                return i;
            }
        }
        return -1;
    }
}
