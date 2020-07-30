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
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.Length != postorder.Length) return null;
        var dict = new Dictionary<int, int>();
        for(int i=0; i<inorder.Length; i++){
            dict.Add(inorder[i], i);
        }
        
        return BuildTree(inorder, 0, inorder.Length, postorder, 0, postorder.Length-1, dict);
    }
    
    private TreeNode BuildTree(int[] inorder, int ib, int ie, int[] postorder, int pb, int pe, Dictionary<int, int> dict)
    {
        if(pb>pe || ib>ie) return null;
        var root = new TreeNode(postorder[pe]);
        var rootIdx = dict[postorder[pe]];
        var left = BuildTree(inorder, ib, rootIdx-1, postorder, pb, pb+rootIdx-ib-1, dict);
        var right = BuildTree(inorder, rootIdx+1, ie, postorder, pb+rootIdx-ib, pe-1, dict);
        root.left = left;
        root.right = right;
        return root;
    }
}