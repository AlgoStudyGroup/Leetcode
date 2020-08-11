package string_integer

class ValidPalindromeKotlin125 {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            while (left < right && !s[left].isLetterOrDigit()) {
                ++left
            }
            while (left < right && !s[right].isLetterOrDigit()) {
                --right
            }
            if (s[left++].toUpperCase() != s[right--].toUpperCase()) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val solution = ValidPalindromeKotlin125()
    // true
    println(solution.isPalindrome("A man, a plan, a canal: Panama"))
    // false
    println(solution.isPalindrome("0P"))
}