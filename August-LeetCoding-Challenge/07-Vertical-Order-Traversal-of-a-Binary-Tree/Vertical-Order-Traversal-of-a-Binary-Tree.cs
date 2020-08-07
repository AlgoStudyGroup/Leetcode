public class Solution {
    private int _minX = int.MaxValue;
    private int _maxX = int.MinValue;
    private int _minY = int.MaxValue;
    private int _maxY = int.MinValue;
    
    public IList<IList<int>> VerticalTraversal(TreeNode root) {
        var dict = new Dictionary<string, List<int>>();
        Dfs(root, dict, 0, 0);
        IList<IList<int>> res = new List<IList<int>>();
        for(int i=_minX; i<=_maxX; i++){
            var listY = new List<int>();
            for(int j=_maxY; j>=_minY; j--){
                var pos = i.ToString() + j.ToString();
                if(dict.ContainsKey(pos)){
                    var list = dict[pos];
                    listY.AddRange(list);
                }
            }
            if(listY.Count > 0){
                res.Add(listY);
            }
        }
        return res;
    }
    
    private void Dfs(TreeNode root, Dictionary<string, List<int>> dict, int x, int y){
        if(root == null) return;
        var pos = x.ToString() + y.ToString();
        if(dict.ContainsKey(pos)){
            var list = dict[pos];
            list.Add(root.val);
            list.Sort();
            dict[pos]=list;
        }else {
            dict[pos] = new List<int>{ root.val};
        }
        
        _minX = Math.Min(_minX, x);
        _maxX = Math.Max(_maxX, x);
        _minY = Math.Min(_minY, y);
        _maxY = Math.Max(_maxY, y);
        Dfs(root.left, dict, x-1, y-1);
        Dfs(root.right, dict, x+1, y-1);
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