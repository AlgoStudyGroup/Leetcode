object Solution {
  def countBits(num: Int): Array[Int] = {
    val res = Array.fill(num + 1)(0)
    for (i <- 0 to num) {
      res(i) = countOne(i)
    }
    res
  }

  def countOne(num: Int): Int = {
    var count = 0
    var rest = num
    while (rest > 1) {
      count += rest % 2
      rest = rest / 2
    }
    count + rest
  }
}

object Solution2 {
  def countBits(num: Int): Array[Int] = Range(0, num + 1).map(Solution.countOne).toArray
}