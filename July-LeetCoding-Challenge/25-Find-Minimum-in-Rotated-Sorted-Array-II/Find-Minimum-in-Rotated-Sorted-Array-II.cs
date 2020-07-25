public class Solution {
    public int FindMin(int[] nums) {
        var h = nums.Length-1;
        var l = 0;
        while(l < h){
            int mid = (l + h-1)/2;
            if(nums[mid] > nums[h]){
                l = mid +1;
            }else if(nums[mid] < nums[l]){
                h = mid;
                l++;
            }else {
                h--;
            }
        }
        return nums[l];
    }   
}