// Runtime: 100 ms, faster than 61.31% of C# online submissions for Find the Duplicate Number.
// Memory Usage: 25.2 MB, less than 88.84% of C# online submissions for Find the Duplicate Number.
public class Solution {
    public int FindDuplicate(int[] nums) {
        
        int slow = 0;
        int fast = 0;
        int finder = 0;

        while (true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast)
                break;
        }
        
        while (true)
        {
            slow = nums[slow];
            finder = nums[finder];
            if (slow == finder)
                break;
        }
        
        return finder;
        
    }
}