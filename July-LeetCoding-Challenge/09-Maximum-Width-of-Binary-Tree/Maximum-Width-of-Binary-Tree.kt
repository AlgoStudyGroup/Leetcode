package breadth_first_search

import java.util.*

class MaximumWidthofBinaryTreeKotlin662 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun widthOfBinaryTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var result = 1
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
        queue.offer(Pair(root, 1))
        while (queue.isNotEmpty()) {
            if (queue.size == 1) {
                val current = queue.poll()
                current.first.left?.let { queue.offer(Pair(it, 2)) }
                current.first.right?.let { queue.offer(Pair(it, 3)) }
            } else {
                var min = Int.MAX_VALUE
                var max = Int.MIN_VALUE
                for (index in 0 until queue.size) {
                    val current = queue.poll()
                    val value = current.second
                    min = minOf(value, min)
                    max = maxOf(value, max)
                    current.first.left?.let { queue.offer(Pair(it, value.shl(1))) }
                    current.first.right?.let { queue.offer(Pair(it, value.shl(1) + 1)) }
                }
                result = maxOf(result, max - min + 1)
            }
        }
        return result
    }
}