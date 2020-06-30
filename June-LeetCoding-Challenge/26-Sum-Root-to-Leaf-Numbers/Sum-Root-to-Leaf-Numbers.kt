package breadth_first_search

class SumRoottoLeafNumbersKotlin129 {
    fun sumNumbers(root: TreeNode?): Int {
        root ?: return 0
        return dfs(root, "")
    }

    private fun dfs(node: TreeNode, string: String): Int {
        val currentString = string + node.`val`.toString()
        val leftNode = node.left
        val rightNode = node.right

        if (leftNode == null && rightNode == null) {
            return currentString.toInt()
        }
        val leftVal = if (leftNode == null) 0 else dfs(leftNode, currentString)
        val rightVal = if (rightNode == null) 0 else dfs(rightNode, currentString)
        return leftVal + rightVal
    }
    /*
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<Pair<TreeNode, String>> = LinkedList()
        queue.offer(Pair(root, ""))
        var sum = 0
        while (queue.isNotEmpty()) {
            val currentPair = queue.poll()
            val currentNode = currentPair.first
            val currentString = currentPair.second + currentNode.`val`.toString()
            val leftNode = currentNode.left
            val rightNode = currentNode.right

            if (leftNode == null && rightNode == null) {
                sum += currentString.toInt()
            }
            if (leftNode != null) {
                queue.offer(Pair(leftNode, currentString))
            }
            if (rightNode != null) {
                queue.offer(Pair(rightNode, currentString))
            }

        }
        return sum
    }
     */

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    val solution = SumRoottoLeafNumbersKotlin129()
    val t0 = SumRoottoLeafNumbersKotlin129.TreeNode(0)
    val t4 = SumRoottoLeafNumbersKotlin129.TreeNode(4)
    val t9 = SumRoottoLeafNumbersKotlin129.TreeNode(9)
    val t5 = SumRoottoLeafNumbersKotlin129.TreeNode(5)
    val t1 = SumRoottoLeafNumbersKotlin129.TreeNode(1)
    t4.left = t9
    t4.right = t0
    t9.left = t5
    t9.right = t1
    println(solution.sumNumbers(t4))
}