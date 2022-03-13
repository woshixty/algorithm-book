package 力扣刷题.热题榜.搜索旋转排序数组;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[0])
                if (target >= nums[0] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            else
                if (target <= nums[nums.length - 1] && target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
        }
        return -1;
    }
}
