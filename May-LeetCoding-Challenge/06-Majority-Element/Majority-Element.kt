class MajorityElementKotlin169 {
    fun majorityElement(nums: IntArray): Int {
        var majority = nums[0]
        var count = 0
        nums.forEach {
            if (it == majority) {
                count++
            } else if (--count == 0) {
                majority = it
                count = 1
            }
        }
        return majority
    }
    /*
    fun majorityElement(nums: IntArray): Int {
        val mapIntCount = mutableMapOf<Int, Int>()
        nums.forEach {
            mapIntCount[it] = mapIntCount.computeIfAbsent(it) { 0 }.plus(1)
            if (mapIntCount[it]!! > nums.size / 2) {
                return it
            }
        }
        return -1
    }
     */
}