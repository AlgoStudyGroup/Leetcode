package dynamic_programming

class UniquePathsKotlin62 {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) }
        dp[0][1] = 1
        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m][n]
    }
}

fun main() {
    val solution = UniquePathsKotlin62()
    // 3
    println(solution.uniquePaths(3, 2))
    // 28
    println(solution.uniquePaths(7, 3))
}