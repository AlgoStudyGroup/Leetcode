/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
        }
        return root;
    }
}
