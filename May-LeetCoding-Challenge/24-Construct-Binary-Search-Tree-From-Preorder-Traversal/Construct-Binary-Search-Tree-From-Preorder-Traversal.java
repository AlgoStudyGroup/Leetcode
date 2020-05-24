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
    /**
     * Recursive solution, construct the left tree and right tree recursively, and the combine to the root.
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        
        int rootVal = preorder[0];
        if(preorder.length == 1) return new TreeNode(rootVal);
        
        TreeNode rightTree = null;
        TreeNode leftTree = null;
        TreeNode root = new TreeNode(rootVal, null, null);
        
        if(preorder[1] > rootVal) {
            // if there is no left tree
            rightTree = bstFromPreorder(Arrays.copyOfRange(preorder, 1, preorder.length));
        } else {
            int i = 1;
            while (i < preorder.length) {
                // find separate index of left tree and right tree
                if (preorder[i] > rootVal) {
                    break;
                }
                i++;
            }
            
            // construct left tree
            leftTree = bstFromPreorder(Arrays.copyOfRange(preorder, 1, i));
            if(i != preorder.length) {
                //construct right tree
                rightTree = bstFromPreorder(Arrays.copyOfRange(preorder, i, preorder.length));
            }
        }        
        
        root.left = leftTree;
        root.right = rightTree;
        
        return root;
    }
}