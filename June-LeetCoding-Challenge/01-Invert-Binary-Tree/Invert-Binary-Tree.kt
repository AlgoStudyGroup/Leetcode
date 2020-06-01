class InvertBinaryTreeKotlin226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        invert(root)
        return root
    }

    private fun invert(root: TreeNode?) {
        if (root == null) {
            return
        }
        val temp = root.left
        root.left = root.right
        root.right = temp
        root.left?.let { invert(it) }
        root.right?.let { invert(it) }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}