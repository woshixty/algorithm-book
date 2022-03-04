package 力扣刷题.热题榜.环形链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        final int length = nums.length;
        int i, j, k;


        for (i = 0; i < length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                k = length - 1;

                for (j = i + 1; j < k; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int sum = nums[i] + nums[j] + nums[k];
                        while (sum > 0 && k > j + 1) {
                            k--;
                            sum = nums[i] + nums[j] + nums[k];
                        }
                        if (sum == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().threeSum(new int[]{0, 0, 0, 0});
//        int[] ints = {-1, 0, 1, 2, -1, -4};
//        Arrays.sort(ints);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
    }

}
