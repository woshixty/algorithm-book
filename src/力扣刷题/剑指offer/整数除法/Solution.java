package 力扣刷题.剑指offer.整数除法;

public class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
//        if (a == Integer.MIN_VALUE && b == 1)
//            return Integer.MIN_VALUE;
        if (a == b)
            return 1;
        int flag = 1;
        if ((a < 0 && b > 0) || (a > 0 && b < 0))
            flag = -flag;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res ++;
        }
        return flag == 1 ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(-2147483648, 2));
    }
}
