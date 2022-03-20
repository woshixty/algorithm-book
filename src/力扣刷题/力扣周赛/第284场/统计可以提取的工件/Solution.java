package 力扣刷题.力扣周赛.第284场.统计可以提取的工件;

public class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] booleans = new boolean[n][n];
        for (int[] ints : dig)
            booleans[ints[0]][ints[1]] = true;
        int result = artifacts.length;
        for (int[] artifact : artifacts) {
            for1:
            for (int i = artifact[0]; i <= artifact[2]; i++)
                for (int j = artifact[1]; j <= artifact[3]; j++)
                    if (!booleans[i][j]) {
                        result--;
                        break for1;
                    }
        }
        return result;
    }
}
