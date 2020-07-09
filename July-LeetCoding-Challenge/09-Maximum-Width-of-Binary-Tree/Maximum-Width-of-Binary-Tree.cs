public class Solution {
    private int maxWidth = 0;
    public int WidthOfBinaryTree(TreeNode root) {
        var list = new List<int>();    
        Dfs(root, 1, 0, list);
		return maxWidth;
    }
    
    private void Dfs(TreeNode node, int index, int depth, List<int> countByLevel) {
		if (depth >= countByLevel.Count) countByLevel.Add(index);
		maxWidth = Math.Max(maxWidth, index - countByLevel[depth] + 1);

		if (node.left != null)
			Dfs(node.left, index * 2, depth + 1, countByLevel);
		if (node.right != null)
			Dfs(node.right, index * 2 + 1, depth + 1, countByLevel);
	}
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */