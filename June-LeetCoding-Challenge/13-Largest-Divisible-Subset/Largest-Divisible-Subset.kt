class LargestDivisibleSubsetKotlin368 {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        if (nums.isEmpty()) {
            return emptyList()
        }
        nums.sort()
        val dp = IntArray(nums.size) { 1 }
        val links = IntArray(nums.size) { -1 }
        var max = 0
        var start = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[j] % nums[i] == 0 &&
                    dp[j] < dp[i] + 1
                ) {
                    dp[j] = dp[i] + 1
                    links[j] = i
                    if (dp[j] > max) {
                        max = dp[j]
                        start = j
                    }
                }
            }
        }
        val result: MutableList<Int> = ArrayList()
        while (start != -1) {
            result.add(nums[start])
            start = links[start]
        }
        return result
    }
}