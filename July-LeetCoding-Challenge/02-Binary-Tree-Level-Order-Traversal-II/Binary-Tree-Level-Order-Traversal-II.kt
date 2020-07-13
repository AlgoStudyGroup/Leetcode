package breadth_first_search

import java.util.*

class BinaryTreeLevelOrderTraversalIIKotlin107 {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) {
            return result
        }
        val treeNodeQueue: Queue<TreeNode> = LinkedList()
        treeNodeQueue.offer(root)
        while (treeNodeQueue.isNotEmpty()) {
            val currentLevel = mutableListOf<Int>()
            /*
            val currentSize = treeNodeQueue.size
            for (i in 0 until currentSize) {
             */
            for (i in 0 until treeNodeQueue.size) {
                val current = treeNodeQueue.poll()
                currentLevel.add(current.`val`)
                current.left?.let { treeNodeQueue.offer(it) }
                current.right?.let { treeNodeQueue.offer(it) }
            }
            result.add(0, currentLevel)
        }
        return result
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}