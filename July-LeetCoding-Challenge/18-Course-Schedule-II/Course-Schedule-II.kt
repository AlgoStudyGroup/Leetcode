package graph

class CourseScheduleKotlin207 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // 1 true, -1 false, 0 not judge
        val coursesArray = IntArray(numCourses)
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        for (pre in prerequisites) {
            graph.computeIfAbsent(pre[1]) { mutableListOf() }.add(pre[0])
        }
        for (index in coursesArray.indices) {
            if (!dfs(index, coursesArray, graph)) {
                return false
            }
        }
        return true
    }

    // true -> can finish
    private fun dfs(
        current: Int,
        coursesArray: IntArray,
        graph: Map<Int, List<Int>>
    ): Boolean {
        return when {
            coursesArray[current] == -1 -> false
            coursesArray[current] == 1 -> true
            else -> {
                coursesArray[current] = -1
                graph[current]?.forEach {
                    if (!dfs(it, coursesArray, graph)) {
                        return false
                    }
                }
                coursesArray[current] = 1
                true
            }
        }
    }
    /*
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val coursesArray = IntArray(numCourses)
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        for (pre in prerequisites) {
            graph.computeIfAbsent(pre[1]) { mutableListOf() }.add(pre[0])
            ++coursesArray[pre[0]]
        }
        val queue: Queue<Int> = LinkedList()
        coursesArray.forEachIndexed { index, i ->
            if (i == 0) {
                queue.offer(index)
            }
        }
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            graph[current]?.forEach {
                if (--coursesArray[it] == 0) {
                    queue.offer(it)
                }
            }
        }
        return coursesArray.count { it == 0 } == numCourses
    }
     */
}

fun main() {
    val solution = CourseScheduleKotlin207()
    // true
    println(solution.canFinish(2, arrayOf(intArrayOf(0, 1))))
    // false
    println(solution.canFinish(2, arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
    // true
    println(solution.canFinish(3, arrayOf(intArrayOf(2, 1), intArrayOf(1, 0))))
}