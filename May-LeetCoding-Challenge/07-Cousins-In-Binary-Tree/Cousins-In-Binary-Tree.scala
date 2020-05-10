class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
     var value: Int = _value
     var left: TreeNode = _left
     var right: TreeNode = _right
}

object Solution {
  def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
    var parentX: Option[TreeNode] = None
    var parentY: Option[TreeNode] = None
    var nodes = Seq(root)
    while (parentX.isEmpty && parentY.isEmpty){
      parentX = nodes.find(n => isParent(n, x))
      parentY = nodes.find(n => isParent(n, y))
      if(parentX.isEmpty && parentY.isEmpty )
        nodes = nodes.flatMap(node => Seq(node.left, node.right).filter(t => t != null))
    }
    (parentX , parentY) match {
      case (Some(p1), Some(p2)) if p1 != p2 => true
      case _ => false
    }
  }

  def isParent(node: TreeNode, value: Int): Boolean = {
    (node.left != null && node.left.value == value) || (node.right != null && node.right.value == value)
  }
}

