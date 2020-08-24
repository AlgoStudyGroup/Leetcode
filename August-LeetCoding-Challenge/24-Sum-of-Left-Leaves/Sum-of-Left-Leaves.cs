public class Solution {
    public int SumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        
        Dfs(root.left, 0);
        Dfs(root.right, 1);
        return sum;
    }
    private int sum =0;
    private void Dfs(TreeNode node, int direction){
        if(node == null) return;
        
        if(node.left == null && node.right == null && direction == 0){
            sum += node.val;
        }
        
        Dfs(node.left, 0);
        Dfs(node.right, 1);        
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