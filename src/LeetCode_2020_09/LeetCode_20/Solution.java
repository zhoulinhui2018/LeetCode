package LeetCode_2020_09.LeetCode_20;

import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque=new ArrayDeque<>();
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (char c : s.toCharArray()) {
            if (c=='('||c=='{'||c=='['){
                deque.offer(c);
            }else {
                char d=map.get(c);
                char e='a';
                if (!deque.isEmpty()){
                    e=deque.pollLast();
                }

                if (d!=e){
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s="([)]";
        Solution solution=new Solution();
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }
}