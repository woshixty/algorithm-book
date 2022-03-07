package 力扣刷题.热题榜.罗马数字转整数;

import java.util.HashMap;

public class Solution {
    HashMap<Character, Integer> map = new HashMap();
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = map.get(s.charAt(0));
        int length = s.length();
        for (int i = 1; i < length; i++) {
            final char c = s.charAt(i);
            result += map.get(c);
            switch (c) {
                case 'V':
                case 'X':
                    if (s.charAt(i - 1) == 'I')
                        result -= 2;
                    break;
                case 'L':
                case 'C':
                    if (s.charAt(i - 1) == 'X')
                        result -= 20;
                    break;
                case 'D':
                case 'M':
                    if (s.charAt(i - 1) == 'C')
                        result -= 200;
                    break;
            }
        }
        return result;
    }
}
