package LeetCode_2021_10.LeetCode_1081;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/12/3
 */
public class Solution {
    public String smallestSubsequence(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            cnt[c - 'a']--;
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > c && cnt[stack.peekLast() - 'a'] > 0) {
                stack.pollLast();
            }
            stack.offer(c);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : stack) {
            stringBuffer.append(character);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.smallestSubsequence("abcdabc");
        System.out.println(s);
    }
}
