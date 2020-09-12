public class Solution {
    public int MaxProduct(int[] nums)
    {
        int s = nums[0];
        int r = nums[0];
        
        for(int i=1, max = s, min = s; i<nums.Length; i++){
            int temp = max;
            max = Math.Max(Math.Max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.Min(Math.Min(nums[i] * temp, nums[i] * min), nums[i]);
            
            r = Math.Max(max, r);
        }
        
        return r;
    }
}