import java.util.*

class CousinsinBinaryTreeKotlin993 {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val treeNodeQueue: Queue<TreeNode> = LinkedList()
        treeNodeQueue.offer(root)
        while (treeNodeQueue.isNotEmpty()) {
            val currentLevel = mutableListOf<Int>()
            for (i in 0 until treeNodeQueue.size) {
                val current = treeNodeQueue.poll()
                currentLevel.add(current.`val`)
                if (current.`val` == 0) {
                    continue
                }
                when (current.left) {
                    null -> treeNodeQueue.offer(
                        TreeNode(
                            0
                        )
                    )
                    else -> treeNodeQueue.offer(current.left)
                }
                when (current.right) {
                    null -> treeNodeQueue.offer(
                        TreeNode(
                            0
                        )
                    )
                    else -> treeNodeQueue.offer(current.right)
                }
            }
            val indexX = currentLevel.indexOf(x)
            if (indexX != -1) {
                val indexY = currentLevel.indexOf(y)
                return when {
                    indexY == -1 -> false
                    indexX % 2 == 0 -> indexX + 1 != indexY
                    else -> indexX - 1 != indexY
                }
            }
        }
        return false
    }

    /*
    fun bfs(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) {
            return result
        }
        val treeNodeQueue: Queue<TreeNode> = LinkedList()
        treeNodeQueue.offer(root)
        while (treeNodeQueue.isNotEmpty()) {
            val currentLevel = mutableListOf<Int>()
            for (i in 0 until treeNodeQueue.size) {
                val current = treeNodeQueue.poll()
                currentLevel.add(current.`val`)
                if (current.`val` == 0) {
                    continue
                }
                when (current.left) {
                    null -> treeNodeQueue.offer(TreeNode(0))
                    else -> treeNodeQueue.offer(current.left)
                }
                when (current.right) {
                    null -> treeNodeQueue.offer(TreeNode(0))
                    else -> treeNodeQueue.offer(current.right)
                }
            }
            result.add(currentLevel)
        }
        return result
    }
     */

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    val solution = CousinsinBinaryTreeKotlin993()
    val treeNode1 = CousinsinBinaryTreeKotlin993.TreeNode(1)
    val treeNode2 = CousinsinBinaryTreeKotlin993.TreeNode(2)
    val treeNode3 = CousinsinBinaryTreeKotlin993.TreeNode(3)
    val treeNode4 = CousinsinBinaryTreeKotlin993.TreeNode(4)
    val treeNode5 = CousinsinBinaryTreeKotlin993.TreeNode(5)
    treeNode1.left = treeNode2
    treeNode1.right = treeNode3
    treeNode2.right = treeNode4
    println(solution.isCousins(treeNode1, 4, 3))

    treeNode3.left = treeNode5

    println(solution.isCousins(treeNode1, 5, 4))
}