class Solution1 {
public:
    int sumNumbers(TreeNode* root) {
        stack<TreeNode*> s;
        int sum=0, acc = 0;
        TreeNode* prev;
        while(root || !s.empty()){
            while(root){
                s.push(root);
                acc = 10*acc + root->val;
                root = root->left;
                
            }
            auto t = s.top();
            if(!t->left && !t->right)
                sum+=acc;
            
            if(t->right && t->right != prev)
                root = t->right;
            else{
                prev = t;
                acc = acc/10;
                s.pop();
            }
        }
        return sum;
    }
};


class Solution2 {
public:
    long long ans;
    void dfs(TreeNode* root, long long x){
        if (root == NULL) return;
        if (root->left == NULL and root->right == NULL){
            ans += x * 10 + root->val;
            return ;
        }
        if (root->left) dfs(root->left, x * 10 + root->val);
        if (root->right) dfs(root->right, x * 10 + root->val);
    }
    
    int sumNumbers(TreeNode* root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }
};