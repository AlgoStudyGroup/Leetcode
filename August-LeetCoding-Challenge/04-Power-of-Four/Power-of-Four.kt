package string_integer

class PowerofFourKotlin342 {
    fun isPowerOfFour(num: Int): Boolean {
        var current = num
        if (current < 1) {
            return false
        }
        while (current % 4 == 0) {
            current /= 4
        }
        return current == 1
    }
    /*
    fun isPowerOfFour(num: Int): Boolean {
        return num > 0 && (num.and(num - 1)) == 0 && (num.and(0x55555555)) != 0
    }
     */

    /*
    private val set = setOf(
        1,
        4,
        16,
        64,
        256,
        1024,
        4096,
        16384,
        65536,
        262144,
        1048576,
        4194304,
        16777216,
        67108864,
        268435456,
        1073741824
    )

    fun isPowerOfFour(num: Int): Boolean {
        return set.contains(num)
    }
     */
    /*
    fun isPowerOfFour(num: Int): Boolean {
        if (num == 1) {
            return true
        }
        var current = 4
        while (current < num && current <= 1073741823) {
            current *= 4
        }
        return current == num
    }
     */
}

fun main() {
    val solution = PowerofFourKotlin342()
    println(solution.isPowerOfFour(1162261466))
}