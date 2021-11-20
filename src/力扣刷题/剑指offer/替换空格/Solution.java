package 力扣刷题.剑指offer.替换空格;

public class Solution {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] chars = new char[3*length];
        int j = 0;
        for(int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            } else {
                chars[j++] = s.charAt(i);
            }
        }
        String newStr = new String(chars, 0, j);
        return newStr;
    }
}
