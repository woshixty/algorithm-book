package 力扣刷题.剑指offer.构建乘积数组;

public class Solution {
    public int[] constructArr(int[] a) {
        int length = a.length;
        int b[] = new int[length];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < length; i++)
            b[i] = b[i - 1] * a[i - 1];
        for (int i = length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
