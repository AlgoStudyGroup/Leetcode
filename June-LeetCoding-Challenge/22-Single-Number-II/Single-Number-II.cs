// Runtime: 96 ms, faster than 82.24% of C# online submissions for Single Number II.
// Memory Usage: 25.3 MB, less than 40.54% of C# online submissions for Single Number II.
public class Solution {
    public int SingleNumber(int[] nums) {
        var dict = new Dictionary<int, int>();
        for(var i=0; i<nums.Length; i++){
            if(!dict.ContainsKey(nums[i])){
                dict[nums[i]] = 1;
            }else {
                dict[nums[i]] += 1;
            }
        }
        
        foreach(KeyValuePair<int,int> kv in dict){
            if(kv.Value == 1){
                return kv.Key;
            }
        }
        
        return -1;
    }
}