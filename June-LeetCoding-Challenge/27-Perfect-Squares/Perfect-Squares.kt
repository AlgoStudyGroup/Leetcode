package dynamic_programming

import kotlin.math.sqrt

class PerfectSquaresKotlin279 {

    // https://zh.wikipedia.org/wiki/%E5%9B%9B%E5%B9%B3%E6%96%B9%E5%92%8C%E5%AE%9A%E7%90%86
    // 四平方和定理
    fun numSquares(n: Int): Int {
        var current = n
        while (current % 4 == 0) {
            current /= 4
        }
        if (current % 8 == 7) {
            return 4
        }
        var a1 = 0
        while (a1 * a1 <= current) {
            val b2 = sqrt((current - a1 * a1).toDouble()).toInt()
            if (a1 * a1 + b2 * b2 == current) {
                return if (a1 != 0 && b2 != 0) {
                    2
                } else {
                    1
                }
            }
            ++a1
        }
        return 3
    }
    /*
    fun numSquares(n: Int): Int {
        val coins: MutableList<Int> = ArrayList()
        var current = 1
        while (current * current <= n) {
            coins.add(current * current)
            ++current
        }
        val dp = IntArray(n + 1) { n + 1 }
        dp[0] = 0
        for (index in 1..n) {
            for (coin in coins) {
                if (coin <= index) {
                    dp[index] = minOf(dp[index], dp[index - coin] + 1)
                }
            }
        }
        return when {
            dp[n] > n -> -1
            else -> dp[n]
        }
    }
     */
}

fun main() {
    val solution = PerfectSquaresKotlin279()
    // 2
    println(solution.numSquares(8))
    // 3
    println(solution.numSquares(12))
    // 2
    println(solution.numSquares(13))
}