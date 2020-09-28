public class Solution {
    public int NumSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.Length;
        int p = 1;
        int i=0, j=0, total=0;
        while(j < len){
            p *= nums[j];
            while(i<=j && p>=k){
                p /= nums[i];
                i++;
            }
            total += (j-i+1);
            j++;
        }
        return total;
    }
}
