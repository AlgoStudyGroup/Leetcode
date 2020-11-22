using System;

namespace _563_Binary_Tree_Tilt
{
    public class Solution
    {
        private int diff = 0;
    
        public int FindTilt(TreeNode root) {
            PostOrder(root);
            return diff;
        }
        
        private int PostOrder(TreeNode node){
            if(node == null) return 0;
            
            var l = PostOrder(node.left);
            var r = PostOrder(node.right);
            
            diff += Math.Abs(l - r);
            
            return l + r + node.val;
        }
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}