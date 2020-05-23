class IntervalListIntersectionsKotlin986 {
    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        if (A.isEmpty() || B.isEmpty()) {
            return emptyArray()
        }
        val result: MutableList<IntArray> = ArrayList()
        var indexA = 0
        var indexB = 0
        while (indexA < A.size && indexB < B.size) {
            val maxOfStart = maxOf(A[indexA][0], B[indexB][0])
            val minOfEnd = minOf(A[indexA][1], B[indexB][1])
            if (minOfEnd >= maxOfStart) {
                result.add(intArrayOf(maxOfStart, minOfEnd))
            }
            when {
                A[indexA][1] <= B[indexB][1] -> ++indexA
                else -> ++indexB
            }
        }
        return result.toTypedArray()
    }
    /*
    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        if (A.isEmpty() || B.isEmpty()) {
            return emptyArray()
        }
        val result: MutableList<IntArray> = ArrayList()
        var indexA = 0
        var indexB = 0
        while (indexA < A.size && indexB < B.size) {
            val aStart = A[indexA][0]
            val aEnd = A[indexA][1]
            val bStart = B[indexB][0]
            val bEnd = B[indexB][1]
            when {
                aEnd < bStart -> ++indexA
                bEnd < aStart -> ++indexB
                else -> {
                    result.add(
                        intArrayOf(
                            maxOf(aStart, bStart),
                            minOf(aEnd, bEnd)
                        )
                    )
                    when {
                        aEnd <= bEnd -> ++indexA
                        else -> ++indexB
                    }
                }
            }
        }
        return result.toTypedArray()
    }
     */
}