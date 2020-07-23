public class Solution
{
    public int[] SingleNumber(int[] nums)
    {
        int xor = 0;
        foreach (int num in nums)
        {
            xor = xor ^ num;
        }

        int lowBitSet = xor & (-xor); // get the lowest bit set
        int a = 0;
        int b = 0;
        foreach (int num in nums)
        {
            if ((lowBitSet & num) == 0)
            {
                // num has ith bit unset that's why & operation is returning zero
                a = a ^ num;
            }
            else
            {
                // num has ith bit set that's why & operation is returning non zero
                b = b ^ num;
            }
        }
        return new int[] { a, b };
    }

    public void Test()
    {
        var nums = new int[] { 1, 2, 3, 4, 1, 3 };
        var r = SingleNumber(nums);
        Console.WriteLine(string.Join(",", r));
    }

}