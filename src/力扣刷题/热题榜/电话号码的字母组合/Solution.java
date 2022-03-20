package 力扣刷题.热题榜.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    final char[][] map = new char[][] {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        /**
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
         */
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        traverse(digits, 0, result, stringBuilder);
        return result;
    }

    public void traverse(String digits, int position, List<String> result, StringBuilder stringBuilder) {
        if (position == digits.length()) {
            result.add(stringBuilder.toString());
        } else {
            final int now = digits.charAt(position) - '2';
            for (int i = 0; i < map[now].length; i++) {
                stringBuilder.append(map[now][i]);
                traverse(digits, position + 1, result, stringBuilder);
                stringBuilder.deleteCharAt(position);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().letterCombinations("");
    }
}
