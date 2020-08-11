package breadth_first_search

import java.util.*

class RottingOrangesKotlin994 {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        val queue: Queue<IntArray> = LinkedList()
        // add all rotten orange into the queue,visited
        var freshOranges = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 2) {
                    queue.offer(intArrayOf(i, j))
                    visited[i][j] = true
                }
                if (grid[i][j] == 1) {
                    ++freshOranges
                }
            }
        }
        if (freshOranges == 0) {
            return 0
        }
        // bfs
        var level = -1
        var count = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                for (index in 0..3) {
                    val nextX = current[0] + deltaX[index]
                    val nextY = current[1] + deltaY[index]
                    if (inBound(grid, nextX, nextY) &&
                        !visited[nextX][nextY] &&
                        grid[nextX][nextY] == 1
                    ) {
                        queue.offer(intArrayOf(nextX, nextY))
                        visited[nextX][nextY] = true
                        ++count
                    }
                }
            }
            ++level
        }
        return if (count == freshOranges) level else -1
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}

fun main() {
    val solution = RottingOrangesKotlin994()
    // 4
    println(
        solution.orangesRotting(
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 1)
            )
        )
    )
    // -1
    println(
        solution.orangesRotting(
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(0, 1, 1),
                intArrayOf(1, 0, 1)
            )
        )
    )
}