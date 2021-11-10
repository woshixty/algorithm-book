package 力扣刷题.寻找两个正序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pa = 0, pb = 0;
        int sum = nums1.length + nums2.length;
        int need = sum % 2 == 1 ? 1 : 2;
        int mid = sum / 2;
        int a = 0, b = 0;
        for (; (pa + pb < sum) && (need != 0);) {
            //边界情况
            if (pa == nums1.length) {

            };
            if (pb == nums2.length) {

            }
            if (nums1[pa] <= nums2[pb]) {

            }
        }
        return 1.0;
    }
}
