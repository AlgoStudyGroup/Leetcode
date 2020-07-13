package string_integer

import java.util.*

class ThreeSumKotlin15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result: MutableList<List<Int>> = LinkedList()
        if (nums.isEmpty()) {
            return result
        }
        nums.sort()
        for (i in 0..nums.size - 3) {
            if (nums[i] > 0) {
                break
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                when {
                    sum == 0 -> {
                        result.add(listOf(nums[i], nums[j], nums[k]))
                        ++j
                        --k
                    }
                    sum < 0 -> ++j
                    sum > 0 -> --k
                }
                while (j > i + 1 && j < k && nums[j] == nums[j - 1]) {
                    ++j
                }
                while (k < nums.size - 1 && j < k && nums[k] == nums[k + 1]) {
                    --k
                }
            }
        }
        return result
    }
}