using System.Collections;
using System.Collections.Generic;

namespace _456_132_Pattern
{
    public class Solution
    {
        public bool Find132pattern(int[] nums)
        {
            int n3 = int.MinValue;
            var stack = new Stack<int>();
            //Loop from the end of array
            for (int i = nums.Length - 1; i >= 0; i--)
            {
                if (nums[i] < n3) return true;
                else
                {
                    //Pop all elements smaller than nums[i] from stack
                    while (stack.Count > 0 && nums[i] > stack.Peek())
                    {
                        n3 = stack.Pop();
                    }
                }
                //Push current element 
                stack.Push(nums[i]);
            }
            return false;
        }
    }
}
