package 力扣刷题.剑指offer.左旋转字符串;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        n = n % length;
        char[] chars = new char[length];
        int j = 0;
        for(int i = n; i < length; i++)
            chars[j++] = s.charAt(i);
        for(int i = 0; i < n; i++)
            chars[j++] = s.charAt(i);
        String newStr = new String(chars, 0, length);
        return newStr;
    }
}
