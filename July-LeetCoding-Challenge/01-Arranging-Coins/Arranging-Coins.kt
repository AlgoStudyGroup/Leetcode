package binary_search

class ArrangingCoinsKotlin441 {
    fun arrangeCoins(n: Int): Int {
        var left = 1L
        var right = n.toLong().shr(1) // n / 2
        right = if (right <= left) left + 1 else right
        while (left + 1 < right) {
            val mid: Long = left + (right - left) / 2L
            val current: Long = (mid * (mid + 1)).shr(1)
            when {
                current == n.toLong() -> return mid.toInt()
                current < n -> left = mid
                current > n -> right = mid
            }
        }
        return when {
            (right * (right + 1)).shr(1) <= n -> right.toInt()
            (left * (left + 1)).shr(1) <= n -> left.toInt()
            else -> 0
        }
    }
}

fun main() {
    val solution = ArrangingCoinsKotlin441()
    println(solution.arrangeCoins(1))
    println(solution.arrangeCoins(1804289383)) // 60070
}