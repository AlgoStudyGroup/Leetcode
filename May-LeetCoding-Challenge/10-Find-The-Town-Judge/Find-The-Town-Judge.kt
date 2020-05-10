class FindtheTownJudgeKotlin997 {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val arrayN = IntArray(N)
        for (ints in trust) {
            // I vote
            arrayN[ints[0] - 1]--
            // the person whom I vote for
            arrayN[ints[1] - 1]++
        }
        for (index in arrayN.indices) {
            if (arrayN[index] == N - 1) {
                return index + 1
            }
        }
        return -1
    }
    /*
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val matrixN = Array(N) { IntArray(2) }
        for (ints in trust) {
            // I vote
            matrixN[ints[0] - 1][0]++
            // the person whom I vote for
            matrixN[ints[1] - 1][1]++
        }
        for (index in matrixN.indices) {
            if (matrixN[index][0] == 0 && matrixN[index][1] == N - 1) {
                return index + 1
            }
        }
        return -1
    }
     */
}

fun main() {
    val solution = FindtheTownJudgeKotlin997()
    println(solution.findJudge(2, arrayOf(intArrayOf(1, 2)))) // 2
    println(solution.findJudge(3, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)))) // -1
    println(solution.findJudge(1, arrayOf())) // 1
}