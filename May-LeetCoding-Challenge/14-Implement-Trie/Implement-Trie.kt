class ImplementTriePrefixTreeKotlin208 {
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
        if (index != word.length - 2) {
            recursionRemove(word, index + 1, prefixTree.getByChar(word[index])!!)
        }
        val current = prefixTree.getByChar(word[index])!!
        val next = current.getByChar(word[index + 1])!!
        if (next.canDelete()) {
            current.remove(word[index + 1])
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

fun main() {
    val solution = ImplementTriePrefixTreeKotlin208()
    solution.insert("apple")
    println(solution.search("apple")) // true
    println(solution.search("app")) // false
    println(solution.startsWith("app")) // true
    solution.insert("appxiang")
    solution.remove("apple")
    println(solution.search("appxiang")) // true
    solution.remove("appxiang")
    println(solution.startsWith("app")) // false
    println(solution.startsWith("a")) // false
}