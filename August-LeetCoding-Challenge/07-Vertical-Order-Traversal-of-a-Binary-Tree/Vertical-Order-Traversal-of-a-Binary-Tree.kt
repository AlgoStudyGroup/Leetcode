package breadth_first_search

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class VerticalOrderTraversalofaBinaryTreeKotlin987 {
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val result: MutableList<MutableList<Int>> = LinkedList()
        if (root == null) {
            return result
        }
        val map: MutableMap<Int, MutableList<Int>> = HashMap()
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
        queue.offer(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val currentMap: MutableMap<Int, MutableList<Int>> = HashMap()
            for (size in queue.indices) {
                val current = queue.poll()
                val node = current.first
                val xIndex = current.second
                currentMap.computeIfAbsent(xIndex) { ArrayList() }.add(node.`val`)

                node.left?.let {
                    queue.offer(Pair(it, xIndex - 1))
                }
                node.right?.let {
                    queue.offer(Pair(it, xIndex + 1))
                }
            }
            for (entry in currentMap) {
                map.computeIfAbsent(entry.key) { ArrayList() }.addAll(entry.value.sorted())
            }
        }
        return map.toList().sortedBy(Pair<Int, MutableList<Int>>::first).map { it.second }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    val solution = VerticalOrderTraversalofaBinaryTreeKotlin987()
    val node3 = VerticalOrderTraversalofaBinaryTreeKotlin987.TreeNode(3)
    val node9 = VerticalOrderTraversalofaBinaryTreeKotlin987.TreeNode(9)
    val node20 = VerticalOrderTraversalofaBinaryTreeKotlin987.TreeNode(20)
    val node15 = VerticalOrderTraversalofaBinaryTreeKotlin987.TreeNode(15)
    val node7 = VerticalOrderTraversalofaBinaryTreeKotlin987.TreeNode(7)

    node3.left = node9
    node3.right = node20
    node20.left = node15
    node20.right = node7

    val result = solution.verticalTraversal(node3)

    result.forEach {
        it.forEach(::print)
        println()
    }
}