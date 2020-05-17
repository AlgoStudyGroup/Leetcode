object Solution {
  def maxSubarraySumCircular(A: Array[Int]): Int = maxSubArrayFrom(A ++ A, 0, A(0))

  def maxSubArrayFrom(nums: Array[Int], from: Int, knownMaxSum: Int): Int = {
    if (from == nums.length) knownMaxSum
    else {
      var sum = nums(from)
      var maxSum = sum
      var i = from + 1
      while (i < nums.length / 2 + i && sum > 0) {
        sum += nums(i)
        maxSum = maxSum max sum
        i += 1
      }
      maxSubArrayFrom(nums, i, knownMaxSum max maxSum)
    }
  }
}
