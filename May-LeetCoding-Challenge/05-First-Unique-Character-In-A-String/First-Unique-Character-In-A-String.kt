class FirstUniqueCharacterinaStringKotlin387 {
    fun firstUniqChar(s: String): Int {
        var result = Int.MAX_VALUE
        for (char in 'a'..'z') {
            val current = s.indexOf(char)
            if (current != -1 && current == s.lastIndexOf(char)) {
                result = minOf(result, current)
            }
        }
        return when (result) {
            Int.MAX_VALUE -> -1
            else -> result
        }
    }
    /*
    fun firstUniqChar(s: String): Int {
        val intArray = IntArray(26)
        s.forEach { intArray[it - 'a']++ }
        s.forEachIndexed { index, c ->
            if (intArray[c - 'a'] == 1) {
                return index
            }
        }
        return -1
    }
     */
    /*
    fun firstUniqChar(s: String): Int {
        val set = mutableSetOf<Char>()
        val resultSet = mutableSetOf<Char>()
        s.forEach { c ->
            if (set.contains(c)) {
                resultSet.remove(c)
            } else {
                set.add(c)
                resultSet.add(c)
            }
        }
        if (resultSet.size == 0) {
            return -1
        }
        s.forEachIndexed { index, c ->
            if (resultSet.contains(c)) {
                return index
            }
        }
        return -1
    }
     */
}

fun main() {
    val solution = FirstUniqueCharacterinaStringKotlin387()
    println(solution.firstUniqChar("aadadaad"))
}