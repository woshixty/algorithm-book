package 力扣刷题.热题榜.Z字形变换;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> str = new ArrayList<>();
        for (int i = 0; i <numRows; i++)
            str.add(new StringBuilder());
        int flag = 1;
        int point = 0;
        for (int i = 0; i < s.length(); i++) {
            str.get(point).append(s.charAt(i));
            point += flag;
            if (point == 0 || point == numRows - 1)
                flag = -flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : str)
            result.append(stringBuilder);
        return result.toString();
    }

    public static void main(String[] args) {
        new Solution().convert("PAYPALISHIRING", 3);
    }
}
