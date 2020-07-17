public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {
        //Count occurrence for each value
        var dict = new Dictionary<int, int>();
        for(int i=0; i<nums.Length; i++){
            if(!dict.ContainsKey(nums[i])){
                dict.Add(nums[i], 1);
            }else {
                dict[nums[i]]++;
            }
        }
        
        //Create array list indexed by occurrence
        var numbersByCount = new List<int>[nums.Length+1];
        foreach(var kv in dict){
            var occurrence = kv.Value;
            if(numbersByCount[occurrence] == null){
               numbersByCount[occurrence] = new List<int>(); 
            }
            numbersByCount[occurrence].Add(kv.Key);
        }
        
        //Decrease numbersByCount.Length as the number of occurence, and check the a sublist's existence
        var res = new List<int>();
        for(int i=numbersByCount.Length-1; i>0 && k>0; i--){
            if(numbersByCount[i] != null){
                res.AddRange(numbersByCount[i]);
                k = k - numbersByCount[i].Count;
            }
        }
        
        return res.ToArray();
    }
}