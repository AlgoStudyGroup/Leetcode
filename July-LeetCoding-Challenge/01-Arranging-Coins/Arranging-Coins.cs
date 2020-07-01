public class Solution
{
    public int ArrangeCoins(int n)
    {
        return (int)((Math.Sqrt(8 * (long)n + 1) - 1) / 2);
    }
}

/*
n stars on row x:
x = 1, n = 1
x = 2, n = 1 + 2 = 3
x = 3, n = 1 + 2 + 3 = 6
x = 4, n = 1 + 2 + 3 + 4 = 10

formula: n = (x * (x + 1)) / 2

calculation steps:
2n = x * (x + 1) = x2 + x = x2 + x + 1/4 - 1/4 = (x + 1/2)2 - 1/4
2n + 1/4 = (x + 1/2)2
(8n + 1)/4 = (x + 1/2)2
x + 1/2 = sqrt((8n + 1)/4)
x = sqrt((8n + 1)/4) - 1/2
x = sqrt(8n +1)/2 - 1/2
x = (sqrt(8n +1)-1)/2

*/