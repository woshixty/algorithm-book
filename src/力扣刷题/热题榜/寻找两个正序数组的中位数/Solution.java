package 力扣刷题.热题榜.寻找两个正序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int half = (length1 + length2) / 2;
        if ((length1 + length2) % 2 == 1) {
            //奇数总和，返回中位数字
            return getKNum(nums1, nums2,  half + 1);
        } else {
            //偶数总和
            int res =
                    getKNum(nums1, nums2, half)
                            +
                    getKNum(nums1, nums2, half + 1);
            return res / 2.0;
        }
    }

    public int getKNum(int[] nums1, int[] nums2, int k) {
        int begin1 = 0, begin2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        while (true) {
            if (begin1 >= length1) {
                return nums2[begin2 + k - 1];
            }
            if (begin2 >= length2) {
                return nums1[begin1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[begin1], nums2[begin2]);
            }
            int temp1 = begin1;
            int temp2 = begin2;
            begin1 = Math.min(length1, begin1 + k / 2) - 1;
            begin2 = Math.min(length2, begin2 + k / 2) - 1;
            if (nums1[begin1] > nums2[begin2]) {
                //弃掉nums2的前面k/2个数字
                begin2 = begin2 + 1;
                begin1 = temp1;
                k -= (begin2 - temp2);
            } else {
                //弃掉nums1的前面k/2个数字
                begin1 = begin1 + 1;
                begin2 = temp2;
                k -= (begin1 - temp1);
            }
        }
    }
}
