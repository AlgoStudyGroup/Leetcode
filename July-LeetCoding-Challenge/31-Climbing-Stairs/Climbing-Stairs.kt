package dynamic_programming

class ClimbingStairsKotlin70 {
    fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        }
        var i1 = 1
        var i2 = 2
        for (index in 3..n) {
            val sum = i1 + i2
            i1 = i2
            i2 = sum
        }
        return i2
    }
    /*
    fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        }
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 2
        for (index in 3..n) {
            dp[index] = dp[index - 1] + dp[index - 2]
        }
        return dp[n]
    }
     */
}