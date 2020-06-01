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

class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        return walk(root, k)[0];
    }

    /**
     * Finds the Kth smallest element by walking through
     * the tree in in-order: left, node, right (LNR).
     *
     * @return a pair containing the candidate for the Kth smallest
     *         value and the remaining number of nodes to visit
     */
    private int[] walk(TreeNode root, int k) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, k };
        }
        int[] arr = walk(root.left, k);
        int candidate = arr[0];
        int remaining = arr[1];
        if (remaining == 0) {
            return new int[] { candidate, 0 };
        }
        if (remaining == 1) {
            return new int[] { root.val, 0 };
        }
        return walk(root.right, remaining - 1);
    }
}
