class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

//DFS solution
object Solution {
  def bstFromPreorder(preorder: Array[Int]): TreeNode = {
    var parentList = scala.collection.mutable.Seq.empty[TreeNode]
    val root = new TreeNode(preorder(0))

    def bstFromPreorderWithIndex(index: Int, parent: TreeNode): Unit = {
      if (index != preorder.length) {
        if (parent.value > preorder(index)) {
          parent.left = new TreeNode(preorder(index))
          parentList = parentList.+:(parent)
          bstFromPreorderWithIndex(index + 1, parent.left)
        } else {
          if (parentList.isEmpty || preorder(index) < parentList.head.value) {
            parent.right = new TreeNode(preorder(index))
            bstFromPreorderWithIndex(index + 1, parent.right)
          } else {
            val newParent = parentList.head
            parentList = parentList.tail
            bstFromPreorderWithIndex(index, newParent)
          }
        }
      }
    }

    bstFromPreorderWithIndex(1, root)
    root
  }
}

//recursive (not tailRec) solution
object Solution2 {
  def bstFromPreorder(preorder: Array[Int]): TreeNode =
    bstFromPreorderWithRange(0, preorder.length - 1, preorder)

  def bstFromPreorderWithRange(start: Int, end: Int, preorder: Array[Int]): TreeNode = {
    if (start > end) null
    else {
      val node = new TreeNode(preorder(start))
      val leftIndexBound = (start to end).find(i => preorder(i) > preorder(start)).getOrElse(end + 1) - 1
      node.left = bstFromPreorderWithRange(start + 1, leftIndexBound, preorder)
      node.right = bstFromPreorderWithRange(leftIndexBound + 1, end, preorder)
      node
    }
  }
}