package 力扣刷题.剑指offer.二维数组中的查找;

public class Solution {
    /**
    //斜对角线的排除，一行一列的排除
    //最小的维度
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //行
        int m = matrix.length;
        if (m == 0)
            return false;
        //列
        int n = matrix[0].length;

        for (int i = 0, j = 0; i < m || j < n; i++, j++) {
            int low, high;
            if (i == m)
                i = m - 1;
            if (j == n)
                j = n - 1;
            //二分查找i下面的那一列
            low = i;
            high = m - 1;
            while(low <= high) {
                int middlei = (low + high) / 2;
                if (matrix[middlei][j] == target) {
                    return true;
                } else if (matrix[middlei][j] > target) {
                    high = middlei - 1;
                } else if (matrix[middlei][j] < target) {
                    low = middlei + 1;
                }
            }

            //二分查找j右边的那一行
            low = j;
            high = n - 1;
            while(low <= high) {
                int middlej = (low + high) / 2;
                if (matrix[i][middlej] == target) {
                    return true;
                } else if (matrix[i][middlej] > target) {
                    high = middlej - 1;
                } else if (matrix[i][middlej] < target) {
                    low = middlej + 1;
                }
            }
        }
        return false;
    }
     */

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix[0].length;
        int col = matrix.length;
        int i = 0;
        int j = col - 1;
        while(i < row || j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }

    public static void main(String[] args) {
        /**
        int[][] ma = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
         */
        int[][] ma = {
                {1, 1}
        };
        new Solution().findNumberIn2DArray(ma, 0);
    }
}
