package breadth_first_search

import java.util.*

class BinaryTreeZigzagLevelOrderTraversalKotlin103 {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) {
            return result
        }
        val treeNodeQueue: Queue<TreeNode> = LinkedList()
        treeNodeQueue.offer(root)
        var flag = false
        while (treeNodeQueue.isNotEmpty()) {
            val currentLevel = mutableListOf<Int>()
            for (i in 0 until treeNodeQueue.size) {
                val current = treeNodeQueue.poll()
                if (flag) {
                    currentLevel.add(0, current.`val`)
                } else {
                    currentLevel.add(current.`val`)
                }
                current.left?.let { treeNodeQueue.offer(it) }
                current.right?.let { treeNodeQueue.offer(it) }
            }
            result.add(currentLevel)
            flag = !flag
        }
        return result
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}