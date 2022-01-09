package 力扣刷题.剑指offer.在排序数组中查找数字I;

public class Solution {
    /**
    public int search(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                start = end = mid;
                while(nums[start] == target)
                    start--;
                while(nums[end] == end)
                    end++;
                return end - start - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return 0;
    }
     */

    public int search(int[] nums, int target) {
        int first = 0, last = nums.length - 1;
        int mid;
        while(first <= last) {
            mid = (first + last) / 2;
            if (nums[mid] == target) {
                //前进
                for (last = mid + 1; last < nums.length && nums[last] == target; last++);
                if (last == nums.length - 1)
                    if (nums[last] == target)
                        last++;
                //后退
                for (first = mid - 1; first > 0 && nums[first] == target; first--);
                if (first == 0)
                    if (nums[first] == target)
                        first--;
                return last - first - 1;
            }
            else if (nums[mid] > target)
                last = mid - 1;
            else
                first = mid + 1;
        }
        return 0;
    }
}
