public class Solution {
    public string AddBinary(string a, string b)
    {
        var sb = new StringBuilder();
        int i = a.Length-1, j = b.Length-1, carry = 0;
        while(i >=0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a[i--] - '0';
            if(j >= 0) sum += b[j--] - '0';
            sb.Append(sum % 2);
            carry = sum /2;
        }
        if(carry != 0) sb.Append(carry);
        var arr = sb.ToString().ToCharArray();
        Array.Reverse(arr);
        return new String(arr);
    }
}