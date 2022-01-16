package 力扣刷题.剑指offer.礼物的最大价值;

public class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] value = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int max = value[i + 1][j] > value[i][j + 1] ? value[i + 1][j] : value[i][j + 1];
                value[i + 1][j + 1] = grid[i][j] + max;
            }
        }
        return value[m][n];
    }

    public static void main(String[] args) {
        new Solution().maxValue(new int[8][8]);
    }
}
