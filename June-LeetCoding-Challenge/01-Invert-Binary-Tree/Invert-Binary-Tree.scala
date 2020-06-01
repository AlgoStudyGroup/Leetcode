class Question01 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  //space complexity O(1)
  object Solution {
    def invertTree(root: TreeNode): TreeNode = {
      def recursiveInvert(root: TreeNode): Unit = {
        if (root != null) {
          val tmp = root.left
          root.left = root.right
          root.right = tmp
          recursiveInvert(root.left)
          recursiveInvert(root.right)
        }
      }
      recursiveInvert(root)
      root
    }
  }

  //space complexity 0(n)
  object Solution2 {
    def invertTree(root: TreeNode): TreeNode = recursiveInvert(root)

    def recursiveInvert(root: TreeNode): TreeNode = {
      if (root == null) null
      else {
        val tmp = root.left
        root.left = recursiveInvert(root.right)
        root.right = recursiveInvert(tmp)
        root
      }
    }
  }
}
