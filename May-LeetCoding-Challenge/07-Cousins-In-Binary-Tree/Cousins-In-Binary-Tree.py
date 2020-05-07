# Definition for a binary tree node.
class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def verify(self, a: TreeNode, b: TreeNode) -> bool:
        if a is None or b is None:
            return False

        x_father = True if (a.left is not None and a.left.val == self.x)\
            or (a.right is not None and a.right.val == self.x)\
            else False
        y_father = True if (b.left is not None and b.left.val == self.y)\
            or (b.right is not None and b.right.val == self.y)\
            else False
        if x_father:
            return a is not b if y_father else False
        if y_father:
            return a is not b if x_father else False

        return self.verify(a.left, b.left) or self.verify(a.left, b.right) \
            or self.verify(a.right, b.left) or self.verify(a.right, b.right)

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.x, self.y = x, y
        return self.verify(root, root)
