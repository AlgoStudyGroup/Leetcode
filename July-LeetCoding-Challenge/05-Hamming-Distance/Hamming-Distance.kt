package string_integer

class HammingDistanceKotlin461 {
    fun hammingDistance(x: Int, y: Int): Int {
        var xor = x.xor(y)
        var count = 0
        for (times in 1..32) {
            if (xor.and(1) == 1) {
                ++count
            }
            xor = xor.shr(1)
        }
        return count
    }
}