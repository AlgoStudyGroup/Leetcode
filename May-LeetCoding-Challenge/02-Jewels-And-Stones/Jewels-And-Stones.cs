// hasset solution
public class Solution {
    public int NumJewelsInStones(string J, string S) {
        HashSet<char> hashStr= new HashSet<char>();
        int counter=0;
        foreach (char c in J)
        {
            hashStr.Add(c);
        }
        foreach(char cs in S)
        {
            if (hashStr.Contains(cs))
            {
                counter++;
            }
        }
        return counter;        
    }
}
