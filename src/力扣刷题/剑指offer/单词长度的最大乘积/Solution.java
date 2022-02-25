package 力扣刷题.剑指offer.单词长度的最大乘积;

public class Solution {
    public int maxProduct(String[] words) {
        int[] wordCode = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                final char c = words[i].charAt(j);
                wordCode[i] |= 1 << (c - 'a');
            }
        }
        int result = 0;
        for (int i = 0, end = words.length; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if ((wordCode[i] & wordCode[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}
