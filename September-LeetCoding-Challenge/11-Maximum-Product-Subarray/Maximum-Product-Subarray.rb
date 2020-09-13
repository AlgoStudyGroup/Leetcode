def max_product(nums)
    
    min = []
    min[0] = nums[0]
    max = []
    max[0] = nums[0]
    
    nums.each_with_index do |val, n|

        next if n == 0
        min[n] = [val, val * min[n-1], val * max[n-1]].min
        max[n] = [val, val * min[n-1], val * max[n-1]].max
        
    end
    max.max
end