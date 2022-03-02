package 力扣刷题.热题榜.最长回文子串;

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }
        final char[] chars = s.toCharArray();
        int[] result = {0, 0};
        for (int i = 0; i < chars.length; i++) {
            final int[] length = getLength1(chars, i);
            if ((length[1] - length[0]) > (result[1] - result[0])) {
                result = length;
            }
            final int[] length2 = getLength2(chars, i);
            if ((length2[1] - length2[0]) > (result[1] - result[0])) {
                result = length2;
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    public int[] getLength1(char[] chars, int mid) {
        int front = mid - 1, end = mid + 1;
        while (front >= 0 && end < chars.length && chars[front] == chars[end]) {
            front--;
            end++;
        }
        return new int[] {++front, --end};
    }

    public int[] getLength2(char[] chars, int mid) {
        int front = mid, end = mid + 1;
        if (end < chars.length && chars[front] == chars[end]) {
            while (front >= 0 && end < chars.length && chars[front] == chars[end]) {
                front--;
                end++;
            }
            return new int[] {++front, --end};
        } else {
            return new int[] {1, 0};
        }
    }
}
