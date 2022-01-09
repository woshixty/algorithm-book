package 力扣刷题.剑指offer.第一个只出现一次的字符;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Solution {
    /**
    public char firstUniqChar(String s) {
        Map<Character, Integer> position = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
                queue.offer(ch);
            }
        }
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            if (position.containsKey(poll) && !position.get(poll).equals(-1))
                return poll;
        }
        return ' ';
    }
     */

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char aChar : chars)
            map.put(aChar, map.containsKey(aChar));
        for (Map.Entry<Character, Boolean> characterBooleanEntry : map.entrySet()) {
            if (!characterBooleanEntry.getValue())
                return characterBooleanEntry.getKey();
        }
        return ' ';
    }
}
