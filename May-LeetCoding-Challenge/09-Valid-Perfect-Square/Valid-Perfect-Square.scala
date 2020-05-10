object Solution {
  def isPerfectSquare(num: Int): Boolean = isPerfectSquareWithRange(num, (0, 46341))

  def isPerfectSquareWithRange(num: Int, range: (Int, Int)): Boolean = {
    if (range._2 - range._1 < 2) false
    else {
      val mid = (range._1 + range._2) / 2
      val midSqr = mid * mid
      if (midSqr == num) true
      else isPerfectSquareWithRange(num, if (midSqr > num) (range._1, mid) else (mid, range._2))
    }
  }
}
