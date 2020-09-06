public class Solution {
    public IList<int> GetAllElements(TreeNode root1, TreeNode root2) {
        var l1 = new List<int>();
        Traversal(root1, l1);
        var l2 = new List<int>();
        Traversal(root2, l2);
        
        var res = Merge(l1, l2);
        return res;
    }
    
    private void Traversal(TreeNode node, List<int> l){
        if(node == null) return;
        Traversal(node.left, l);
        l.Add(node.val);
        Traversal(node.right, l);
    }
    
    private List<int> Merge(List<int> l1, List<int> l2){
        var res = new List<int>();
        int i=0, j=0;
        while(i<l1.Count && j<l2.Count){
            if(l1[i] < l2[j]){
                res.Add(l1[i]);
                i++;
            }else{
                res.Add(l2[j]);
                j++;
            }
        }
        while(i<l1.Count) {
            res.Add(l1[i]);
            i++;
        }
        while(j<l2.Count) {
            res.Add(l2[j]);
            j++;   
        }
        return res;
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