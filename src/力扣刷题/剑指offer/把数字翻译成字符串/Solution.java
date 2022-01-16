package 力扣刷题.剑指offer.把数字翻译成字符串;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int[] a;
    int length;
    List<Integer> list;

    /**
    public int translateNum(int num) {
        a = new int[12];
        length = 0;
        if (num == 0) {
            a[0] = 0;
            length++;
        } else {
            for (int i = 0; num != 0; i++) {
                a[i] = num % 10;
                length++;
                num /= 10;
            }
        }
        return getResult(length - 1);
    }

    public int getResult(int num) {
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            int result = 10 * a[1] + a[0];
            if (result<=25 && a[1] != 0)
                return 2;
            else
                return 1;
        }
        int result = 10 * a[num] + a[num - 1];
        if (result <= 25 && a[num] != 0)
            return getResult(num - 1) + getResult(num - 2);
        else
            return getResult(num - 1);
    }

    public static void main(String[] args) {
        new Solution().translateNum(506);
    }
     */

    public int translateNum(int num) {
        if (num >= 0 && num <= 9)
            return 1;
        list = new LinkedList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        return cal(list.size());
    }

    public int cal(int length) {
        if (length == 0)
            return 1;
        int number = list.get(length) * 10 + list.get(length - 1);
        if (number <= 25)
            return cal(length - 1) + cal(length - 2);
        else
            return cal(length - 1);
    }

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(12);
        integers.get(1);
    }
}
