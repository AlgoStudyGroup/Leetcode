class Solution {
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
