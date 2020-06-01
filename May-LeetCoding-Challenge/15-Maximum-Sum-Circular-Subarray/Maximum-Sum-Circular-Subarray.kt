class MaximumSumCircularSubarrayKotlin918 {
    // Kadane’s Algorithm
    /*
    if maxSum array in [0 until A.size] -> maxSum
    if maxSum array in [..A.size -- 0 ..] -> sumOfArray - minSum
     */
    fun maxSubarraySumCircular(A: IntArray): Int {
        if (A.isEmpty()) {
            return 0
        }
        var sum = 0
        var maxSum = Int.MIN_VALUE
        var minSum = Int.MAX_VALUE
        var currentMax = 0
        var currentMin = 0
        A.forEach {
            currentMax = maxOf(it, currentMax + it)
            maxSum = maxOf(maxSum, currentMax)
            currentMin = minOf(it, currentMin + it)
            minSum = minOf(minSum, currentMin)
            sum += it
        }
        // if all element < 0, return maxSum
        return when {
            maxSum < 0 -> maxSum
            else -> maxOf(maxSum, sum - minSum)
        }
    }
}

fun main() {
    val solution = MaximumSumCircularSubarrayKotlin918()
    println(solution.maxSubarraySumCircular(intArrayOf(1, -2, 3, -2))) // 3
    println(solution.maxSubarraySumCircular(intArrayOf(5, -3, 5))) // 10
    println(solution.maxSubarraySumCircular(intArrayOf(3, -1, 2, -1))) // 4
    println(solution.maxSubarraySumCircular(intArrayOf(3, -2, 2, -3))) // 3
    println(solution.maxSubarraySumCircular(intArrayOf(-3, -2, -5, -8))) // -2
}