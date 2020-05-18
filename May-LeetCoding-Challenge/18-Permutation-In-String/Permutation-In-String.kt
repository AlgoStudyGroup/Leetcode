class PermutationinStringKotlin567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.isEmpty() || s1.length > s2.length) {
            return false
        }
        val hashArray = IntArray(26)
        for (index in s1.indices) {
            ++hashArray[s1[index] - 'a']
        }
        var count = 0
        var left = 0
        for (index in s2.indices) {
            if (--hashArray[s2[index] - 'a'] >= 0) {
                ++count
            }
            if (index >= s1.length && hashArray[s2[left++] - 'a']++ >= 0) {
                --count
            }
            if (count == s1.length) {
                return true
            }
        }
        return false
    }
    /*
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.isEmpty() || s1.length > s2.length) {
            return false
        }
        val hashArray = IntArray(26)
        for (index in s1.indices) {
            ++hashArray[s1[index] - 'a']
            --hashArray[s2[index] - 'a']
        }
        if (hashArray.count { it == 0 } == 26) {
            return true
        }
        for (index in 1..s2.length - s1.length) {
            ++hashArray[s2[index - 1] - 'a']
            --hashArray[s2[index + s1.length - 1] - 'a']
            if (hashArray.count { it == 0 } == 26) {
                return true
            }
        }
        return false
    }
     */
}

fun main() {
    val solution = PermutationinStringKotlin567()
    println(solution.checkInclusion("ab", "eidbaooo")) // true
    println(solution.checkInclusion("ab", "eidboaoo")) // false
}