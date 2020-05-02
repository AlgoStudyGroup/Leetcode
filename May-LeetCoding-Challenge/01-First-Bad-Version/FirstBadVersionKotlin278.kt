class FirstBadVersionKotlin278 {
    fun firstBadVersion(n: Int): Int {
        var left = 0
        var right = n
        // never dead loop
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                // find first bad version, so move right to mid
                isBadVersion(mid) -> right = mid
                else -> left = mid
            }
        }
        return when {
            isBadVersion(left) -> left
            else -> right
        }
    }

    private fun isBadVersion(version: Int) = version > 3
}