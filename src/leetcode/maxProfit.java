package leetcode;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        int sellPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            int currentProfit = currentPrice - buyPrice;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                sellPrice = prices[i];
            }
            if (currentPrice < buyPrice) {
                buyPrice = currentPrice;
            }
        }

        return maxProfit;
    }
}
