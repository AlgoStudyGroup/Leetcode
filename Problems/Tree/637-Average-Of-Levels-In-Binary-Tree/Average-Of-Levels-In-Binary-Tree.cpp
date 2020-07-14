/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<pair<double, int>> v;
    void dfs(TreeNode* root, int dep){
        if (root == NULL) return;
        while (dep >= v.size()) v.push_back(make_pair(0, 0));
        v[dep].first += root->val;
        v[dep].second ++;
        dfs(root->left, dep + 1);
        dfs(root->right, dep + 1);
    }
    
    vector<double> averageOfLevels(TreeNode* root) {
        dfs(root, 0);
        vector<double> ans(v.size(), 0);
        for (int i = 0; i < ans.size(); i++)
            ans[i] = v[i].first / v[i].second;
        return ans;
    }
};