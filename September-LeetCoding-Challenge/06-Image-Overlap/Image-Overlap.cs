public class Solution {
    public int LargestOverlap(int[][] A, int[][] B) {
        if(A == null || A.Length ==0 || B==null || B.Length==0) return 0;
        
        int rows = A.Length, cols = A[0].Length;
        List<int[]> al = new List<int[]>(), bl = new List<int[]>();

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if(A[i][j] == 1) al.Add(new int[]{i, j});
                if(B[i][j] == 1) bl.Add(new int[]{i, j });
            }
        }

        var dict = new Dictionary<string, int>();
        foreach (int[] a in al)
        {
            foreach (int[] b in bl)
            {
                var s = (a[0] - b[0]) + " " + (a[1] - b[1]);
                if (dict.ContainsKey(s))
                {
                    dict[s]++;
                }
                else
                {
                    dict.Add(s, 1);
                }
            }
        }
        
        int c = 0;
        foreach(var v in dict.Values){
            c = Math.Max(c, v);
        }
        return c;
    }
}