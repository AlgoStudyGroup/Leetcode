// Solution: Binary search 
// Runtime: 208 ms, faster than 95.23% of C# online submissions for Random Pick with Weight.
// Memory Usage: 47.2 MB, less than 5.10% of C# online submissions for Random Pick with Weight.
public class Solution
{
    private int sum = 0; //sum of all integers of array w
    private int[] arr; //new Array, its index means index, its value means weight
    private Random random = new Random();
    public Solution(int[] w)
    {
        arr = new int[w.Length];
        for (var i = 0; i < w.Length; i++)
        {
            sum += w[i];
            arr[i] = sum;
        }
    }

    //Binary search
    public int PickIndex()
    {
        //Generate a random value between 0 and sum
        var randomValue = random.Next(0, sum) + 1;
        int left = 0, right = arr.Length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (arr[mid] == randomValue)
                return mid;
            else if (arr[mid] > randomValue)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}


// Solution: Linear search 
// Runtime: 400 ms, faster than 37.10% of C# online submissions for Random Pick with Weight.
// Memory Usage: 47 MB, less than 5.10% of C# online submissions for Random Pick with Weight.
public class Solution
{
    private int sum = 0; //sum of all integers of array w
    private int[] arr; //new Array, its index means index, its value means weight
    private Random random = new Random();
    public Solution(int[] w)
    {
        arr = new int[w.Length];
        for (var i = 0; i < w.Length; i++)
        {
            sum += w[i];
            arr[i] = sum;
        }
    }

    //Linear search
    public int PickIndex()
    {
        //Generate a random value between 0 and sum
        var randomeValue = random.Next(0, sum);

        for (int i = 0; i < arr.Length; i++)
        {
            if (randomeValue < arr[i])
            {
                return i;
            }
        }
        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.PickIndex();
 */