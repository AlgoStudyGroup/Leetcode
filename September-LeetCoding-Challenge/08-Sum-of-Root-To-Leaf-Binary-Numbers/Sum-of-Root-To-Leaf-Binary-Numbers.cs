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
public class Solution {
    public int SumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        
        return Traverse(root, 0);
    }
    
    private int Traverse(TreeNode node, int v){
        if(node == null) {
            return 0;
        }
        
        v = v * 2 + node.val;
        
        return node.left == node.right ? v : Traverse(node.left, v) + Traverse(node.right, v);
    }
}