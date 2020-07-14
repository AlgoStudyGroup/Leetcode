# Runtime: 48 ms, faster than 21.52% of Python3 online submissions for Symmetric Tree.

# Memory Usage: 14 MB, less than 56.03% of Python3 online submissions for Symmetric Tree.
class Solution:
    def check(self, r1, r2):
        if (r1 and r2 == None): return False
        if (r1 == None and r2): return False
        if (r1 == None and r2 == None): return True
        if (r1.val != r2.val): return False
        return self.check(r1.left, r2.right) and self.check(r1.right, r2.left)
    
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.check(root, root)

