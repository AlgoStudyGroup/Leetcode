public class Solution {
    public IList<int> FindDuplicates(int[] nums) {
        var res = new List<int>();
        for(int i = 0; i<nums.Length; i++){
            var idx = Math.Abs(nums[i]) -1;
            if(nums[idx] < 0){
                res.Add(idx+1);
            }
            nums[idx] = -nums[idx];
        }
        return res;
    }
}
