package depth_first_search

import java.util.*
import kotlin.collections.ArrayList

class AllPathsFromSourcetoTargetKotlin797 {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val result: MutableList<MutableList<Int>> = LinkedList()
        val subsets: MutableList<Int> = LinkedList()

        dfs(result, subsets, graph, 0)
        return result
    }

    private fun dfs(
        result: MutableList<MutableList<Int>>,
        subsets: MutableList<Int>,
        graph: Array<IntArray>,
        index: Int
    ) {
        subsets.add(index)
        if (graph[index].isEmpty()) {
            result.add(ArrayList(subsets))
        } else {
            graph[index].forEach {
                dfs(result, subsets, graph, it)
                subsets.removeAt(subsets.size - 1)
            }
        }
    }
}

fun main() {
    val solution = AllPathsFromSourcetoTargetKotlin797()
    val result = solution.allPathsSourceTarget(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3),
            intArrayOf(3),
            intArrayOf()
        )
    )
    println(result)
}