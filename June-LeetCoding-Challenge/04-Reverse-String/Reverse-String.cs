public class Solution {
    
    public void ReverseString(char[] s) {
        int left = 0;
        int right = s.Length-1;
        while (left < right)
        {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    
    public void ReverseString2(char[] s) {
        helper(s, 0, s.Length-1);
    }
    
    public void helper(char[] s, int left, int right)
    {
        if (left < right)
        {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            helper(s, left+1, right-1);
        }
    }
}
