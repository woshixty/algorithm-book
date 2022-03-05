package 力扣刷题.热题榜.整数反转;

public class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10)
                return 0;
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(0));
    }
}
