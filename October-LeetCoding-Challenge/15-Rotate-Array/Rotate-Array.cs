public class Solution {
    public void Rotate(int[] nums, int k) {
        if(nums == null || nums.Length < 2) return;
        var length = nums.Length;
        int n = k % length;
        //Reverse left part
        Reverse(nums, 0, length - 1 - n);
        //Reverse right part
        Reverse(nums, length - n, length-1);
        //Reverse whole array
        Reverse(nums, 0, length-1);
    }
    private void Reverse(int[] nums, int b, int e){
        int tmp = 0;
        while(b < e){
            tmp = nums[b];
            nums[b] = nums[e];
            nums[e] = tmp;
            b++;
            e--;
        }
    }
}