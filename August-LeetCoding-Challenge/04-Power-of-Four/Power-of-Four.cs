public class Solution {
    //Solution 1
    public bool IsPowerOfFour(int num) {       
        if(num > 1)
        {
            while(num % 4 == 0){
                num /= 4;
            }
        }
        return num == 1;
    }

    //Solution 2
    public bool IsPowerOfFour(int num) { 
        //0x55555555 (hex) means 0101 0101 0101 0101 0101 0101 0101 0101 (binary)
        return (num > 0)
            && (num & (num-1)) == 0
            && ((num & 0x55555555) != 0);
    }
}