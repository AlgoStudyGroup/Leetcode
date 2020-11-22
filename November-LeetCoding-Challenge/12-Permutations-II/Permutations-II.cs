using System.Collections.Generic;
using System.Linq;

namespace _47_Permutations_II
{
    public class Solution
    {
        public IList<IList<int>> PermuteUnique(int[] nums) {
        var res = new List<IList<int>>();
        if(nums == null || nums.Length == 0) return res;
        
        Recursion(nums, 0, res);
        return res;
    }
    
    private void Recursion(int[] nums, int idx, List<IList<int>> li){
        if(idx == nums.Length){
            li.Add(nums.ToList());
            return;
        }
        
        var hs = new HashSet<int>();
        for(int i=idx; i<nums.Length; i++){
            if(hs.Add(nums[i])){
                Swap(nums, i, idx);
                Recursion(nums, idx+1, li);
                Swap(nums, i, idx);
            }
        }
    }
    
    private void Swap(int[] nums, int x, int y){
        var tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
    }
}