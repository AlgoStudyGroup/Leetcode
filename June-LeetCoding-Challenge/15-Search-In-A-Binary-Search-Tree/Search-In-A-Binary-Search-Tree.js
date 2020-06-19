let searchBST = function(root, val) {
    if(root==null){
        return null;
    }
    if(root.val===val){return new TreeNode(root.val,root.left,root.right);}
    if(root.val>val){return searchBST(root.left,val);}
    else{return searchBST(root.right,val);}
};
