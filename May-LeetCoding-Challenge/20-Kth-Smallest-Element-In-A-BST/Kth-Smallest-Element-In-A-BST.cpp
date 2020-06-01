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
    vector<int> v;
    
    void in_order(TreeNode* root){
        if (root->left) in_order(root->left);
        v.push_back(root->val);
        if (root->right) in_order(root->right);
    }
    
    int kthSmallest(TreeNode* root, int k) {
        v.resize(0);
        in_order(root);
        return v[k-1];
    }
};