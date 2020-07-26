package string_integer

class AddDigitsKotlin258 {
    fun addDigits(num: Int): Int =
        if (num == 0) 0 else 1 + (num - 1) % 9

    /*
    fun addDigits(num: Int): Int {
        return when {
            num == 0 -> 0
            num % 9 == 0 -> 9
            else -> num % 9
        }
    }
     */
    /*
    fun addDigits(num: Int): Int {
        var result = 0
        var current = num
        while (current != 0) {
            result += current % 10
            current /= 10
            if (current == 0 && result > 9) {
                current = result
                result = 0
            }
        }
        return result
    }
     */
}