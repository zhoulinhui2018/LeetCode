package LeetCode_2021_10.LeetCode_907;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/11/20
 */
public class Solution2 {

    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;

        // 第 1 步：计算当前下标 i 的左边第 1 个比 A[i] 小的元素的下标
        Deque<Integer> stack1 = new ArrayDeque<>();
        int[] prev = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack1.isEmpty() && A[i] <= A[stack1.peekLast()]) {
                stack1.removeLast();
            }
            prev[i] = stack1.isEmpty() ? -1 : stack1.peekLast();
            stack1.addLast(i);
        }

        // 第 2 步：计算当前下标 i 的右边第 1 个比 A[i] 小的元素的下标
        Deque<Integer> stack2 = new ArrayDeque<>();
        int[] next = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && A[i] < A[stack2.peekLast()]) {
                stack2.removeLast();
            }
            next[i] = stack2.isEmpty() ? N : stack2.peekLast();
            stack2.addLast(i);
        }

        // 第 3 步：计算结果
        long ans = 0;
        for (int i = 0; i < N; ++i) {
            // 注意：乘法可能越界，须要先转成 long 类型
            ans += (long) (i - prev[i]) * (next[i] - i) % MOD * A[i] % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }

    public int[] getLastSmaller(int[] A){
        int N = A.length;
        Deque<Integer> stack1 = new ArrayDeque<>();
        int[] prev = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack1.isEmpty() && A[i] <= A[stack1.peekLast()]) {
                stack1.removeLast();
            }
            prev[i] = stack1.isEmpty() ? -1 : stack1.peekLast();
            stack1.addLast(i);
        }
        return prev;
    }

    public int[] getNextSmaller(int[] A){
        int N = A.length;
        Deque<Integer> stack2 = new ArrayDeque<>();
        int[] next = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && A[i] < A[stack2.peekLast()]) {
                stack2.removeLast();
            }
            next[i] = stack2.isEmpty() ? N : stack2.peekLast();
            stack2.addLast(i);
        }
        return next;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] arr   = new int[]{2, 1, 3, 1};
//        int[] arr = {2, 1, 3, 1};
        int[] nextSmaller = solution2.getNextSmaller(arr);
        int[] lastSmaller = solution2.getLastSmaller(arr);

        System.out.println(Arrays.toString(lastSmaller));
        System.out.println(Arrays.toString(nextSmaller));

        int ans = solution2.sumSubarrayMins(arr);
        System.out.println(ans);
    }
}

