package depth_first_search

class WordSearchKotlin79 {
    var result = false

    fun exist(board: Array<CharArray>, word: String): Boolean {
        result = false
        for (x in board.indices) {
            for (y in board[0].indices) {
                if (result) {
                    return true
                }
                if (board[x][y] == word[0]) {
                    dfs(board, x, y, word, 0)
                }
            }
        }
        return result
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)

    private fun dfs(board: Array<CharArray>, x: Int, y: Int, word: String, current: Int) {
        if (current == word.length - 1) {
            result = true
            return
        }
        val value = board[x][y]
        board[x][y] = '*'
        for (index in deltaX.indices) {
            val nextX = x + deltaX[index]
            val nextY = y + deltaY[index]
            if (inBound(board, nextX, nextY) && board[nextX][nextY] == word[current + 1] && !result) {
                dfs(board, nextX, nextY, word, current + 1)
            }
        }
        board[x][y] = value
    }

    private fun inBound(
        grid: Array<CharArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
    /*
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (x in board.indices) {
            for (y in board[0].indices) {
                if (board[x][y] == word[0]) {
                    if (dfs(board, x, y, word, 0)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)

    private fun dfs(board: Array<CharArray>, x: Int, y: Int, word: String, current: Int): Boolean {
        if (current == word.length - 1) {
            return true
        }
        val value = board[x][y]
        board[x][y] = '*'
        var result = false
        for (index in deltaX.indices) {
            val nextX = x + deltaX[index]
            val nextY = y + deltaY[index]
            if (inBound(board, nextX, nextY) && board[nextX][nextY] == word[current + 1] && !result) {
                if (dfs(board, nextX, nextY, word, current + 1)) {
                    result = true
                }
            }
        }
        board[x][y] = value
        return result
    }

    private fun inBound(
        grid: Array<CharArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
     */
}

fun main() {
    val test = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )
    val solution = WordSearchKotlin79()
    // true true false
    println(solution.exist(test, "ABCCED"))
    println(solution.exist(test, "SEE"))
    println(solution.exist(test, "ABCB"))
}