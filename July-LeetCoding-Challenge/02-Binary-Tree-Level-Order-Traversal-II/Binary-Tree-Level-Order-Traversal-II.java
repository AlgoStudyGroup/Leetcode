/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// BFS
class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        var levels = new LinkedList<List<Integer>>();
        var todo = new LinkedList<TreeNode>();
        todo.add(root);

        while (!todo.isEmpty()) {
            int remaining = todo.size();
            var values = new ArrayList<Integer>(remaining);
            for (int i = 0; i < remaining; i++) {
                var node = todo.poll();
                values.add(node.val);
                if (node.left != null) {
                    todo.add(node.left);
                }
                if (node.right != null) {
                    todo.add(node.right);
                }
            }
            levels.addFirst(values);
        }
        return levels;
    }
}

// DFS
class Solution2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        var results = new ArrayList<List<Integer>>();
        dfs(root, 0, results);
        Collections.reverse(results);
        return results;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> results) {
        if (root == null) {
            return;
        }
        while (level >= results.size()) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        dfs(root.left, level + 1, results);
        dfs(root.right, level + 1, results);
    }
}
