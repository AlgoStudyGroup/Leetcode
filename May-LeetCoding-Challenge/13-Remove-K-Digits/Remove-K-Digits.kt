import java.util.*

class RemoveKDigitsKotlin402 {
    fun removeKdigits(num: String, k: Int): String {
        if (num.length == k) {
            return "0"
        }
        val charStack: Stack<Char> = Stack()
        var currentK = k
        num.forEach {
            while (currentK > 0 && charStack.isNotEmpty() && charStack.peek() > it) {
                charStack.pop()
                --currentK
            }
            charStack.push(it)
        }
        while (currentK > 0) {
            charStack.pop()
            --currentK
        }
        val result = StringBuilder()
        while (charStack.isNotEmpty()) {
            result.append(charStack.pop())
        }
        result.reverse()
        return when (result.length) {
            1 -> result.toString()
            else -> {
                while (result.length > 1 && result[0] == '0') {
                    result.deleteCharAt(0)
                }
                result.toString()
            }
        }
    }
    /*
    fun removeKdigits(num: String, k: Int): String {
        if (num.length == k) {
            return "0"
        }
        val result = StringBuilder(num)
        for (i in 1..k) {
            var index = 0
            while (index < result.length - 1 && result[index] <= result[index + 1]) {
                index++
            }
            result.deleteCharAt(index)
        }
        return when (result.length) {
            1 -> result.toString()
            else -> {
                while (result.length > 1 && result[0] == '0') {
                    result.deleteCharAt(0)
                }
                result.toString()
            }
        }
    }
     */
    /*
    !! wrong !!
    private fun recursion(
        num: String,
        result: IntArray,
        start: Int,
        stringBuilder: StringBuilder,
        remain: Int
    ) {
        if (remain == 0) {
            val currentInt = stringBuilder.toString().toInt()
            if (currentInt < result[0]) {
                result[0] = currentInt
            }
        } else {
            for (index in start until num.length) {
                recursion(num, result, index + 1, stringBuilder.append(num[index]), remain - 1)
                stringBuilder.deleteCharAt(stringBuilder.length - 1)
            }
        }
    }
     */
    /*
    !! wrong !!
    private fun getIntAfterRemoveRange(nums: String, start: Int, end: Int): Int {
        val resultString = "${nums.substring(0, start)}${nums.substring(end, nums.length)}"
        return when {
            resultString.isEmpty() -> 0
            else -> resultString.toInt()
        }
     */
}

fun main() {
    val solution = RemoveKDigitsKotlin402()
    println(solution.removeKdigits("5337", 2)) // 33
    println(solution.removeKdigits("1432219", 3)) // 1219
    println(solution.removeKdigits("53037", 4)) // 0
    println(solution.removeKdigits("530137", 4)) // 0
}