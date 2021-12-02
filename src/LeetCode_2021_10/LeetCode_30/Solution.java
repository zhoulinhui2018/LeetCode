package LeetCode_2021_10.LeetCode_30;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/11/24
 */
public class Solution {

    Set<String> set = new HashSet<>();
    List<String> path = new ArrayList<>();

    public Set<String> permute(String[] words) {
        boolean[] used = new boolean[words.length];
        int len = words.length;
        if (len == 0) {
            return set;
        }
        dfs(0, len, path, used, words);
        return set;
    }

    private void dfs(int index, int len, List<String> path, boolean[] used, String[] words) {
        if (index == len) {
            String collect = String.join("", path);
            set.add(collect);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(words[i]);
            dfs(index + 1, len, path, used, words);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    HashMap<String, Integer> map = new HashMap<>();
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int left = 0,right =0;
        int length = s.length();
        int one_length = words[0].length();
        int all_length = one_length * words.length;
        while (right<length){
            right++;
            while (right-left==all_length){
                //TODO
                String substring = s.substring(left, right);
                HashMap<String, Integer> map1 = computeMap(substring,one_length);
                if (map.equals(map1)){
                    ans.add(left);
                }
                left++;
            }
        }
        return ans;
    }

    private HashMap<String,Integer> computeMap(String string,int len) {
        HashMap<String, Integer> ret = new HashMap<>();
        for (int i = 0; i+len < string.length()+1; i+=len) {
            String substring = string.substring(i, i + len);
            ret.put(substring,ret.getOrDefault(substring,0)+1);
            if (ret.get(substring)>map.getOrDefault(substring,0)){
                return null;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"foo","bar"};
        List<Integer> barfoothefoobarman = solution.findSubstring("barfoothefoobarman", strings);
        System.out.println(barfoothefoobarman);
    }
}
