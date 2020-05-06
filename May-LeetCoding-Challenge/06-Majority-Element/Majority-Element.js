/**
 * @param {number[]} nums
 * @return {number}
 */

// Solution 1 sort and obtain the mid
var majorityElement = function(nums) {
    nums.sort(function(a,b){return a-b;});
    return nums[parseInt(nums.length/2)];
};
