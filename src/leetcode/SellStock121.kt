package leetcode

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var buyPrice = prices[0]
    var sellPrice = prices[0]

    for (i in prices.indices) {
        val currentProfit = prices[i] - buyPrice
        if (currentProfit > maxProfit) {
            maxProfit = currentProfit
            sellPrice = prices[i]
        }
        if (prices[i] < buyPrice) {
            buyPrice = prices[i]
        }
    }
    return maxProfit
}