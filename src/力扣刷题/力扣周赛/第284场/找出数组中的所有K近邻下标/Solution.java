package 力扣刷题.力扣周赛.第284场.找出数组中的所有K近邻下标;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == key)
                list.add(i);
        boolean[] booleans = new boolean[nums.length];
        int i = 0;
        for (Integer integer : list) {
            for (i = Math.max(i, integer - k); i <= Math.min(integer + k, nums.length - 1); i++)
                if (!booleans[i])
                    result.add(i);
        }
        return result;
    }
}
