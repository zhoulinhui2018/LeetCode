package LeetCode_2021_04.LeetCode_692;

import java.util.*;

public class Solution {
    private Map<String,Integer> map=new HashMap<>();
    private Queue<String> priorityQueue= new PriorityQueue<>((a, b) ->
            map.get(a) - map.get(b) != 0 ? map.get(a) - map.get(b) : a.compareTo(b));
    public List<String> topKFrequent(String[] words, int k) {
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for (String s : map.keySet()) {
            priorityQueue.offer(s);
            if (priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        while (priorityQueue.size()>0){
            ans.add(priorityQueue.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
