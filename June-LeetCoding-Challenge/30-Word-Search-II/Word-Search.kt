package depth_first_search

class WordSearchIIKotlin212 {
    private var result: MutableSet<String> = HashSet()
    private val prefixTree = TriePrefixTreeKotlin()

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        words.forEach {
            prefixTree.insert(it)
        }
        result.clear()
        for (x in board.indices) {
            for (y in board[0].indices) {
                if (prefixTree.root.getByChar(board[x][y]) != null) {
                    dfs(board, x, y, prefixTree.root.getByChar(board[x][y])!!, board[x][y].toString())
                }
            }
        }
        return result.toList()
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)

    private fun dfs(
        board: Array<CharArray>,
        x: Int,
        y: Int,
        current: TriePrefixTreeKotlin.PrefixTree,
        str: String
    ) {
        if (current.isEnd()) {
            result.add(str)
            // prefixTree.remove(str)
        }
        val value = board[x][y]
        board[x][y] = '*'
        for (index in deltaX.indices) {
            val nextX = x + deltaX[index]
            val nextY = y + deltaY[index]

            if (inBound(board, nextX, nextY)) {
                val nextChar = board[nextX][nextY]
                if (nextChar != '*' && current.getByChar(nextChar) != null) {
                    dfs(board, nextX, nextY, current.getByChar(nextChar)!!, str + nextChar)
                }
            }
        }
        board[x][y] = value
    }

    private fun inBound(
        grid: Array<CharArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size

    class TriePrefixTreeKotlin {
        /** Initialize your data structure here. */
        val root = PrefixTree()

        /** Inserts a word into the trie. */
        fun insert(word: String) {
            var current = root
            word.forEach {
                if (current.getByChar(it) == null) {
                    current.addChar(it, PrefixTree())
                }
                current = current.getByChar(it)!!
            }
            current.setEnd(true)
        }

        /** Returns if the word is in the trie. */
        fun search(word: String): Boolean {
            var current = root
            word.forEach {
                when {
                    current.getByChar(it) != null -> current = current.getByChar(it)!!
                    else -> return false
                }
            }
            return current.isEnd()
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        fun startsWith(prefix: String): Boolean {
            var current = root
            prefix.forEach {
                when {
                    current.getByChar(it) != null -> current = current.getByChar(it)!!
                    else -> return false
                }
            }
            return true
        }

        /** remove a work */
        fun remove(word: String) {
            if (search(word)) {
                recursionRemove(word, 0, root)
            }
        }

        private fun recursionRemove(word: String, index: Int, prefixTree: PrefixTree) {
            if (word.length - 2 >= 0 && index != word.length - 2) {
                recursionRemove(word, index + 1, prefixTree.getByChar(word[index])!!)
            }
            val current = prefixTree.getByChar(word[index])!!
            if (index + 1 < word.length) {
                val next = current.getByChar(word[index + 1])!!
                if (next.canDelete()) {
                    current.remove(word[index + 1])
                }
            }
            if (index == 0 && current.canDelete()) {
                prefixTree.remove(word[0])
            }
        }

        class PrefixTree {
            private val links: Array<PrefixTree?> = Array(26) { null }
            private var isEnd = false

            fun addChar(c: Char, prefixTree: PrefixTree) {
                this.links[c - 'a'] = prefixTree
            }

            fun isEnd() = this.isEnd

            fun getByChar(c: Char): PrefixTree? = this.links[c - 'a']

            fun setEnd(boolean: Boolean) {
                this.isEnd = boolean
            }

            fun canDelete(): Boolean = links.filterNotNull().isEmpty()

            fun remove(c: Char) {
                this.links[c - 'a'] = null
            }
        }
    }
}

fun main() {
    val solution = WordSearchIIKotlin212()
    val test3 = arrayOf(
        charArrayOf('a', 'b'),
        charArrayOf('a', 'a')
    )
    // ["aaa","aaab","aaba","aba","baa"]
    println(solution.findWords(test3, arrayOf("aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba")))

    val test2 = arrayOf(charArrayOf('a'))
    println(solution.findWords(test2, arrayOf("a")))

    val test = arrayOf(
        charArrayOf('o', 'a', 'a', 'n'),
        charArrayOf('e', 't', 'a', 'e'),
        charArrayOf('i', 'h', 'k', 'r'),
        charArrayOf('i', 'f', 'l', 'v')
    )
    val words = arrayOf("oath", "pea", "eat", "rain")
    // ["eat","oath"]
    println(solution.findWords(test, words))

    /*
    input
    [["a","b"],["a","a"]]
    ["aba","baa","bab","aaab","aaa","aaaa","aaba"]
    Output
    ["aaa","aba","aaba","baa"]
    Expected
    ["aaa","aaab","aaba","aba","baa"]
     */
}
