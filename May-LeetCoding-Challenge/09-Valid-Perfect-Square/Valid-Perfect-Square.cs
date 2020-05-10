public class Solution {
    public bool IsPerfectSquare(int num) {
        int temp=num;
        int x=num/2;
        if (x<2)
        {
            return true;
        }
        {
        while ( x > num/x )
        {
            x=temp/2;
            temp=x;
        }
        for(int i = x; i<2*x ; i++)
        {
            if (i*i == num)
            {
                return true;
            }
        
        }
        return false;   
            }
    }
}
