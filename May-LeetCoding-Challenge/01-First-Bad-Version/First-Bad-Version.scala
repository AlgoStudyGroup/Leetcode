class Solution extends VersionControl {
  def firstBadVersion(n: Int): Int = firstBadVersionFromRange(1, n)

  def firstBadVersionFromRange(start: Int, end: Int): Int =
    if (start == end) start
    else {
      val mid = start + (end - start)/2
      if (isBadVersion(mid)) firstBadVersionFromRange(start, mid)
      else firstBadVersionFromRange(mid + 1, end)
    }
}