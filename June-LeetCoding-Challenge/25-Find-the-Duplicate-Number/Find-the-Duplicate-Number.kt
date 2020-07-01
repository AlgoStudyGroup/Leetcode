package binary_search

class FindtheDuplicateNumberKotlin287 {
    fun findDuplicate(nums: IntArray): Int {
        var fast = 0
        var slow = 0
        while (true) {
            fast = nums[nums[fast]]
            slow = nums[slow]
            if (fast == slow) {
                break
            }
        }
        fast = 0
        while (true) {
            fast = nums[fast]
            slow = nums[slow]
            if (fast == slow) {
                break
            }
        }
        return fast
    }
    /*
    fun findDuplicate(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums.count { it <= mid } <= mid -> left = mid
                else -> right = mid
            }
        }
        return right
    }
     */
    /*
    fun findDuplicate(nums: IntArray): Int {
        nums.forEachIndexed { index, i ->
            nums.forEachIndexed { index2, i2 ->
                if (i == i2 && index != index2) {
                    return i
                }
            }
        }
        return -1
    }
     */
}