public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        Array.Sort(nums);
        var result = new List<IList<int>>();
        for(int i=0; i<nums.Length; i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            
            int j=i+1, k=nums.Length-1;
            int target = -nums[i];
            while(j < k){
                if(nums[j] + nums[k] == target){
                    result.Add(new int[3]{nums[i], nums[j], nums[k]}.ToList());
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }else if(nums[j] + nums[k] > target){
                    k--;
                }else if(nums[j] + nums[k] < target){
                    j++;
                }
            }
        }
        return result;        
    }
}