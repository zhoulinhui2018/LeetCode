package LeetCode_2020_01.LeetCode_020;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    private HashMap<Character,Character> map;
    public Solution(){
        this.map=new HashMap<Character, Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        map.put('#','#');
    }

    public boolean isValid(String s) {
        if (s.equals("")){
            return true;
        }
        Stack<Character> stack=new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)){
                stack.push(c);
            }else {
                Character character=stack.isEmpty()?'#':stack.pop();
                if (map.get(character)!=c){
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
