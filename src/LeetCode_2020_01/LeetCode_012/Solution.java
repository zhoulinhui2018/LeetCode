package LeetCode_2020_01.LeetCode_012;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        Map<Integer,String> map=new LinkedHashMap<Integer, String>(){{
            put(1000,"M");
            put(900,"CM");
            put(500,"D");
            put(400,"CD");
            put(100,"C");
            put(90,"XC");
            put(50,"L");
            put(40,"XL");
            put(10,"X");
            put(9,"IX");
            put(5,"V");
            put(4,"IV");
            put(1,"I");
        }};
        StringBuffer ret=new StringBuffer();
        for (Integer key : map.keySet()) {
            while (num>=key){
                num-=key;
                ret.append(map.get(key));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.intToRoman(4));
    }
}
