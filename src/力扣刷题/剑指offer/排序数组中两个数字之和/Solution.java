package 力扣刷题.剑指offer.排序数组中两个数字之和;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0, end = numbers.length - 1;
        int sum = numbers[front] + numbers[end];
        while (sum != target && front < end) {
            if (sum < target)
                front++;
            else
                end--;
            sum = numbers[front] + numbers[end];
        }
        return new int[] {front, end};
    }
}
