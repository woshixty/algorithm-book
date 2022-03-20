package 力扣刷题.热题榜.盛最多水的容器;

public class Solution {
    /**
     * 暴力解题不行
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int capacity = (j - i) * Math.max(height[i], height[j]);
                if (capacity > max)
                    max = capacity;
            }
        }
        return max;
    }
     */

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int capacity = (right - left) * Math.max(height[left], height[right]);
            if (capacity > max)
                max = capacity;
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
