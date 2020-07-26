package string_integer

class SingleNumberIIIKotlin260 {
    fun singleNumber(nums: IntArray): IntArray {
        var flag = nums.reduce { acc, i -> acc.xor(i) }
        flag = flag.and(-flag)
        var r1 = 0
        var r2 = 0
        nums.forEach {
            if (it.and(flag) == 0) {
                r1 = r1.xor(it)
            } else {
                r2 = r2.xor(it)
            }
        }
        return intArrayOf(r1, r2)
    }
}
