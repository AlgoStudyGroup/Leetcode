class ContiguousArrayKotlin525 {

    fun findMaxLength(nums: IntArray): Int {
        val dpMap: MutableMap<Int, Int> = HashMap()
        var max = 0
        var sum = 0
        dpMap[0] = -1
        for (index in nums.indices) {
            sum += nums[index].times(2).minus(1)
            when {
                dpMap.containsKey(sum) -> max = maxOf(max, index - dpMap.getValue(sum))
                else -> dpMap[sum] = index
            }
        }
        return max
    }
}

fun main() {
    val solution = ContiguousArrayKotlin525()
    println(solution.findMaxLength(intArrayOf(0, 1, 1, 0, 1, 1, 1, 0)))
    // 6 2 2 8 2
    println(solution.findMaxLength(intArrayOf(0, 1, 0, 0, 1, 0, 1, 0)))
    println(solution.findMaxLength(intArrayOf(0, 1)))
    println(solution.findMaxLength(intArrayOf(0, 1, 0)))
    println(solution.findMaxLength(intArrayOf(0, 0, 0, 1, 1, 0, 1, 1, 1, 1)))
    println(solution.findMaxLength(intArrayOf(1, 0)))
}