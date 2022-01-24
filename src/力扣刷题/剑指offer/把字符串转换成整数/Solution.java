package 力扣刷题.剑指offer.把字符串转换成整数;

public class Solution {
    /**
    public int strToInt(String str) {
        int length = 0;
        char[] res = new char[str.length()];
        char[] chars = str.toCharArray();
        boolean flag = false;
        boolean exist = false;
        for (char aChar : chars) {
            if (aChar == ' ')
                continue;
            if (aChar == '-' || aChar == '+') {
                if (exist)
                    return 0;
                else if (aChar == '-') {
                    flag = true;
                    exist = true;
                }
            }
            else if (aChar >= '0' && aChar <= '9')
                res[length++] = aChar;
            else
                break;
        }
        if (length == 0)
            return 0;
        int s = 1, result = 0;
        int bndry = Integer.MAX_VALUE / 10;
        for (int k = length - 1; k >= 0; k--) {
            result += (res[k] - 48) * s;
            if(result > bndry || result == bndry && res[k] > '7')
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            s *= 10;
        }
        if (flag)
            result = -result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strToInt("+1"));
    }
     */

    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0)
            return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (chars[0] == '-') sign = -1;
        else if (chars[0] != '+') i = 0;
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9')
                break;
            if(res > bndry || res == bndry && chars[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (chars[j] - '0');
        }
        return res * sign;
    }
}
