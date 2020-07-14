package not_categorized_easy

class SameTreeKotlin100 {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean = when {
        p == null && q == null -> true
        p == null || q == null || p.`val` != q.`val` -> false
        else -> isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}