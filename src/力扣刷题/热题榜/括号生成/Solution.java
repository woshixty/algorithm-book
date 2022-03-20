package 力扣刷题.热题榜.括号生成;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        StringBuilder string = new StringBuilder();
        deep(result, string, n, n);
        return result;
    }

    public void deep(List<String> result, StringBuilder string, int left, int right) {
        if (left > right)
            return;
        if (left == 0 && right == 0) {
            result.add(string.toString());
            return;
        }
        if (left > 0) {
            deep(result, string.append('('), left - 1, right);
            string.deleteCharAt(string.length() - 1);
        }
        if (right > 0) {
            deep(result, string.append(')'), left, right - 1);
            string.deleteCharAt(string.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
