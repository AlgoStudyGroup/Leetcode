public class SingleElementinaSortedArray540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        int left = 1;
        int right = nums.length - 2;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (isSingle(nums, mid)) {
                return nums[mid];
            } else {
                if (singleInLeft(nums, mid)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        if (isSingle(nums, left)) {
            return nums[left];
        }
        return nums[right];
    }

    private boolean isSingle(final int[] nums, final int index) {
        return nums[index] != nums[index - 1] && nums[index] != nums[index + 1];
    }

    // return true ==> single element is in your left, so right = mid
    // return false ==> in your right, so left = mid
    private boolean singleInLeft(final int[] nums, final int notSingle) {
        if (nums[notSingle] == nums[notSingle - 1] && notSingle % 2 == 0) {
            return true;
        }
        return nums[notSingle] != nums[notSingle - 1] && notSingle % 2 != 0;
        /*
        if(nums[notSingle] == nums[notSingle-1]){
            if(notSingle%2 ==0){
                return true;
            }else{
                return false;
            }
        }else{
            if(notSingle%2==0){
                return false;
            }else {
                return true;
            }
        }
         */
    }
}

class Solution2 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        /* Be aware the number of element is odd, so the problem becomes simple:
         * the single number is always in the odd part 
         */
        while(left < right) {
            int mid = left + (right  - left) / 2;
            if(nums[mid] == nums[mid+1]) {
                if((mid - left) % 2 == 0)
                    left = mid + 2;
                else right = mid - 1;
            } else if (nums[mid] == nums[mid - 1]) {
                if((mid - 1 - left) % 2 == 0)
                    left = mid + 1;
                else right = mid - 2;
            } else {
                return nums[mid];
            }
        }
        
        return nums[left];
    }
}
