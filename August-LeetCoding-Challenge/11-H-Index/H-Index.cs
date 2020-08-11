public class Solution {
    public int HIndex(int[] citations) {
        //Counting sort
        int[] counts = new int[citations.Length + 2];
        for (int i = citations.Length - 1; i >= 0; i--)
        {
            var idx = Math.Min(citations[i], citations.Length);
            counts[idx]++;
        }

        var r = 0;
        for (int i = citations.Length +1; i >= 0; i--)
        {
            r += counts[i];
            if (r >= i)
                return i;
        }
        return 0;
    }
}