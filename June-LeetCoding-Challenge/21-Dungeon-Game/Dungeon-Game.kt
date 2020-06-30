package dynamic_programming

class DungeonGameKotlin174 {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val dynamicProgramming = IntArray(dungeon[0].size + 1) { Int.MAX_VALUE }
        dynamicProgramming[dynamicProgramming.size - 1] = 1
        for (i in dungeon.size - 1 downTo 0) {
            if (dynamicProgramming[dynamicProgramming.size - 1] == 1 && i != dungeon.size - 1) {
                dynamicProgramming[dynamicProgramming.size - 1] = Int.MAX_VALUE
            }
            for (j in dungeon[0].size - 1 downTo 0) {
                dynamicProgramming[j] =
                    maxOf(1, minOf(dynamicProgramming[j], dynamicProgramming[j + 1]) - dungeon[i][j])
            }
        }
        return dynamicProgramming[0]
    }
    /*
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val dynamicProgramming = Array(dungeon.size + 1) { IntArray(dungeon[0].size + 1) { Int.MAX_VALUE } }
        dynamicProgramming[dynamicProgramming.size - 1][dynamicProgramming[0].size - 2] = 1
        dynamicProgramming[dynamicProgramming.size - 2][dynamicProgramming[0].size - 1] = 1
        for (i in dungeon.size - 1 downTo 0) {
            for (j in dungeon[0].size - 1 downTo 0) {
                dynamicProgramming[i][j] =
                    maxOf(1, minOf(dynamicProgramming[i + 1][j], dynamicProgramming[i][j + 1]) - dungeon[i][j])
            }
        }
        return dynamicProgramming[0][0]
    }
     */
}

fun main() {
    val solution = DungeonGameKotlin174()
    println(
        solution.calculateMinimumHP(
            arrayOf(
                intArrayOf(-2, -3, 3),
                intArrayOf(-5, -10, 1),
                intArrayOf(10, 30, -5)
            )
        )
    )
    println(
        solution.calculateMinimumHP(
            arrayOf(
                intArrayOf(0, -3)
            )
        )
    )
    println(
        solution.calculateMinimumHP(
            arrayOf(
                intArrayOf(100)
            )
        )
    )
}