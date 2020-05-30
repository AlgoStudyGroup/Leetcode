class UncrossedLinesKotlin1035 {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val dynamicProgramming = Array(A.size + 1) { IntArray(B.size + 1) }
        for (indexA in A.indices) {
            for (indexB in B.indices) {
                dynamicProgramming[indexA + 1][indexB + 1] = when {
                    A[indexA] == B[indexB] ->
                        1 + dynamicProgramming[indexA][indexB]
                    else ->
                        maxOf(
                            dynamicProgramming[indexA][indexB + 1],
                            dynamicProgramming[indexA + 1][indexB]
                        )
                }
            }
        }
        return dynamicProgramming[A.size][B.size]
    }
}

fun main() {
    val solution = UncrossedLinesKotlin1035()
    // 2 3 2
    println(solution.maxUncrossedLines(intArrayOf(1, 4, 2), intArrayOf(1, 2, 4)))
    println(solution.maxUncrossedLines(intArrayOf(2, 5, 1, 2, 5), intArrayOf(10, 5, 2, 1, 5, 2)))
    println(solution.maxUncrossedLines(intArrayOf(1, 3, 7, 1, 7, 5), intArrayOf(1, 9, 2, 5, 1)))
}