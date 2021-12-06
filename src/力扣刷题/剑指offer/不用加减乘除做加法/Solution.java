package 力扣刷题.剑指offer.不用加减乘除做加法;

public class Solution {
    public int add(int a, int b) {
        while(b != 0) {
            int n = (b & a) << 1;
            a ^= b;
            b = n;
        }
        return a;
    }
}
