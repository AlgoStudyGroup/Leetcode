public class Solution {
    public int Rob(int[] nums) {
        if(nums == null || nums.Length == 0) return 0;
        if(nums.Length == 1) return nums[0];

        return Math.Max(rob(nums, 1, nums.Length-1), rob(nums, 0, nums.Length-2));
    }
    
    private int rob(int[] nums, int lo, int hi){
        int include = 0, exclude = 0;
        for(int x=lo; x<=hi; x++){
            int i=include, e=exclude;
            include = e + nums[x];
            exclude = Math.Max(i, e);
        }
        return Math.Max(include, exclude);
    }
}
