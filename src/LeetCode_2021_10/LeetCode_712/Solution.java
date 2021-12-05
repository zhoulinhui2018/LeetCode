package LeetCode_2021_10.LeetCode_712;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/12/4
 */
public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + getAscll(s1.charAt(i - 1));
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + getAscll(s2.charAt(j - 1));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+getAscll(s1.charAt(i-1)),dp[i][j-1]+getAscll(s2.charAt(j-1)));
                }

            }
        }
        return dp[n][m];
    }

    public int getAscll(char c) {
        return c - '\0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getAscll('a'));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c-'a']--;
            if (cnt[c-'a']<0){
                return false;
            }
        }
        return true;
    }

    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            // 按 A 键
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // 全选 & 复制 dp[j-2]，连续粘贴 i - j 次
                // 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        // N 次按键之后最多有几个 A？
        return dp[N];
    }
}


