# Maximum Sum Circular Subarray

https://leetcode.com/problems/maximum-sum-circular-subarray/, Medium

## Warm up: Maximum Subarray

### Problem description

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

### Example

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

### Dynamic Programming

Denote by `dp[i]`, value of the maximum subarray ending at `nums[i]`. 

Question: Given `dp[0], dp[1], dp[i - 1]`, how to compute `dp[i]` ?

Answer: There are two possibilities: 

1. The maximum subarray ending at `nums[i]` is of length 1 (i.e. containing only nums[i]).  In this case, `dp[i] = nums[i]`.

2. The maximum subarray ending at `nums[i]` is of length >= 2. In this case, it is an extension of the maximum subarray ending at `nums[i-1]`. In other words, `dp[i] = dp[i-1] + nums[i]`.


By definition of `dp[i]`, we have  `dp[i] = max(nums[i], dp[i-1] + nums[i]) = nums[i] + max(0, dp[i-1]).` 

Hence, here is the dp equation: `dp[i] = max(0, dp[i-1]) + nums[i]`. Moreover, since i-th element of `dp[]` only depends on (i-1)-th, the space complexity can be reduced to O(1).


### Complexity:

- Time complexity O(n)
- Space complexity O(1)


## Maximum Sum Circular Subarray

### Strategy

Now, we have an circular array. Using the above DP as a black box, we have the following algorithm:

1. Computing the maximum subarray, denote by `max_sum` its value.
2. Computing the minimum subarray, denote by `min_sum` its value. (Suffices to replace `max` by `min` in DP)
3. Computing the sum of all elements in `nums[]`, denoted by `tot`.
4. The value of the maximum circular subarray = `max(max_sum, tot - min_sum)`

There is an exception: `nums[]` contains only negative values. In this case, the value of the maximum circular subarray is exactly the value of the largest number in `nums[]`.

### Complexity:

- Time complexity O(n)
- Space complexity O(1)





