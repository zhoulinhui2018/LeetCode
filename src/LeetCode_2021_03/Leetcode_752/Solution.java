package LeetCode_2021_03.Leetcode_752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue=new LinkedList<>();
        int step=0;
        queue.offer("0000");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            String deadend = deadends[i];
            set.add(deadend);
        }
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                String cur = queue.poll();
                if (set.contains(cur)){
                    continue;
                }
                if (cur.equals(target)){
                    return step;
                }

                for (int j=0;j<4;j++){
                    String plusStr = plusone(cur, j);
                    if (!visited.contains(plusStr)){
                        queue.offer(plusStr);
                        visited.add(plusStr);
                    }
                    String minusStr = minusone(cur, j);
                    if (!visited.contains(minusStr)){
                        queue.offer(minusStr);
                        visited.add(minusStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    String plusone(String s,int i){
        char[] chars = s.toCharArray();
        if (chars[i]=='9'){
            chars[i]='0';
        }else {
            chars[i]+=1;
        }

        return new String(chars);
    }

    String minusone(String s,int i){
        char[] chars = s.toCharArray();
        if (chars[i]=='0'){
            chars[i]='9';
        }else {
            chars[i]-=1;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.openLock(new String[]{"8888"}, "0009");
        System.out.println(i);
    }
}
