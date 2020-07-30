package binary_search

class PowxnKotlin50 {
    fun myPow(x: Double, n: Int): Double {
        return when {
            x == 0.0 -> 0.0
            n == 1 -> x
            n == -1 -> 1 / x
            n == 0 -> 1.0
            // Int.MIN_VALUE = Int.MAX_VALUE + 1
            n == Int.MIN_VALUE -> 1 / powLog(x, Int.MAX_VALUE) * x
            n > 0 -> powLog(x, n)
            n < 0 -> 1 / powLog(x, -n)
            else -> -1.0
        }
    }

    private fun powLog(x: Double, n: Int): Double =
        when {
            n == 1 -> x
            n % 2 == 0 -> {
                val result = powLog(x, n.shr(1))
                result * result
            }
            n % 2 == 1 -> {
                val result = powLog(x, n.shr(1))
                result * result * x
            }
            else -> -1.0
        }
}