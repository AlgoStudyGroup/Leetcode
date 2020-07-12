public class Solution {
    //XOR solution
    public int SingleNumber(int[] nums) {
        var result = 0;
        for(int i=0; i<nums.Length; i++){
            result ^= nums[i];
        }
        return result;
    }
    
    //Dictionary solution
    public int SingleNumber(int[] nums) {
        var dict = new Dictionary<int, int>();
        for(int i=0; i<nums.Length; i++){
            if(!dict.ContainsKey(nums[i])){
                dict.Add(nums[i], 1);
            }else{
                dict[nums[i]]++;
            }
        }
        return dict.First(x => x.Value == 1).Key;   
    }
}