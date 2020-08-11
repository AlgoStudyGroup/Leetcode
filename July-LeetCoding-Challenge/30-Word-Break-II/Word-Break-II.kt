package depth_first_search

class WordBreakIIKotlin140 {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val map: MutableMap<String, MutableList<String>> = HashMap()
        return dfs(s, wordDict, map)
    }

    private fun dfs(
        s: String,
        wordDict: List<String>,
        map: MutableMap<String, MutableList<String>>
    ): List<String> {
        if (map.containsKey(s)) {
            return map.getValue(s)
        }
        val results: MutableList<String> = ArrayList()
        if (s.isEmpty()) {
            results.add("")
            return results
        }

        for (word in wordDict) {
            if (s.startsWith(word)) {
                val subResult = dfs(s.substring(word.length), wordDict, map)
                subResult.forEach {
                    if (it.isEmpty()) {
                        results.add(word)
                    } else {
                        results.add("$word $it")
                    }
                }
            }
        }
        map[s] = results
        return results
    }

    /*
    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    Time Limit Exceed
     */
    /*
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val wordSet = wordDict.toSet()
        val visited = BooleanArray(s.length + 1)
        val subsets: MutableList<String> = LinkedList()
        val results: MutableList<MutableList<String>> = LinkedList()
        dfs(s, wordSet, visited, 0, subsets, results)
        return results.map { it.joinToString(separator = " ") }
    }

    private fun dfs(
        s: String,
        wordSet: Set<String>,
        visited: BooleanArray,
        current: Int,
        subsets: MutableList<String>,
        results: MutableList<MutableList<String>>
    ) {
        if (current == s.length) {
            results.add(ArrayList(subsets))
            return
        }
        for (index in current + 1..s.length) {
            val currentString = s.substring(current, index)
            if (!visited[index] && wordSet.contains(currentString)) {
                visited[index] = true
                subsets.add(currentString)
                dfs(s, wordSet, visited, index, subsets, results)
                visited[index] = false
                subsets.removeAt(subsets.size - 1)
            }
        }
    }
     */
}

fun main() {
    val solution = WordBreakIIKotlin140()
    solution.wordBreak(
        "catsanddog",
        listOf("cat", "cats", "and", "sand", "dog")
    ).forEach(::print)
}