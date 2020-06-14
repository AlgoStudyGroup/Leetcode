class CheapestFlightsWithinKStopsKotlin787 {
    /*
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val dp = Array(K + 2) { IntArray(n) { 10000 * n } }
        dp[0][src] = 0
        for (time in 1..K + 1) {
            dp[time][src] = 0
            for (flight in flights) {
                dp[time][flight[1]] = minOf(
                    dp[time][flight[1]],
                    dp[time - 1][flight[0]] + flight[2]
                )
            }
        }
        return when {
            dp[K + 1][dst] >= 10000 * n -> -1
            else -> dp[K + 1][dst]
        }
    }
     */

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        var dp = IntArray(n) { 10000 * n }
        dp[src] = 0
        for (time in 0..K) {
            val new = dp.copyOf(dp.size)
            for (flight in flights) {
                new[flight[1]] = minOf(new[flight[1]], dp[flight[0]] + flight[2])
            }
            dp = new
        }
        return when {
            dp[dst] >= 10000 * n -> -1
            else -> dp[dst]
        }
    }
}