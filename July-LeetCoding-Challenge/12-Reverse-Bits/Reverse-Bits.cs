public class Solution
{

    //Bitwise solution
    public uint reverseBits(uint n) {
        if(n == 0) return 0;
        uint result = 0;
        for(int i=0; i<32; i++){
            result <<= 1;
            if((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }


    //Stack solution
    public uint reverseBits(uint n)
    {
        //Push to stack
        var stack = new Stack<uint>();
        while (n > 0)
        {
            stack.Push(n % 2);
            n = n / 2;
        }

        //Fill empty slots
        var length = stack.Count;
        if (length < 32)
        {
            var tl = 32 - length;
            for (int i = 0; i < tl; i++)
            {
                stack.Push(0);
            }
        }

        //Construct number
        uint b = 1;
        uint result = 0;
        if (stack.Pop() == 0) result = 0;
        else result = 1;
        while (stack.Count > 0)
        {
            b *= 2;
            var r = stack.Pop();
            result = result + b * r;
        }

        return result;
    }
}