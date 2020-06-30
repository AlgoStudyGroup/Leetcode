package string_integer

class SingleNumberIIKotlin137 {
    fun singleNumber(nums: IntArray): Int {
        var one = 0
        var two = 0
        nums.forEach {
            one = one.xor(it).and(two.inv())
            two = two.xor(it).and(one.inv())
        }
        return one
    }
}