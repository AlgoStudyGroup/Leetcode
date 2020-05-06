public class Solution {
    public int FindComplement(int num) {        
        string tempStr = Convert.ToString(num,2);
        int help = (int)Math.Pow(2,tempStr.Length) - 1;  
        return num ^ help;
    }
}
