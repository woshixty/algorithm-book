package 力扣刷题.剑指offer.最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < chars.length; j++) {
            Integer i = map.getOrDefault(chars[j], -1);
            int result = j - i;
            max = Math.max(result, max);
            map.put(chars[j], j);
        }
        return max;
    }
     */

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0, i = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < chars.length; j++) {
            i = Math.max(map.getOrDefault(chars[j], -1), i);
            int result = j - i;
            max = Math.max(result, max);
            map.put(chars[j], j);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}
