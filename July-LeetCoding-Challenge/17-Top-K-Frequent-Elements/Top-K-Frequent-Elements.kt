package list_array

class TopKFrequentElementsKotlin347 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map: MutableMap<Int, Int> = HashMap()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        return map
            .toList()
            .sortedByDescending(Pair<Int, Int>::second)
            .subList(0, k)
            .map { it.first }
            .toIntArray()
    }
}