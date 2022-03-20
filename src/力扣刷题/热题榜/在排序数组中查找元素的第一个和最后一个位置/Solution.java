package 力扣刷题.热题榜.在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        int[] result = new int[]{-1, -1};
        for1:
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = right = mid;
                while (left >= 0 && nums[left--] == target);
                while (right < nums.length && nums[right++] == target);
                result[0] = ++left;
                result[1] = --right;
                break for1;
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return result;
    }
}
