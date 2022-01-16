package 力扣刷题.剑指offer.翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        int i = 0, j = strings.length - 1;
        while (i < j) {
            String string = strings[i];
            strings[i] = strings[j];
            strings[j] = string;
            i++;
            j--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < strings.length; i++) {
            if (!"".equals(strings[i]))
                stringBuilder.append(" " + strings[i]);
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}
