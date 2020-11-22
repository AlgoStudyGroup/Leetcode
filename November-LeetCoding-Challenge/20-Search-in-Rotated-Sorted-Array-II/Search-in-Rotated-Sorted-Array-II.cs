namespace _81_Search_in_Rotated_Sorted_Array_II
{
    public class Solution
    {
        public bool Search(int[] nums, int target)
        {
            int
                begin = 0,
                end = nums.Length - 1;

            while (begin <= end)
            {
                int mid = begin + (end - begin) / 2;
                if (nums[mid] == target) return true;

                //left part is sorted
                if (nums[begin] < nums[mid])
                {
                    if (target < nums[begin] || target > nums[mid])
                    {
                        //target is in rotated part
                        begin = mid + 1;
                    }
                    else
                    {
                        end = mid - 1;
                    }
                }
                else //right part is sorted
                if (nums[begin] > nums[mid])
                {
                    if (target < nums[mid] || target > nums[end])
                    {
                        //target is in rotated part
                        end = mid - 1;
                    }
                    else
                    {
                        begin = mid + 1;
                    }
                }
                else
                //duplicates
                {
                    begin++;
                }
            }
            return false;
        }
    }
}
