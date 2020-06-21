class SearchinaBinarySearchTreeKotlin700 {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        return when {
            root == null -> null
            root.`val` == `val` -> root
            root.`val` < `val` -> searchBST(root.right, `val`)
            root.`val` > `val` -> searchBST(root.left, `val`)
            else -> null
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}