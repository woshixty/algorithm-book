package 力扣刷题.剑指offer.矩阵中的路径;

public class Solution {
    char[][] board;
    String word;
    int length;
    int[] a = {1, -1, 0, 0};
    int[] b = {0, 0, 1, -1};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.length = word.length();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    if (judge(i, j, 0))
                        return true;
            }
        return false;
    }

    public boolean judge(int i, int j, int num) {
        if (length - 1 == num)
            return true;
        num++;
        boolean result = false;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int iT = i + a[k];
            int jT = j + b[k];
            if ((iT >= 0 && iT < board.length) && (jT >= 0 && jT < board[0].length)) {
                if (!visited[iT][jT] && board[iT][jT] == word.charAt(num)) {
                    result = judge(iT, jT, num);
                    if (result)
                        break;
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new Solution().exist(chars, "SEE"));
    }
}
