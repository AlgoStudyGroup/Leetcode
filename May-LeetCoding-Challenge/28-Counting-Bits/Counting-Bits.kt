class CountingBitsKotlin338 {
    /*
    0 -> 0
    1 -> 1

    2 -> 1
    3 -> 2

    4 -> 1
    5 -> 2
    6 -> 2
    7 -> 3
     */
    fun countBits(num: Int): IntArray {
        val result = IntArray(num + 1)
        for (index in result.indices) {
            result[index] = result[index.shr(1)] + if (index % 2 == 0) 0 else 1
        }
        return result
    }

    /*
    fun countBits(num: Int): IntArray {
        return IntRange(0, num).map(this::bitCountOne).toIntArray()
    }

    private fun bitCountOne(target: Int): Int {
        var count = 0
        var n = target
        while (n != 0) {
            count += n % 2
            n /= 2
        }
        return count
    }
     */
}

fun main() {
    val solution = CountingBitsKotlin338()
    // 0 1 1 2 1 2
    solution.countBits(5).forEach(::print)
}