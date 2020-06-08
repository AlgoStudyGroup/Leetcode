class PowerofTwoKotlin231 {

    companion object {
        val resultSet = setOf(
            1,
            2,
            4,
            8,
            16,
            32,
            64,
            128,
            256,
            512,
            1024,
            2048,
            4096,
            8192,
            16384,
            32768,
            65536,
            131072,
            262144,
            524288,
            1048576,
            2097152,
            4194304,
            8388608,
            16777216,
            33554432,
            67108864,
            134217728,
            268435456,
            536870912,
            1073741824
        )
    }

    fun isPowerOfTwo(n: Int): Boolean {
        return resultSet.contains(n)
    }
    /*
   fun isPowerOfTwo(n: Int): Boolean {
       if (n == 1) {
           return true
       }
       var current = 2
       while (current < n && current <= 1073741823) {
           current = current.shl(1)
       }
       return current == n
   }
    */
}

fun main() {
    val solution = PowerofTwoKotlin231()
    println(solution.isPowerOfTwo(4))
    println(solution.isPowerOfTwo(1073741825))
    println(solution.isPowerOfTwo(2))
}