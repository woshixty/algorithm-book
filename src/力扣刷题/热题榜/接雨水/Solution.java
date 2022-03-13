package 力扣刷题.热题榜.接雨水;

public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int oldright = height.length - 1;
        int area = 0;
        int oldleft = 0;
        while (left < right) {
            left++;
            int sum = 0;
            while (left < height.length && height[left] < height[oldleft]) {
                sum += height[left];
                left++;
            }
            if (left < height.length) {
                area += ((left - oldleft - 1) * height[oldleft] - sum);
                oldleft = left;
            }
            right--;
            sum = 0;
            while (right >= 0 && height[right] < height[oldright]) {
                sum += height[right];
                right--;
            }
            if (right >= 0)
                area += ((oldright - right - 1) * height[right] - sum);
        }
        return area;
    }

    public static void main(String[] args) {
        new Solution().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
    }

}
