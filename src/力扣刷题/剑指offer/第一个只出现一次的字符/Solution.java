package 力扣刷题.剑指offer.第一个只出现一次的字符;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
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
}
