# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {TreeNode} root
# @param {Integer} key
# @return {TreeNode}
def delete_node(root, key)
    if root == nil 
        return root
    elsif root.val > key
        root.left = delete_node(root.left, key)
        
    elsif root.val < key
        root.right = delete_node(root.right, key)
        
    else
        if root.left == nil && root.right == nil
            root = nil
            return nil
        elsif root.left == nil
            tmp = root.right
            root = nil
            return tmp
        elsif root.right == nil
            tmp = root.left 
            root = nil
            return tmp
        else
            tmp = min_value(root.right)
            root.val = tmp.val
            root.right = delete_node(root.right, tmp.val)
        end
    end
    return root
end

def min_value(node)
    current = node
    while current.left != nil
        current = current.left 
    end
    current
end