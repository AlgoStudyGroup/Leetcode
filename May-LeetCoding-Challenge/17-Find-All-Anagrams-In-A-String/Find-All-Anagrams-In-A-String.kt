class FindAllAnagramsinaStringKotlin438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.isEmpty() || s.length < p.length) {
            return emptyList()
        }
        val result = mutableListOf<Int>()
        val hashArray = IntArray(26)
        for (index in p.indices) {
            ++hashArray[p[index] - 'a']
        }
        var left = 0
        var count = 0
        /*
           0 1 2 3 4
        S: b a b a e ...
        P: a b b
        for
           a  b  e
        P  1  2  0
        0  1  1  0  count = 1
        1  0  1  0  count = 2
        2  0  0  0  count = 3   left = 0 OK
        3  0  1  0  count = 2   left = 1 NOT
        4  1  1  -1  count = 1   left = 2 NOT
         */

        for (index in s.indices) {
            if (--hashArray[s[index] - 'a'] >= 0) {
                ++count
            }
            if (index >= p.length) {
                if (hashArray[s[left++] - 'a']++ >= 0) {
                    --count
                }
            }
            if (count == p.length) {
                result.add(left)
            }
        }
        return result
    }
    /*
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.isEmpty() || s.length < p.length) {
            return emptyList()
        }
        val result = mutableListOf<Int>()
        val hashArray = IntArray(26)
        for (index in p.indices) {
            ++hashArray[p[index] - 'a']
            --hashArray[s[index] - 'a']
        }
        if (hashArray.count { it == 0 } == 26) {
            result.add(0)
        }
        for (index in 1..s.length - p.length) {
            ++hashArray[s[index - 1] - 'a']
            --hashArray[s[index + p.length - 1] - 'a']
            if (hashArray.count { it == 0 } == 26) {
                result.add(index)
            }
        }
        return result
    }
     */
}

fun main() {
    val solution = FindAllAnagramsinaStringKotlin438()
    println(solution.findAnagrams("cbaebabacd", "abc")) // 0,6
    println(solution.findAnagrams("abab", "ab")) // 0,1,2
}