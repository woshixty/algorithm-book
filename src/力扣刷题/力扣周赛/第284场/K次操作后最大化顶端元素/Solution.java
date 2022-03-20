package 力扣刷题.力扣周赛.第284场.K次操作后最大化顶端元素;


/**
 * [2]
 * 1
 */
public class Solution {
    public int maximumTop(int[] nums, int k) {
        int top = 0;
        if (k == 0)
            return nums[0];
        int max = 0;
        if (k > nums.length) {
            if (nums.length > 1) {
                for (int num : nums)
                    max = Math.max(num, max);
                return max;
            } else
                if (k % 2 == 1)
                    return -1;
                else
                    return nums[top];
        } else if (k == nums.length) {
            int out = 0;
            for (; k > 1 || ++out >= 0; k--)
                max = Math.max(max, nums[top++]);
            if (out == 0)
                return -1;
            else
                return max;
        } else {
            for (; k > 1; k--)
                max =Math.max(max, nums[top++]);
            return Math.max(max, nums[top + 1]);
        }
    }
}
