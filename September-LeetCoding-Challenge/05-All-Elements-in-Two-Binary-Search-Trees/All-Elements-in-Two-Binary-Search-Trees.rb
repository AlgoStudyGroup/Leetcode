def get_all_elements(root1, root2)
    
    arr_1 = in_order(root1, [])
    arr_2 = in_order(root2, [])
    res = []
    
    len1 = arr_1.length
    len2 =  arr_2.length
    index_1 = 0
    index_2 = 0
    
    while (index_1 <= (len1 -1)) ||  
          (index_2 <= (len2 -1))
        
        if arr_1[index_1].nil? && !arr_2[index_2].nil?
            res << arr_2[index_2]
            index_2 += 1
        elsif !arr_1[index_1].nil? && arr_2[index_2].nil?
            res << arr_1[index_1]
            index_1 += 1
                        
        elsif arr_1[index_1] < arr_2[index_2]
            res <<  arr_1[index_1]
            index_1 += 1
            
        else
             res <<  arr_2[index_2]
            index_2 += 1
        end
            
    end
        
    
    res
        
end

def in_order(root, arr)
   if root.nil?
       return arr
   else
       in_order(root.left, arr)
       arr << root.val
       in_order(root.right, arr)
   end
end