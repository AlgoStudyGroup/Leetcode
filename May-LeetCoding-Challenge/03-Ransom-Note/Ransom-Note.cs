public class Solution {
    public bool CanConstruct(string ransomNote, string magazine) {
        
        Dictionary<char, int> dicMagazine =  new Dictionary<char, int>();
        foreach (char c in magazine)
        {
           if(dicMagazine.ContainsKey(c))
           {
              dicMagazine[c] ++;
           }
            else
            {
                dicMagazine.Add(c,1);
            }    
        }
        foreach (char r in ransomNote)
        {
            if (dicMagazine.ContainsKey(r))
            {
               dicMagazine[r] --;
                if ( dicMagazine[r] == 0)
                {
                    dicMagazine.Remove(r);
                }
            }
            else
            {
                return false;
            }
         
        } 
           return true;
    }
}
