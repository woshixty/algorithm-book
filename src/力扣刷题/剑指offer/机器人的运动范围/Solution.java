package 力扣刷题.剑指offer.机器人的运动范围;

public class Solution {
    int k;
    boolean[][] visited;
    int m, n;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        this.k = k;
        this.m = m;
        this.n = n;
        return deepVisit(0 ,0 ,0 , 0);
    }

    public int deepVisit(int i, int j, int sumM, int sumN) {
        if (i >= m || j >= n || k < sumM + sumN || visited[i][j])
            return 0;
        visited[i][j] = true;
        int a = (i + 1) % 10 == 0 ? sumM - 8 : sumM + 1;
        int b = (j + 1) % 10 == 0 ? sumN - 8 : sumN + 1;
        return 1 + deepVisit(i + 1, j, a, sumN) + deepVisit(i, j + 1, sumM, b);
    }

    int sums(int x) {
        int s = 0;
        while(x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }
}
