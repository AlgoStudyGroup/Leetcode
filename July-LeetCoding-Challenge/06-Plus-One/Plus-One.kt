package string_integer

class PlusOneKotlin66 {
    fun plusOne(digits: IntArray): IntArray {
        if (digits[digits.size - 1] != 9) {
            ++digits[digits.size - 1]
            return digits
        }
        var next = 1
        digits[digits.size - 1] = 0
        for (index in digits.size - 2 downTo 0) {
            if (next == 1) {
                if (digits[index] == 9) {
                    digits[index] = 0
                    next = 1
                } else {
                    ++digits[index]
                    next = 0
                }
            }
        }
        if (next == 1 && digits[0] == 0) {
            return intArrayOf(1).plus(digits)
        }
        return digits
    }
}

fun main() {
    val solution = PlusOneKotlin66()
    solution.plusOne(intArrayOf(1, 0, 0)).forEach(::print)
    println()
    solution.plusOne(intArrayOf(1, 9, 9)).forEach(::print)
    println()
    solution.plusOne(intArrayOf(9, 9, 9)).forEach(::print)
    println()
    solution.plusOne(intArrayOf(1, 0, 9)).forEach(::print)
}