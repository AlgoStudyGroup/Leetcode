using System;

namespace _1026_Maximum_Difference_Between_Node_and_Ancestor
{
    public class Solution
    {
        public int MaxAncestorDiff(TreeNode root)
        {
            return Dfs(root, root.val, root.val);
        }

        public int Dfs(TreeNode node, int min, int max)
        {
            if (node == null) return max - min;

            min = Math.Min(min, node.val);
            max = Math.Max(max, node.val);

            return Math.Max(Dfs(node.left, min, max), Dfs(node.right, min, max));
        }
    }

    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
