package string_integer

class ExcelSheetColumnNumberKotlin171 {

    fun titleToNumber(s: String): Int {
        var base = 26
        if (s.length == 1) {
            return s[0] - '@'
        }
        var result = s[s.length - 1] - '@'
        for (index in s.length - 2 downTo 0) {
            result += (s[index] - '@') * base
            base *= 26
        }
        return result
    }
}

fun main() {
    val solution = ExcelSheetColumnNumberKotlin171()
    // 701
    println(solution.titleToNumber("ZY"))
}