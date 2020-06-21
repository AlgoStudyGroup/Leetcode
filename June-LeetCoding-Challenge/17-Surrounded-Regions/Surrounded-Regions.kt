class SurroundedRegionsKotlin130 {
    fun solve(board: Array<CharArray>) {
        if (board.isEmpty()) {
            return
        }
        val maxX = board.size
        val maxY = board[0].size
        val dp = Array(maxX) { IntArray(maxY) { 0 } }
        for (index in board[0].indices) {
            if (board[0][index] == 'O') {
                dfs(board, dp, 0, index, maxX, maxY)
            }
            if (board[maxX - 1][index] == 'O') {
                dfs(board, dp, maxX - 1, index, maxX, maxY)
            }
        }
        for (index in board.indices) {
            if (board[index][0] == 'O') {
                dfs(board, dp, index, 0, maxX, maxY)
            }
            if (board[index][maxY - 1] == 'O') {
                dfs(board, dp, index, maxY - 1, maxX, maxY)
            }
        }
        for (i in 1..board.size - 2) {
            for (j in 1..board[0].size - 2) {
                if (board[i][j] == 'O' && dp[i][j] == 0) {
                    board[i][j] = 'X'
                }
            }
        }
    }

    private val deltaX = intArrayOf(0, 0, 1, -1)
    private val deltaY = intArrayOf(1, -1, 0, 0)

    private fun dfs(
        board: Array<CharArray>,
        dp: Array<IntArray>,
        x: Int,
        y: Int,
        maxX: Int,
        maxY: Int
    ) {
        if (dp[x][y] == 0 && board[x][y] == 'O') {
            dp[x][y] = 1
            for (index in deltaX.indices) {
                val nextX = x + deltaX[index]
                val nextY = y + deltaY[index]
                if (inBoardMinus1(nextX, nextY, maxX, maxY)) {
                    dfs(board, dp, nextX, nextY, maxX, maxY)
                }
            }
        }
    }

    private fun inBoardMinus1(x: Int, y: Int, maxX: Int, maxY: Int) = x > 0 && y > 0 && x < maxX - 1 && y < maxY - 1
    /*
    fun solve(board: Array<CharArray>) {
        if (board.isEmpty()) {
            return
        }
        val maxX = board.size
        val maxY = board[0].size
        val dp = Array(maxX) { IntArray(maxY) { 0 } }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        for (index in board[0].indices) {
            if (board[0][index] == 'O') {
                queue.offer(Pair(0, index))
            }
            if (board[maxX - 1][index] == 'O') {
                queue.offer(Pair(maxX - 1, index))
            }
        }
        for (index in board.indices) {
            if (board[index][0] == 'O') {
                queue.offer(Pair(index, 0))
            }
            if (board[index][maxY - 1] == 'O') {
                queue.offer(Pair(index, maxY - 1))
            }
        }
        val deltaX = intArrayOf(0, 0, 1, -1)
        val deltaY = intArrayOf(1, -1, 0, 0)
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val x = current.first
            val y = current.second
            if (dp[x][y] == 0 && board[x][y] == 'O') {
                dp[x][y] = 1
                for (index in deltaX.indices) {
                    val nextX = x + deltaX[index]
                    val nextY = y + deltaY[index]
                    if (inBoardMinus1(nextX, nextY, maxX, maxY)) {
                        queue.offer(Pair(nextX, nextY))
                    }
                }
            }
        }
        for (i in 1..board.size - 2) {
            for (j in 1..board[0].size - 2) {
                if (board[i][j] == 'O' && dp[i][j] == 0) {
                    board[i][j] = 'X'
                }
            }
        }
    }

    private fun inBoardMinus1(x: Int, y: Int, maxX: Int, maxY: Int) = x > 0 && y > 0 && x < maxX - 1 && y < maxY - 1

     */
}

fun main() {
    val solution = SurroundedRegionsKotlin130()
    val testArray = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'X')
    )
    solution.solve(testArray)
    println()
}