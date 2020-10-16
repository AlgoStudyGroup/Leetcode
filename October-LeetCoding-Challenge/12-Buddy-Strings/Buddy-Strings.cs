public class Solution {
    public bool BuddyStrings(string A, string B) {
        if((A == null && B != null) || (A != null && B == null)) return false;
        if(A.Length != B.Length) return false;
        int diffCount = 0;
        int a = -1, b = -1;
        bool canSwitch = false;
        int[] count = new int[26];

        for(int i=0; i<A.Length; i++){
			if(++count[A[i] - 'a'] >= 2) canSwitch = true;
            
            if(A[i] != B[i])
            {
                diffCount++;
                if (a == -1)  a = i;
                else if (b == -1)  b = i;
            }
        }
        return (diffCount == 0 && canSwitch) || (diffCount == 2 && A[a] == B[b] && A[b] == B[a]);
    }
}
