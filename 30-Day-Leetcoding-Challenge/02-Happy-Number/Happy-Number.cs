public class Solution
{
    public bool IsHappy(int n)
    {
        var hs = new HashSet<int>();
        var left = 0;
        //HashSet is the key
        while (hs.Add(n))
        {
            var sum = 0;
            while (n > 0)
            {
                left = n % 10;
                sum += left * left;
                n /= 10;
            }

            if (sum == 1)
            {
                return true;
            }
            else
            {
                n = sum;
            }
        }
        return false;
    }
}