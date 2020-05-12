class SingleElementinaSortedArrayKotlin540 {
    fun singleNonDuplicate(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        if (nums[0] != nums[1]) {
            return nums[0]
        }
        if (nums[nums.size - 1] != nums[nums.size - 2]) {
            return nums[nums.size - 1]
        }
        var left = 1
        var right = nums.size - 2
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            if (isSingle(nums, mid)) {
                return nums[mid]
            }
            when {
                singleInRight(nums, mid) -> left = mid
                else -> right = mid
            }
        }
        if (isSingle(nums, left)) {
            return nums[left]
        }
        return nums[right]
    }

    private fun isSingle(nums: IntArray, index: Int): Boolean = nums[index] != nums[index - 1] &&
            nums[index] != nums[index + 1]

    private fun singleInRight(nums: IntArray, index: Int): Boolean =
        (nums[index] == nums[index - 1] && index % 2 != 0) ||
                (nums[index] != nums[index - 1] && index % 2 == 0)
}