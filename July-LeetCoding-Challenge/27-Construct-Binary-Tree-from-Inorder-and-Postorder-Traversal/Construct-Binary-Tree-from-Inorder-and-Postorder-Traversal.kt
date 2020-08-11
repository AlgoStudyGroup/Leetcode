package binary_tree

class ConstructBinaryTreefromInorderandPostorderTraversalKotlin106 {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? =
        construct(
            inorder,
            0,
            inorder.size - 1,
            postorder,
            0,
            postorder.size - 1
        )

    private fun construct(
        inorder: IntArray,
        iStart: Int,
        iEnd: Int,
        postorder: IntArray,
        pStart: Int,
        pEnd: Int
    ): TreeNode? {
        if (iStart > iEnd || pStart > pEnd) {
            return null
        }
        val treeNode = TreeNode(postorder[pEnd])
        var index = iStart
        while (iStart < inorder.size && inorder[index] != treeNode.`val`) {
            ++index
        }
        treeNode.left = construct(inorder, iStart, index - 1, postorder, pStart, pStart + index - 1 - iStart)
        treeNode.right = construct(inorder, index + 1, iEnd, postorder, pStart + index - iStart, pEnd - 1)
        return treeNode
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    val solution = ConstructBinaryTreefromInorderandPostorderTraversalKotlin106()
    val result = solution.buildTree(
        intArrayOf(9, 3, 15, 20, 7),
        intArrayOf(9, 15, 7, 20, 3)
    )
    println(result)
}