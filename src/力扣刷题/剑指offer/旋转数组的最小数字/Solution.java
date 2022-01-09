package 力扣刷题.剑指offer.旋转数组的最小数字;

public class Solution {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        int pivot = 0;
        while(high >= low) {
            pivot = (low + high) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[low]) {
                low = pivot;
            } else {
                high--;
            }
        }
        return numbers[pivot];
    }

    public static void main(String[] args) {
        System.out.println((2 + 3) / 2);
    }
}
