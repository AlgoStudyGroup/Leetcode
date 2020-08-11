package string_integer

class DetectCapitalKotlin520 {
    fun detectCapitalUse(word: String): Boolean {
        val count = word.count { it.isUpperCase() }
        return when {
            count == word.length -> true
            count == 1 && word[0].isUpperCase() -> true
            count == 0 -> true
            else -> false
        }
    }
}