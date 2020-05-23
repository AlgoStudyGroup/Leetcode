class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

//recursive and iteration solution
object Solution {
  def kthSmallest(root: TreeNode, k: Int): Int = kthSmallestWithAcc(root, Seq())(k - 1)

  def kthSmallestWithAcc(root: TreeNode, acc: Seq[Int]): Seq[Int] = {
    if (root == null) acc
    else kthSmallestWithAcc(root.right, kthSmallestWithAcc(root.left, acc) ++ Seq(root.value))
  }
}