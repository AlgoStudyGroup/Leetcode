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

class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if(!root) return nullptr; 
        auto left = (root->left)?invertTree(root->left):nullptr;
        auto right = (root->right)?invertTree(root->right):nullptr;
        root->left = right;
        root->right = left;
        return root;
    }
    
};
