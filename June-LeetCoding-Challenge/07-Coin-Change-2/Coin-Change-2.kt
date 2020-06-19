// https://www.youtube.com/watch?v=e1omSFakK7o
class CoinChange2Kotlin518 {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (coin in coins) {
            for (index in coin..amount) {
                dp[index] += dp[index - coin]
            }
        }
        return dp[amount]
    }
}

fun main() {
    val solution = CoinChange2Kotlin518()
    println(solution.change(10, intArrayOf(1, 2, 5)))
    // 4
    println(solution.change(5, intArrayOf(1, 2, 5)))
    // 0
    println(solution.change(3, intArrayOf(2)))
    // 1
    println(solution.change(10, intArrayOf(10)))
    // 12701
    println(solution.change(500, intArrayOf(5, 2, 1)))
}