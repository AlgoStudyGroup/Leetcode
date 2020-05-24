class ConstructBinarySearchTreefromPreorderTraversalKotlin1008 {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        return construct(preorder, 0, preorder.size - 1)
    }

    private fun construct(preorder: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end || start == preorder.size) {
            return null
        }
        val current = TreeNode(preorder[start])
        var rightIndex = start + 1
        while (rightIndex <= end && current.`val` > preorder[rightIndex]) {
            ++rightIndex
        }
        current.left = construct(preorder, start + 1, rightIndex - 1)
        current.right = construct(preorder, rightIndex, end)
        return current
    }
    /*
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null
        }
        val root =
            TreeNode(
                preorder[0]
            )
        var index = 1
        while (index < preorder.size && preorder[0] > preorder[index]) {
            ++index
        }
        root.left = bstFromPreorder(preorder.sliceArray(IntRange(1, index - 1)))
        root.right = bstFromPreorder(preorder.sliceArray(IntRange(index, preorder.size - 1)))
        return root
    }
     */

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    val array = intArrayOf(8, 5, 1, 7, 10, 12)
    array.sliceArray(IntRange(1, 3)).forEach(::print)
    println()
    array.sliceArray(IntRange(4, 5)).forEach(::print)
}
