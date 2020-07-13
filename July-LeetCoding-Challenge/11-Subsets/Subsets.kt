package depth_first_search

import java.util.*
import kotlin.collections.ArrayList

class SubsetsKotlin78 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val results: MutableList<MutableList<Int>> = LinkedList()
        if (nums.isEmpty()) {
            return results
        }
        val subSet: MutableList<Int> = LinkedList()
        dfs(nums, 0, subSet, results)
        return results
    }

    private fun dfs(
        nums: IntArray,
        startIndex: Int,
        subSet: MutableList<Int>,
        results: MutableList<MutableList<Int>>
    ) {
        results.add(ArrayList(subSet))
        for (i in startIndex until nums.size) {
            subSet.add(nums[i])
            dfs(nums, i + 1, subSet, results)
            subSet.removeAt(subSet.size - 1)
        }
    }
}