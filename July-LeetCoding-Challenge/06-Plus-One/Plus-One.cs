public class Solution
{
    //Shorter solution
    public int[] PlusOne(int[] digits)
    {
        for (int i = digits.Length - 1; i >= 0; i--)
        {
            if (digits[i] < 9)
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        var n = new int[digits.Length + 1];
        n[0] = 1;
        return n;
    }

    //Stack solution
    public int[] PlusOne(int[] digits)
    {
        var stack = new Stack<int>();
        var carry = 0;
        if (digits[digits.Length - 1] == 9)
        {
            carry = 1;
        }
        else
        {
            digits[digits.Length - 1]++;
        }

        for (int i = digits.Length - 1; i >= 0; i--)
        {
            var v = digits[i];
            if (carry == 1)
            {
                v += 1;
            }
            if (v == 10)
            {
                digits[i] = 0;
                carry = 1;
            }
            else
            {
                digits[i] = v;
                carry = 0;
            }
            stack.Push(digits[i]);
        }
        if (carry == 1)
        {
            stack.Push(1);
        }
        return stack.ToArray();
    }
}