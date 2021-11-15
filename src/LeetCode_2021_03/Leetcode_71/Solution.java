package LeetCode_2021_03.Leetcode_71;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] split = path.split("/");
        for (String item : split) {
            if (item.equals("..")) {
                if (!stack.isEmpty()) {stack.pollLast();}
            } else if (!item.isEmpty() && !item.equals(".")) {stack.offer(item);}
        }
        String res = "";
        for (String d : stack) {
            res =  res+"/" + d;
        }
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.simplifyPath("//a/b/../c/e/./f");
        System.out.println(s);
    }
}
