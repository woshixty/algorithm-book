package 力扣刷题.剑指offer.前n个数字二进制中1的个数;

public class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++)
            res[i] = cal(i);
        return res;
    }

    public int cal(int i) {
        int res = 0;
        while(i != 0) {
            i = i & (i - 1);
            res++;
        }
        return res;
    }
}
