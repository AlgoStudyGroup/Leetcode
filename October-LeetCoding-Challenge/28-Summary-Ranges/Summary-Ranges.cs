using System.Collections.Generic;

namespace _228_Summary_Ranges
{
    public class Solution
    {
        public IList<string> SummaryRanges(int[] nums)
        {
            if (nums == null) return null;
            if (nums.Length == 0) return new List<string>();
            if (nums.Length == 1) return new List<string> { nums[0].ToString() };

            var res = new List<string>();
            for (int i = 0; i < nums.Length; i++)
            {
                int v = nums[i];
                while (i < nums.Length - 1 && nums[i] + 1 == nums[i + 1])
                {
                    i++;
                }
                if (v != nums[i])
                {
                    res.Add(v + "->" + nums[i]);
                }
                else
                {
                    res.Add(v.ToString());
                }
            }

            return res;
        }
    }
}
