// I use dictionary in this solution but this is not the best solution

public class Solution {
    public int MajorityElement(int[] nums) {
        Dictionary<int, int> dicElement = new Dictionary<int, int>();
        int i = 0;
        int n = 0;
        while (i<nums.Length)
         {
           if (dicElement.ContainsKey(nums[i])) 
           {
               dicElement[nums[i]]++;
              if (dicElement[nums[i]]  >= (nums.Length+1)/2)
              {
                return nums[i];
              }
           }
           else
           {
           	dicElement.Add(nums[i],1);
           }
      
           i++;
           
        }
        return  nums[i-1];
    }
}
