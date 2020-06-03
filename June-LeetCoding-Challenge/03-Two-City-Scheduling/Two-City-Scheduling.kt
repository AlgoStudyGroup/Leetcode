class TwoCitySchedulingKotlin1029 {

    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        costs.sortWith(Comparator { ints1, ints2 -> compareValues(ints1[0] - ints1[1], ints2[0] - ints2[1]) })
        val half = costs.size / 2
        var sum = 0
        costs.forEachIndexed { index, ints ->
            sum += when {
                index < half -> ints[0]
                else -> ints[1]
            }
        }
        return sum
    }
    /*
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val half = costs.size.shr(1)
        val dp = Array(half + 1) { IntArray(half + 1) }
        for (index in 1 until dp.size) {
            dp[0][index] = dp[0][index - 1] + costs[index - 1][0]
        }
        for (i in 1 until dp.size) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][1]
            for (j in 1 until dp.size) {
                dp[i][j] = minOf(
                    dp[i - 1][j] + costs[i + j - 1][1],
                    dp[i][j - 1] + costs[i + j - 1][0]
                )
            }
        }
        return dp[half][half]
    }
     */
}

fun main() {
    val solution = TwoCitySchedulingKotlin1029()
    // 110
    println(
        solution.twoCitySchedCost(
            arrayOf(
                intArrayOf(10, 20),
                intArrayOf(30, 200),
                intArrayOf(400, 50),
                intArrayOf(30, 20)
            )
        )
    )
    // 130
    println(
        solution.twoCitySchedCost(
            arrayOf(
                intArrayOf(10, 20),
                intArrayOf(30, 200),
                intArrayOf(400, 50),
                intArrayOf(30, 200)
            )
        )
    )
}