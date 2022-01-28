package 力扣刷题.剑指offer.二进制加法;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int add = 0;
        int[] addres = new int[0];
        int alength = a.length() - 1;
        int blength = b.length() - 1;

        while (alength >= 0 && blength >= 0) {
            addres = add(a.charAt(alength), b.charAt(blength), add);
            add = addres[0];
            res.append(addres[1]);
            alength--;
            blength--;
        }
        while (alength >= 0) {
            addres = add(a.charAt(alength), '0', add);
            add = addres[0];
            res.append(addres[1]);
            alength--;
        }
        while (blength >= 0) {
            addres = add('0', b.charAt(blength), add);
            add = addres[0];
            res.append(addres[1]);
            blength--;
        }
        if (add == 1)
            res.append(addres[0]);
        return res.reverse().toString();
    }

    public int[] add(char a, char b, int c) {
        int[] res = new int[2];
        int sum = (a - '0') + (b - '0') + c;
        res[0] = sum / 2;
        res[1] = sum % 2;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "10"));
    }
}
