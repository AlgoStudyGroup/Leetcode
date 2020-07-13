package string_integer

class ReverseBitsKotlin190 {
    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var current = n
        var result = 0
        for (time in 0 until 32) {
            result = if (current.and(1) == 1) {
                result.shl(1) + 1
            } else {
                result.shl(1)
            }
            current = current.shr(1)
        }
        return result
    }
}