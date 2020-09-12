def contains_nearby_almost_duplicate(nums, k, t)
    length = nums.length
    out = false
    0.upto(length-1) do |i|
        (i+1).upto([length-1,i+k].min) do |n|

            return true if (nums[n] - nums[i]).abs <= t 

        end
    end
    out
end