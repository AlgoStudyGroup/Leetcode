class EditDistanceKotlin72 {
    fun minDistance(word1: String, word2: String): Int {
        val dynamicProgramming = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (index in dynamicProgramming.indices) {
            dynamicProgramming[index][0] = index
        }
        for (index in dynamicProgramming[0].indices) {
            dynamicProgramming[0][index] = index
        }
        for (i1 in 1 until dynamicProgramming.size) {
            for (j2 in 1 until dynamicProgramming[0].size) {
                dynamicProgramming[i1][j2] = when {
                    word1[i1 - 1] == word2[j2 - 1] -> dynamicProgramming[i1 - 1][j2 - 1]
                    else -> 1 + minOf(
                        dynamicProgramming[i1 - 1][j2 - 1],
                        dynamicProgramming[i1 - 1][j2],
                        dynamicProgramming[i1][j2 - 1]
                    )
                }
            }
        }
        return dynamicProgramming[word1.length][word2.length]
    }
}

fun main() {
    val solution = EditDistanceKotlin72()
    println(solution.minDistance("horse", "ros"))
}