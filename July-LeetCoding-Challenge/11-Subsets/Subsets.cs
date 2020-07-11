public class Solution
{
    public IList<IList<int>> Subsets(int[] nums)
    {
        Array.Sort(nums);
        var res = new List<IList<int>>();
        backtrack(res, new List<int>(), nums, 0);
        return res;
    }

    private void backtrack(List<IList<int>> list, List<int> temp, int[] nums, int start)
    {
        list.Add(temp.ToList());
        for (int i = start; i < nums.Length; i++)
        {
            temp.Add(nums[i]);
            backtrack(list, temp, nums, i + 1);
            temp.RemoveAt(temp.Count - 1);
        }
    }
}
