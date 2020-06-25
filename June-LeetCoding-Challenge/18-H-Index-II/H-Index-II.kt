class HIndexIIKotlin275 {
    fun hIndex(citations: IntArray): Int {
        if (citations.isEmpty()) {
            return 0
        }
        var left = 0
        var right = citations.size
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                citations[citations.size - mid] >= mid -> left = mid
                else -> right = mid
            }
        }
        return when {
            citations[citations.size - right] >= right -> right
            left == 0 -> 0
            citations[citations.size - left] >= left -> left
            else -> -1
        }
    }
}