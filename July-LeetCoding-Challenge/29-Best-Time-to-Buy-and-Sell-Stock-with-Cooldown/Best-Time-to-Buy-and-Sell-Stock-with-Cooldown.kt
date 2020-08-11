package dynamic_programming

class BestTimetoBuyandSellStockwithCooldownKotlin309 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        val cooldown = IntArray(prices.size)
        val buy = IntArray(prices.size)
        val sell = IntArray(prices.size)
        buy[0] = -prices[0]
        for (i in 1 until prices.size) {
            cooldown[i] = maxOf(cooldown[i - 1], sell[i - 1])
            buy[i] = maxOf(buy[i - 1], cooldown[i - 1] - prices[i])
            sell[i] = buy[i - 1] + prices[i]
        }
        return maxOf(cooldown[prices.size - 1], sell[prices.size - 1])
    }
}

fun main() {
    val solution = BestTimetoBuyandSellStockwithCooldownKotlin309()
    // 3
    println(solution.maxProfit(intArrayOf(1, 2, 3, 0, 2)))
}