class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        from collections import defaultdict 
        d = defaultdict(list)
        def dfs(root, dep):
            if root:
                d[dep].append(root.val)
                dfs(root.left, dep + 1)
                dfs(root.right, dep + 1)
        dfs(root , 0)
        return [sum(x)/len(x) for x in d.values()]