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
class Solution1 {
    ArrayList<Integer> array = new ArrayList<>();
    
    private void bstToArrayList(TreeNode treeNode){
        if(treeNode.left != null)
            bstToArrayList(treeNode.left);
        array.add(treeNode.val);
        if(treeNode.right != null)
            bstToArrayList(treeNode.right);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        bstToArrayList(root);
        
        return array.get(k-1);
    }
}