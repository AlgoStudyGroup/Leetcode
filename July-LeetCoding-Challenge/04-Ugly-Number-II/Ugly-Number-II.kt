package binary_search

class UglyNumberIIKotlin264 {
    /*
    (1) (1x2),  2x2, (2x2), (3x2), 3x2, (4x2), 5x2...
    (2) 1x3,  (1x3), 2x3, (2x3), 2x3, 3x3, (3x3)...
    (3) 1x5,  1x5, 1x5, (1x5), 2x5, 2x5, 2x5...
     */
    fun nthUglyNumber(n: Int): Int {
        val list: MutableList<Int> = ArrayList()
        var int1 = 0
        var int2 = 0
        var int3 = 0
        list.add(1)
        while (list.size < n) {
            val new1 = list[int1] * 2
            val new2 = list[int2] * 3
            val new3 = list[int3] * 5
            val min = minOf(new1, new2, new3)
            if (min == new1) {
                ++int1
            }
            if (min == new2) {
                ++int2
            }
            if (min == new3) {
                ++int3
            }
            list.add(min)
        }
        return list[n - 1]
    }
}

fun main() {
    val solution = UglyNumberIIKotlin264()
    // 12
    println(solution.nthUglyNumber(10))
}