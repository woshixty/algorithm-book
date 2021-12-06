package 力扣刷题.剑指offer.二进制中1的个数;

public class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0) {
            n &= (n - 1);
            result++;
        }
        return result;
    }
}
