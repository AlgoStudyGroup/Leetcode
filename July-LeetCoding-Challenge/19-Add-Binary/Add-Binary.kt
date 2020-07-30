package string_integer

class AddBinaryKotlin67 {
    fun addBinary(a: String, b: String): String {
        if (a.length > b.length) {
            return addBinary(b, a)
        }
        val diff = b.length - a.length
        var next = 0
        val result = StringBuilder()
        for (index in a.length - 1 downTo 0) {
            val currentA = a[index].toString().toInt()
            val currentB = b[index + diff].toString().toInt()
            when (next + currentA + currentB) {
                0 -> result.append(0)
                1 -> {
                    result.append(1)
                    next = 0
                }
                2 -> {
                    result.append(0)
                    next = 1
                }
                3 -> {
                    result.append(1)
                    next = 1
                }
            }
        }
        for (index in diff - 1 downTo 0) {
            val currentB = b[index].toString().toInt()
            when (currentB + next) {
                0 -> result.append(0)
                1 -> {
                    result.append(1)
                    next = 0
                }
                2 -> {
                    result.append(0)
                    next = 1
                }
            }
        }
        if (next == 1) {
            result.append(next)
        }
        return result.reverse().toString()
    }
}

fun main() {
    val solution = AddBinaryKotlin67()
    // 100
    println(solution.addBinary("11", "1"))
    // 10101
    println(solution.addBinary("1010", "1011"))
    // 1100
    println(solution.addBinary("1011", "1"))
    // 1110
    println(solution.addBinary("1011", "11"))
}