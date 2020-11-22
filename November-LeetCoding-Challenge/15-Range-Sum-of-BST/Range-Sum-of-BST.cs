namespace _938_Range_Sum_of_BST
{
    public class Solution
    {
        public int RangeSumBST(TreeNode root, int low, int high)
        {
            int res = 0;
            PreOrder(root, low, high, ref res);
            return res;
        }

        private void PreOrder(TreeNode root, int low, int high, ref int res)
        {
            if (root == null) return;
            PreOrder(root.left, low, high, ref res);
            if (root.val >= low && root.val <= high) res += root.val;
            PreOrder(root.right, low, high, ref res);
        }
    }

    public class TreeNode
    {
        public int val;

        public TreeNode left;

        public TreeNode right;

        public TreeNode(
            int val = 0,
            TreeNode left = null,
            TreeNode right = null
        )
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
