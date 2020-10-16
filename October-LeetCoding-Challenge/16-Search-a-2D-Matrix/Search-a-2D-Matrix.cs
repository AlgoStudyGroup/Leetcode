public class Solution {
    public bool SearchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.Length == 0) return false;
        var levelLen = matrix[0].Length;
        if(levelLen == 0) return false;    

        bool result = false;
        for (int i = 0; i <= matrix.Length-1; i++)
        {
            if (target <= matrix[i][levelLen - 1])
            {
                return BinarySearch(target, matrix[i]);
            }
        }

        return false;
    }

    private bool BinarySearch(int target, int[] nums)
    {
        int lo = 0, hi = nums.Length - 1;
        int mid = 0;
        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] > target)
            {
                hi = mid-1;
            }
            else if (nums[mid] < target)
            {
                lo = mid+1;
            }
            else if (nums[mid] == target)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
}