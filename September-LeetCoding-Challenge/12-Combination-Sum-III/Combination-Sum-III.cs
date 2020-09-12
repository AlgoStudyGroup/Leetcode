public class Solution {
        public IList<IList<int>> CombinationSum3(int k, int n)
        {
            var res = new List<IList<int>>();
            var tmp = new List<int>();
            Backtrack(res, tmp, k, n, 1);
            return res;
        }

        public void Backtrack(List<IList<int>> res, List<int> tmp, int k, int n, int idx)
        {
            if (k == tmp.Count && n == 0)
            {
                res.Add(new List<int>(tmp)); //Deep clone
                return;
            }

            for (int i = idx; i <= n && k > 0 && n > 0; i++)
            {
                if(i>9) break;
                tmp.Add(i);
                Backtrack(res, tmp, k, n - i, i + 1);
                tmp.RemoveAt(tmp.Count - 1); //Remove last item when it doesn't find the correct combo
            }
        }
}
