package 力扣刷题.热题榜.正则表达式匹配;

public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] booleans = new boolean[m + 1][n + 1];
        booleans[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    booleans[i][j] = booleans[i][j - 2];
                    if (match(i, j - 1, s, p)) {
                        booleans[i][j] = booleans[i][j] || booleans[i - 1][j];
                    }
                } else {
                    booleans[i][j] = booleans[i - 1][j - 1];
                }
            }
        }
        return booleans[m][n];
    }

    public boolean match(int i, int j, String s, String p) {
        //去掉会怎样
        if (i == 0)
            return false;
        if (p.charAt(j - 1) == '.')
            return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
