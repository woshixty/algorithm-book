package 力扣刷题.剑指offer.股票的最大利润;

public class Solution {
    /**
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0)
            return 0;
        int[] profit = new int[length];
        profit[0] = 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < length; i++) {
            if (minPrice > prices[i])
                minPrice = prices[i];
            else {
                int nowProfit = prices[i] - minPrice;
                if (nowProfit > maxProfit)
                    maxProfit = nowProfit;
            }
        }
        return maxProfit;
    }
     */
    public int maxProfit(int[] prices) {


        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            System.out.println(i);
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Integer.parseInt("a");
    }
}
