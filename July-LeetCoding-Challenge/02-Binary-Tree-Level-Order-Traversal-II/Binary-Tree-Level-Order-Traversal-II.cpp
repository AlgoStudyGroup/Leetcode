class Solution {
public:
    vector<vector<int>> ans;
    void dfs(int dep, TreeNode* root){
        if (root == NULL) return;
        while (dep >= ans.size()) ans.push_back(vector<int>());
        ans[dep].push_back(root->val);
        dfs(dep + 1, root->left);
        dfs(dep + 1, root->right);
    }
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        dfs(0, root);
        reverse(ans.begin(), ans.end());
        return ans;
    }
};