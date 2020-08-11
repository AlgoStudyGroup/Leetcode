package binary_tree

class AddandSearchWordKotlin211 {
    /** Initialize your data structure here. */
    val root = PrefixTree()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        var current = root
        word.forEach {
            if (current.getByChar(it) == null) {
                current.addChar(it, PrefixTree())
            }
            current = current.getByChar(it)!!
        }
        current.setEnd(true)
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean = search(word, root)

    private fun search(word: String, prefixTree: PrefixTree): Boolean {
        var current = prefixTree
        word.forEachIndexed { index, c ->
            when {
                c == '.' -> {
                    val new = word.substring(index + 1, word.length)
                    for (char in 'a'..'z') {
                        if (current.getByChar(char) != null && search(new, current.getByChar(char)!!)) {
                            return true
                        }
                    }
                    return false
                }
                current.getByChar(c) != null -> current = current.getByChar(c)!!
                else -> return false
            }
        }
        return current.isEnd()
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
    }
}

fun main() {
    val solution = AddandSearchWordKotlin211()
    solution.addWord("a")
    println(solution.search("a."))
    solution.addWord("bad")
    println(solution.search("bad"))
    println(solution.search(".ad"))
    println(solution.search("..d"))
}