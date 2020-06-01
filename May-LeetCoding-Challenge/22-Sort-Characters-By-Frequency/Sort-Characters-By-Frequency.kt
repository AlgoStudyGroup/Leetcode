class SortCharactersByFrequencyKotlin451 {
    fun frequencySort(s: String): String {
        val charCountsMap: MutableMap<Char, Int> = HashMap()
        s.forEach {
            charCountsMap[it] = 1 + charCountsMap.getOrDefault(it, 0)
        }
        val result = StringBuilder(s.length)
        charCountsMap.toList()
            .sortedByDescending { it.second }
            .forEach {
                result.append(it.first.toString().repeat(it.second))
            }
        return result.toString()
    }
    /*
    fun frequencySort(s: String): String {
        val charCountsMap: MutableMap<Char, Int> = HashMap()
        s.forEach {
            charCountsMap[it] = 1 + charCountsMap.getOrDefault(it, 0)
        }
        return charCountsMap.toList()
            .sortedByDescending { it.second }.joinToString(separator = "") { it.first.toString().repeat(it.second) }
    }
     */
}

fun main() {
    val solution = SortCharactersByFrequencyKotlin451()
    println(solution.frequencySort("tree"))
    println(solution.frequencySort("cccaaa"))
}