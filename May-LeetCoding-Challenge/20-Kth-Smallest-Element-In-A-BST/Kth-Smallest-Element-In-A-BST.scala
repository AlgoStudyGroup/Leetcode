class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

//recursive and iteration solution
// append list * iterate BST => O(n * n! * log(n) + k)
// calculate left (min) first
object Solution {
  def kthSmallest(root: TreeNode, k: Int): Int = kthSmallestWithAcc(root, Seq())(k - 1)

  def kthSmallestWithAcc(root: TreeNode, acc: Seq[Int]): Seq[Int] = {
    if (root == null) acc
    else kthSmallestWithAcc(root.right, kthSmallestWithAcc(root.left, acc) ++ Seq(root.value))
  }
}

// prepend list * iterate BST => O(n * log(n) + k)
// calculate right (max) first
object Solution2 {
  def kthSmallest(root: TreeNode, k: Int): Int = kthSmallestWithAcc(root, Seq())(k - 1)

  def kthSmallestWithAcc(root: TreeNode, acc: Seq[Int]): Seq[Int] = {
    if (root == null) acc
    else kthSmallestWithAcc(root.left, Seq(root.value) ++ kthSmallestWithAcc(root.right, acc))
  }
}

//optimized solution O(k * log(n))
object Solution3 {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    var nodeList = scala.collection.mutable.Seq.empty[TreeNode]
    var finalRoot = root

    def kthSmallestWithAcc(root: TreeNode, counter: Int): Unit = {
      if (counter != k) {
        if (root != null) {
          nodeList = nodeList.+:(root)
          kthSmallestWithAcc(root.left, counter)
        } else {
          finalRoot = nodeList.head
          nodeList = nodeList.tail
          kthSmallestWithAcc(finalRoot.right, counter + 1)
        }
      }
    }

    kthSmallestWithAcc(root, 0)
    finalRoot.value
  }
}