package string_integer

class ReverseWordsinaStringKotlin151 {
    fun reverseWords(s: String): String =
        s.trim()
            .split("\\s+".toRegex())
            .reversed()
            .joinToString(separator = " ")
    /*
    fun reverseWords(s: String): String {
        val list: MutableList<String> = LinkedList()
        var index = 0
        while (index < s.length) {
            if (s[index] == ' ') {
                ++index
            } else {
                val stringBuilder = StringBuilder()
                while (index < s.length && s[index] != ' ') {
                    stringBuilder.append(s[index])
                    ++index
                }
                list.add(stringBuilder.toString())
            }
        }
        val result = StringBuilder()
        for (i in list.size - 1 downTo 0) {
            result.append(list[i])
            if (i != 0){
                result.append(" ")
            }
        }
        return result.toString()
    }
     */
}

fun main() {
    val solution = ReverseWordsinaString151()
    // blue is sky the
    println(solution.reverseWords("the sky is blue"))
    // world! hello
    println(solution.reverseWords("  hello world!  "))
    // example good a
    println(solution.reverseWords("a good   example"))
}