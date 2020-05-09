class ValidPerfectSquareKotlin367 {
    fun isPerfectSquare(num: Int): Boolean {
        var left = 0
        // Int.MAX_VALUE = 2147483647 Sqrt(~) = 46340.95...
        var right = 46340
        while (left + 1 < right) {
            val mid = left + (right - left) / 2 // Int.MAX_VALUE = 2147483647
            when {
                mid * mid == num -> return true
                mid * mid < num -> left = mid
                mid * mid > num -> right = mid
            }
        }
        return when (num) {
            right * right -> true
            else -> false
        }
    }
}