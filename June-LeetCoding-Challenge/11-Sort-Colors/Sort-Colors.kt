class SortColorsKotlin75 {
    fun sortColors(nums: IntArray) {
        var zeroPosition = 0
        var twoPosition = nums.size - 1
        var index = 0
        while (index <= twoPosition) {
            when {
                nums[index] == 1 -> ++index
                nums[index] == 0 -> swap(nums, zeroPosition++, index++)
                else -> swap(nums, twoPosition--, index)
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        if (i == j) {
            return
        }
        nums[i] = nums[i].xor(nums[j])
        nums[j] = nums[i].xor(nums[j])
        nums[i] = nums[i].xor(nums[j])
    }
}

fun main() {
    val solution = SortColorsKotlin75()
    val test = intArrayOf(2, 2)
    println(solution.sortColors(test))
    test.forEach(::print)

    // 0 3
    val test2 = intArrayOf(3, 3)
    test2[0] = test2[0].xor(test2[0])
    test2[0] = test2[0].xor(test2[0])
    test2[0] = test2[0].xor(test2[0])
    test2.forEach(::print)

    // 4 4
    val test3 = intArrayOf(4, 4)
    test3[0] = test3[0].xor(test3[1])
    test3[1] = test3[0].xor(test3[1])
    test3[0] = test3[0].xor(test3[1])
    test3.forEach(::print)
}