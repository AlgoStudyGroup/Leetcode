class IsSubsequenceKotlin392 {

    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        var indexS = 0
        t.forEach {
            if (it == s[indexS]) {
                if (++indexS == s.length) {
                    return true
                }
            }
        }
        return false
    }

    /*
    fun isSubsequence(s: String, t: String): Boolean {
        val tMap = mutableMapOf<Char, MutableList<Int>>()
        t.forEachIndexed { index, c ->
            tMap.computeIfAbsent(c) { mutableListOf() }.add(index)
        }
        var indexOft = 0
        s.forEach {
            indexOft = binarySearch(tMap[it], indexOft)
            if (indexOft++ == -1) {
                return false
            }
        }
        return true
    }

    private fun binarySearch(nums: List<Int>?, target: Int): Int {
        if (nums.isNullOrEmpty()) {
            return -1
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] <= target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return when {
            nums[left] >= target -> nums[left]
            nums[right] >= target -> nums[right]
            else -> -1
        }
    }
     */
}