public class Solution
{
    public IList<string> FindItinerary(IList<IList<string>> tickets)
    {
        var result = new List<string>();
        var dict = new Dictionary<string, List<string>>();
        for (int i = 0; i < tickets.Count(); i++)
        {
            var from = tickets[i][0];
            var to = tickets[i][1];
            if (!dict.ContainsKey(from))
            {
                dict[from] = new List<string>();
            }
            dict[from].Add(to);
        }
        //Sort items in value list for each dictionary key
        foreach (var kv in dict)
        {
            kv.Value.Sort();
        }
        var stack = new Stack<string>();
        stack.Push("JFK");
        while (stack.Count > 0)
        {
            while (dict.ContainsKey(stack.Peek()) && dict[stack.Peek()].Count > 0)
            {
                var firstDest = dict[stack.Peek()].First();
                dict[stack.Peek()].Remove(firstDest);
                stack.Push(firstDest);
            }
            result.Insert(0, stack.Pop());
        }
        return result;
    }
}
