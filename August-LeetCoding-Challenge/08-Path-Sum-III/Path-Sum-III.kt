package binary_tree

class PathSumIIIKotlin437 {
    fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) {
            return 0
        }
        return dfs(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum)
    }

    private fun dfs(
        root: TreeNode?,
        sum: Int,
        pre: Int
    ): Int {
        if (root == null) {
            return 0
        }
        val current = pre + root.`val`
        return if (current == sum) {
            1
        } else {
            0
        } + dfs(root.left, sum, current) + dfs(root.right, sum, current)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    val solution = PathSumIIIKotlin437()
    val node11 = PathSumIIIKotlin437.TreeNode(0)
    val node22 = PathSumIIIKotlin437.TreeNode(1)
    val node33 = PathSumIIIKotlin437.TreeNode(1)
    node11.left = node22
    node11.right = node33
    println(solution.pathSum(node11, 1))

    val node1 = PathSumIIIKotlin437.TreeNode(10)
    val node2 = PathSumIIIKotlin437.TreeNode(5)
    val node3 = PathSumIIIKotlin437.TreeNode(-3)
    val node4 = PathSumIIIKotlin437.TreeNode(3)
    val node5 = PathSumIIIKotlin437.TreeNode(2)
    val node6 = PathSumIIIKotlin437.TreeNode(11)
    val node7 = PathSumIIIKotlin437.TreeNode(3)
    val node8 = PathSumIIIKotlin437.TreeNode(-2)
    val node9 = PathSumIIIKotlin437.TreeNode(1)

    node1.left = node2
    node1.right = node3
    node3.right = node6
    node2.left = node4
    node2.right = node5
    node4.left = node7
    node4.right = node8
    node5.right = node9

    println(solution.pathSum(node1, 8))
}