class Solution {
public:
    void dfs(TreeNode* r1, TreeNode** r2){
        if (r1 == NULL) return;
        *r2 = new TreeNode(r1->val);
        dfs(r1->left, &((*r2)->right));
        dfs(r1->right, &((*r2)->left));
    }
    
    TreeNode* invertTree(TreeNode* root) {
        TreeNode* root2 = NULL;
        dfs(root, &root2);
        return root2;
    }
};