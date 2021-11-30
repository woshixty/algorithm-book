package 力扣刷题.剑指offer.斐波那契数列;

public class Solution {
    public int fib(int n) {
        int[] ints = new int[101];
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i <= n; i++)
            ints[i] = ints[i - 1] + ints[i - 2];
        return ints[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(5));
    }
}
