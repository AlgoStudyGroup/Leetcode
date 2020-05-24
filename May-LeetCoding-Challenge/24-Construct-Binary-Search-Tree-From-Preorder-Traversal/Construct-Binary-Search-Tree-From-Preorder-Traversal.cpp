class Solution {
public:
    TreeNode* construct(int i, int j, vector<int>& preorder){
        if (i > j) return NULL;
        TreeNode* root = new TreeNode(preorder[i]);
        int k = i;
        while (k <= j and preorder[k] <= preorder[i]) k++;
        root->left = construct(i+1, k-1, preorder);
        root->right = construct(k, j, preorder);
        return root;
    }
    
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        return construct(0, preorder.size() - 1, preorder);
    }
};