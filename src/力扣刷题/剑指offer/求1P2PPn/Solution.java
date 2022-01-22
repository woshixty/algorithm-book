package 力扣刷题.剑指offer.求1P2PPn;

public class Solution {
    int res;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
