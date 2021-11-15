package LeetCode_2021_03.Leetcode_224;

import java.util.*;

public class Solution {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : chars) {
            queue.offer(c);
        }
        return calculateHelper(queue);
    }

    int calculateHelper(Deque<Character> queue){
        char sign='+';
        int num=0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (!queue.isEmpty()){
            char c = queue.pollFirst();
            if (Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if (c=='('){
                num = calculateHelper(queue);
            }
            if (!Character.isDigit(c)&&c!=' '||queue.isEmpty()){
                switch (sign){
                    case '+':
                        stack.offer(num);
                        break;
                    case '-':
                        stack.offer(-num);
                        break;
                    default:
                }
                num=0;
                sign=c;
            }
            if (c==')'){
                break;
            }
        }
        int ans=0;
        for (Integer integer : stack) {
            ans+=integer;
        }
        return ans;
    }
}
