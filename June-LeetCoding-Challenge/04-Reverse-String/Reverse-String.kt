class ReverseStringKotlin344 {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size - 1
        while (left < right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp
            ++left
            --right
        }
    }
}
