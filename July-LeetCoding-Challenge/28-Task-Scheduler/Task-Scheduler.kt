package string_integer

class TaskSchedulerKotlin621 {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val chars = IntArray(26)
        tasks.forEach {
            ++chars[it - 'A']
        }
        chars.sort()
        var index = 25
        while (index >= 0 && chars[index] == chars[25]) {
            --index
        }
        val result = (chars[25] - 1) * (n + 1) + 25 - index
        return maxOf(tasks.size, result)
    }
}