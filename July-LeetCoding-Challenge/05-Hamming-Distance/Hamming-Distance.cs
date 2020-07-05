public class Solution
{
    //Queue solution
    public int HammingDistance(int x, int y)
    {
        if (x == y) return 0;
        var queueX = ToQueue(x);
        var queueY = ToQueue(y);
        return CompareTwoQueues(queueX, queueY);
    }

    private int CompareTwoQueues(Queue<int> x, Queue<int> y)
    {
        var r = 0;
        while (x.Count > 0 && y.Count > 0)
        {
            var vx = x.Dequeue();
            var vy = y.Dequeue();
            if (vx != vy)
            {
                r++;
            }
        }

        if (x.Count > 0)
        {
            r += Count(x);
        }
        else if (y.Count > 0)
        {
            r += Count(y);
        }
        return r;
    }

    private Queue<int> ToQueue(int x)
    {
        var queue = new Queue<int>();
        while (x >= 1)
        {
            if (x % 2 == 0) queue.Enqueue(0);
            else queue.Enqueue(1);
            x = x / 2;
        }
        return queue;
    }

    private int Count(Queue<int> q)
    {
        var r = 0;
        while (q.Count > 0)
        {
            var v = q.Dequeue();
            if (v == 1)
            {
                r++;
            }
        }
        return r;
    }


    //XOR solution
    public int HammingDistance(int x, int y)
    {
        var xor = x ^ y;
        var res = 0;
        for (int i = 0; i < 32; i++)
        {
            var r = xor >> i;
            if ((r & 1) == 1) res++;
        }
        return res;
    }
}