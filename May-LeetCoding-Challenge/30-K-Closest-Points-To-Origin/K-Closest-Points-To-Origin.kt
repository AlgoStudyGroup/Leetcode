class KClosestPointstoOriginKotlin973 {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        var start = 0
        var end = points.size - 1
        while (start < end) {
            val flag = quickSort(points, start, end)
            when {
                flag == K -> return points.copyOfRange(0, K)
                flag < K -> start = flag
                flag > K -> end = flag
            }
        }
        return points.copyOfRange(0, K)
    }

    private fun quickSort(nums: Array<IntArray>, start: Int, end: Int): Int {
        // val pivot = nums[start + (end - start).shr(1)]
        val pivot = nums[start]
        var left = start
        var right = end
        while (left <= right) {
            while (left <= right && compare(pivot, nums[left]) > 0) {
                ++left
            }
            while (left <= right && compare(pivot, nums[right]) < 0) {
                --right
            }
            if (left <= right) {
                val temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                ++left
                --right
            }
        }
        return left
    }

    private fun compare(point1: IntArray, point2: IntArray): Int {
        return compareValues(
            point1[0] * point1[0] + point1[1] * point1[1],
            point2[0] * point2[0] + point2[1] * point2[1]
        )
    }

    /*
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        val priorityQueue: PriorityQueue<IntArray> = PriorityQueue(K, Comparator { point1, point2 ->
            compareValues(
                point2[0] * point2[0] + point2[1] * point2[1],
                point1[0] * point1[0] + point1[1] * point1[1]
            )
        })
        points.forEach {
            priorityQueue.offer(it)
            if (priorityQueue.size - K > 0) {
                priorityQueue.poll()
            }
        }
        return priorityQueue.toTypedArray()
    }
     */

    /*
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        points.sortWith(Comparator { point1, point2 ->
            compareValues(
                point1[0] * point1[0] + point1[1] * point1[1],
                point2[0] * point2[0] + point2[1] * point2[1]
            )
        })
        return points.copyOfRange(0, K)
    }
     */
}

fun main() {
    val solution = KClosestPointstoOriginKotlin973()

    println("=======10 7=========")
    solution.kClosest(
        arrayOf(
            intArrayOf(-2, 10),
            intArrayOf(-4, -8),
            intArrayOf(10, 7),
            intArrayOf(-4, -7)
        ), 3
    ).forEach {
        it.forEach { n -> print("$n ") }
        println()
    }

    solution.kClosest(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)), 2).forEach {
        it.forEach { n -> print("$n ") }
        println()
    }

    println("=========3 3 -2 4=======")
    solution.kClosest(arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)), 2).forEach {
        it.forEach { n -> print("$n ") }
        println()
    }

    println("=========-2,2=======")
    solution.kClosest(arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)), 1).forEach {
        it.forEach { n -> print("$n ") }
        println()
    }

    println("=========1,1=======")
    solution.kClosest(
        arrayOf(
            intArrayOf(2, 2),
            intArrayOf(2, 2),
            intArrayOf(2, 2),
            intArrayOf(2, 2),
            intArrayOf(2, 2),
            intArrayOf(2, 2),
            intArrayOf(1, 1)
        ),
        1
    ).forEach {
        it.forEach { n -> print("$n ") }
        println()
    }
}
