public class Solution {
    public IList<IList<int>> ZigzagLevelOrder(TreeNode root) {
        var res = new List<IList<int>>();
        if(root == null) return res;
        var level = 0;
        Dfs(root, level, res);
        return res;
    }
    
    private void Dfs(TreeNode node, int level, List<IList<int>> res){
        if(node == null) return;
        if(res.Count <= level) res.Add(new List<int>());
        
        if(level % 2 == 1) res[level].Insert(0, node.val);
        else res[level].Add(node.val);
        
        Dfs(node.left, level+1, res);
        Dfs(node.right, level+1, res);
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