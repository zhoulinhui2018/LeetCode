package LeetCode_2020_01.LeetCode_006;

import java.util.ArrayList;
import java.util.List;

public class test_01 {
}


class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        List<StringBuffer> rows = new ArrayList<>();
        for (int i=0;i<Math.min(numRows,s.length());i++){
            rows.add(new StringBuffer());
        }
        boolean goingDown=false;
        int currRow=0;
        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if (currRow==0||currRow==numRows-1){
                goingDown=!goingDown;
            }
            currRow+=goingDown?1:-1;
        }
        StringBuffer ret=new StringBuffer();
        for (StringBuffer row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}