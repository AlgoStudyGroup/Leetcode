class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if not root:
            return 0
        if not root.left and not root.right:
            return 0
        q = [[root,"mid"]]
        res = 0
        while q != []:
            l = []
            while q:
                l.append(q.pop(0))
            for each in l:
                x = each[0]
                if not x.left and not x.right:
                    if each[1]=="left":
                        res += x.val
                if x.left:
                    q.append([x.left,"left"])
                if x.right:
                    q.append([x.right,"right"])
        return res
