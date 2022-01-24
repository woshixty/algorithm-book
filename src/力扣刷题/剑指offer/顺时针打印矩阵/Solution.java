package 力扣刷题.剑指offer.顺时针打印矩阵;

public class Solution {
    /**
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sum = m * n;
        int[] res = new int[sum];
        int i, j, k, l = 0;
        for (i = 0; i < m; i++) {

            for (j = i; j < n; j++)
                res[l++] = matrix[i][j];

            for (k = i; k < m; k++)
                res[l++] = matrix[k][j];

            for (k = m - 1; k >= i; j--)
                res[l++] = matrix[i][k];

            for (; j > i; j--)
                res[l++] = matrix[i][j];

            m--;
            n--;
        }
        return res;
    }
     */

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
}
