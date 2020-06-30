package binary_search

class CountCompleteTreeNodesKotlin222 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return 1 + countNodes(root?.left) + countNodes(root?.right)
    }
/*
fun countNodes(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var level = 0
    var current = root
    while (current!!.left != null) {
        level++
        current = current.left
    }
    return search(root, level)
}

private fun search(root: TreeNode, level: Int): Int {
    var left = 1.shl(level)
    var right = 1.shl(level + 1) - 1
    while (left + 1 < right) {
        val mid = left + (right - left) / 2
        when {
            isNotNull(root, mid, level) -> left = mid
            else -> right = mid
        }
    }
    return when {
        isNotNull(root, right, level) -> right
        isNotNull(root, left, level) -> left
        else -> -1
    }
}

private fun isNotNull(root: TreeNode, target: Int, level: Int): Boolean {
    var result: TreeNode? = root
    var start = 1.shl(level)
    var end = 1.shl(level + 1) - 1
    var currentLevel = level
    while (currentLevel > 0) {
        val mid = start + (end - start).shr(1)
        if (target > mid) {
            result = result?.right
            start = mid
        } else {
            result = result?.left
            end = mid
        }
        currentLevel--
    }
    return result != null
}

/*
private fun isNotNull(root: TreeNode, target: Int): Boolean {
    var current = target
    val stack = Stack<Int>()
    while (current != 1) {
        stack.push(current % 2)
        current = current.shr(1)
    }
    var result: TreeNode? = root
    while (stack.size != 0) {
        when (stack.pop()) {
            1 -> result = result?.right
            0 -> result = result?.left
        }
    }
    return result != null
}
 */
}


fun main() {
val solution = CountCompleteTreeNodesKotlin222()

val test = TreeNode(1)
val test2 = TreeNode(2)
test.left = test2
println(solution.countNodes(test))

val root = TreeNode(1)
val node2 = TreeNode(2)
val node3 = TreeNode(3)
val node4 = TreeNode(4)
val node5 = TreeNode(5)
val node6 = TreeNode(6)
val node7 = TreeNode(7)
val node8 = TreeNode(8)
val node9 = TreeNode(9)
val node10 = TreeNode(10)
val node11 = TreeNode(11)
val node12 = TreeNode(12)
root.left = node2
root.right = node3
node2.left = node4
node2.right = node5
node3.left = node6
node3.right = node7
node4.left = node8
node4.right = node9
node5.left = node10
node5.right = node11
node6.left = node12

println(solution.countNodes(root))
}
*/