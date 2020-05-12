/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function(nums) {
    var i = 0;
    var j = nums.length-1;
    if((j^0)==0){
        return nums[0];
    }
    while(i<j){
        let mid = parseInt((i+j)/2);
        if(nums[mid]!=nums[mid-1] && nums[mid] != nums[mid+1]){
            return nums[mid];
        }
        else{
            if(nums[mid]==nums[mid-1]){
                let t = (mid-i+1);
                //console.log(nums[mid]+" "+nums[mid-1]+" "+t);
                if((t&1)==0){//paire
                    i = mid+1;
                }
                else{//impaire
                    j = mid;
                }
                //console.log(i+" "+j);
            }
            else if(nums[mid]==nums[mid+1]){
                let t = mid+2-i;
                //console.log(nums[mid]+" "+nums[mid+1]+" "+t);
                if((t&1)==0){
                    i = mid+2;
                }
                else{
                    j = mid;
                }
            }
        }
        if(i==j){
            return nums[j];
        }
    }
    return 0;
};
