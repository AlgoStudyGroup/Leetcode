public class Solution {
    public bool ContainsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        var d = new Dictionary<long,long>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.Length; ++i) {
            long m = getID(nums[i], w);
            if (d.ContainsKey(m))
                return true;
            if (d.ContainsKey(m - 1) && Math.Abs(nums[i] - d[m - 1]) < w)
                return true;
            if (d.ContainsKey(m + 1) && Math.Abs(nums[i] - d[m + 1]) < w)
                return true;
            d.Add(m, (long)nums[i]);
            if (i >= k) d.Remove(getID(nums[i - k], w));
        }
        return false;
    }
    
    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }
}