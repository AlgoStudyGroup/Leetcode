class CountSquareSubmatriceswithAllOnesKotlin1277 {
    // the larger square contains the small square
    //
    fun countSquares(matrix: Array<IntArray>): Int {
        var count = 0
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = 1 + minOf(
                        matrix[i - 1][j],
                        matrix[i][j - 1],
                        matrix[i - 1][j - 1]
                    )
                }
                count += matrix[i][j]
            }
        }
        return count
    }
    /*
    fun countSquares(matrix: Array<IntArray>): Int {
        val dynamicProgramming = Array(matrix.size) { IntArray(matrix[0].size) }
        var count = 0
        for (i in dynamicProgramming.indices) {
            for (j in dynamicProgramming[0].indices) {
                when {
                    i > 0 && j > 0 && matrix[i][j] > 0 ->
                        dynamicProgramming[i][j] = minOf(
                            dynamicProgramming[i - 1][j],
                            dynamicProgramming[i][j - 1],
                            dynamicProgramming[i - 1][j - 1]
                        ) + 1
                    else -> dynamicProgramming[i][j] = matrix[i][j]
                }
                count += dynamicProgramming[i][j]
            }
        }
        return count
    }
     */
    /*
    fun countSquares(matrix: Array<IntArray>): Int {
        val dynamicProgramming = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
        for (i in 1 until dynamicProgramming.size) {
            for (j in 1 until dynamicProgramming[0].size) {
                dynamicProgramming[i][j] = matrix[i - 1][j - 1] +
                        dynamicProgramming[i - 1][j] +
                        dynamicProgramming[i][j - 1] -
                        dynamicProgramming[i - 1][j - 1]
            }
        }
        val maxSide = minOf(matrix.size, matrix[0].size)
        var count = 0
        for (side in 1..maxSide) {
            val targetSum = side * side
            for (i in side until dynamicProgramming.size) {
                for (j in side until dynamicProgramming[0].size) {
                    val currentSum = dynamicProgramming[i][j] -
                            dynamicProgramming[i - side][j] -
                            dynamicProgramming[i][j - side] +
                            dynamicProgramming[i - side][j - side]
                    if (currentSum == targetSum) {
                        ++count
                    }
                }
            }
        }
        return count
    }
     */
}

fun main() {
    val solution = CountSquareSubmatriceswithAllOnesKotlin1277()
    // 15
    println(
        solution.countSquares(
            arrayOf(
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(0, 1, 1, 1)
            )
        )
    )
}