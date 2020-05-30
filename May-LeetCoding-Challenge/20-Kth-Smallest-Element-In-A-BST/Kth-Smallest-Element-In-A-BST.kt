package binary_search


class KthSmallestElementinaBSTKotlin230 {
    class TreeNode230(var `val`: Int) {
        var left: TreeNode230? = null
        var right: TreeNode230? = null
    }

    fun kthSmallest(root: TreeNode230?, k: Int): Int {
        val leftCount = count(root?.left) + 1
        return when {
            leftCount == k -> return root!!.`val`
            leftCount < k -> kthSmallest(root?.right, k - leftCount)
            else -> kthSmallest(root?.left, k)
        }
    }

    private fun count(root: TreeNode230?): Int {
        if (root == null) {
            return 0
        }
        return 1 + count(root.left) + count(root.right)
    }


    /*
    fun kthSmallest(root: TreeNode230?, k: Int): Int {
        val result = mutableListOf<Int>()
        searchInOrder(root, result)
        return result[k - 1]
    }

    private fun searchInOrder(current: TreeNode230?, result: MutableList<Int>) {
        if(current == null){
            return
        }
        searchInOrder(current.left,result)
        result.add(current.`val`)
        searchInOrder(current.right,result)
    }
     */


    /*
    var k = 0
    fun kthSmallest(root: TreeNode230?, k: Int): Int {
        this.k = k
        return searchInOrder(root)!!.`val`
    }

    private fun searchInOrder(current: TreeNode230?): TreeNode230? {
        if (current == null) {
            return null
        }
        val resultLeft = searchInOrder(current.left)
        if (resultLeft != null && k == 0) {
            return resultLeft
        }
        this.k--
        if (k == 0) {
            return current
        }
        return searchInOrder(current.right)
    }

     */
}