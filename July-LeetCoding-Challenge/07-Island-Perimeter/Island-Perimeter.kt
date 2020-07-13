package string_integer

class IslandPerimeterKotlin463 {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var count = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    count += 4
                    if (i > 0 && grid[i - 1][j] == 1) {
                        --count
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        --count
                    }
                    if (i < grid.size - 1 && grid[i + 1][j] == 1) {
                        --count
                    }
                    if (j < grid[0].size - 1 && grid[i][j + 1] == 1) {
                        --count
                    }
                }
            }
        }
        return count
    }
}

fun main() {
    val solution = IslandPerimeterKotlin463()
    println(
        solution.islandPerimeter(
            arrayOf(
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 1, 0),
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 0, 0)
            )
        )
    )
}