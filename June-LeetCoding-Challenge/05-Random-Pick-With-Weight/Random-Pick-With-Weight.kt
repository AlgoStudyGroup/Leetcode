import kotlin.random.Random

class RandomPickwithWeightKotlin528(w: IntArray) {
    private val accumulateSum: MutableList<Int> = mutableListOf()

    init {
        accumulateSum.add(w[0])
        for (index in 1 until w.size) {
            accumulateSum.add(accumulateSum[index - 1] + w[index])
        }
    }

    fun pickIndex(): Int {
        val target = Random.Default.nextInt(accumulateSum[accumulateSum.size - 1]) + 1
        var left = 0
        var right = accumulateSum.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                accumulateSum[mid] == target -> return mid
                accumulateSum[mid] < target -> left = mid
                accumulateSum[mid] > target -> right = mid
            }
        }
        return when {
            accumulateSum[left] >= target -> left
            accumulateSum[right] >= target -> right
            else -> -1
        }
    }
}