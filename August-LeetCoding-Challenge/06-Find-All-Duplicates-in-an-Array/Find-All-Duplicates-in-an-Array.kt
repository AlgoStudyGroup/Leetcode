package string_integer

import java.util.*
import kotlin.math.abs

class FindAllDuplicatesinanArrayKotlin442 {
    fun findDuplicates(nums: IntArray): List<Int> {
        val results: MutableList<Int> = LinkedList()
        nums.forEach {
            val index = abs(it) - 1
            if (nums[index] < 0) {
                results.add(index + 1)
            }
            nums[index] = -nums[index]
        }
        return results
    }
    /*
    fun findDuplicates(nums: IntArray): List<Int> {
        val results: MutableList<Int> = LinkedList()
        val set: MutableSet<Int> = HashSet()
        nums.forEach {
            if (set.contains(it)) {
                results.add(it)
            }
            set.add(it)
        }
        return results
    }
     */
}