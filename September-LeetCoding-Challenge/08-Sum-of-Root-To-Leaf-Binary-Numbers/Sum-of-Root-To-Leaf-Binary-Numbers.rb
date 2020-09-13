def sum_root_to_leaf(root)
    rec(root, 0)
end
    
def rec(root, val)
    if root.nil?
        return 0
    else
        val = val * 2 + root.val
        if root.left.nil? && root.right.nil?
           return val
        end
        rec(root.left, val) + rec(root.right, val)
        
    end
end