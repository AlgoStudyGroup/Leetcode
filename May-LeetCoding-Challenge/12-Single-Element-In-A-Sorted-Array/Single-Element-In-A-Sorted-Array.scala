// 2*O(n)
object Solution1 {
  def singleNonDuplicate(nums: Array[Int]): Int = nums.groupBy(p => p).find(_._2.length == 1).get._1
}

// O(n)
object Solution2 {
  def singleNonDuplicate(nums: Array[Int]): Int = nums.reduce((a, b) => a ^ b)
}

// O(log(n))
object Solution3 {
  def singleNonDuplicate(nums: Array[Int]): Int = {

    def singleNonDuplicateByRange(start: Int, end: Int): Int = {
      if (start == end) nums(start)
      else {
        val mid = start + (end - start) / 2
        val midValue = nums(mid)
        val isLeftOdd = (mid - start) % 2 == 0
        if (midValue == nums(mid - 1)) {
          if (isLeftOdd) singleNonDuplicateByRange(start, mid - 2)
          else singleNonDuplicateByRange(mid + 1, end)
        } else if (midValue == nums(mid + 1)) {
          if (isLeftOdd) singleNonDuplicateByRange(mid + 2, end)
          else singleNonDuplicateByRange(start, mid - 1)
        } else {
          midValue
        }
      }
    }

    singleNonDuplicateByRange(0, nums.length - 1)
  }

}
