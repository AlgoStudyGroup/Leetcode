object Solution1 {
  def findComplement(num: Int): Int = {
    num
      .toBinaryString
      .map(c => if (c == '1') '0' else '1')
      .dropWhile(_ != '1')
      .reverse
      .zipWithIndex
      .map(t => t._1.toString.toInt * math.pow(2,t._2))
      .sum
      .toInt

  }
}

//with java function Integer.parseInt
object Solution2 {
  def findComplement(num: Int): Int = Integer.parseInt(num.toBinaryString.map(c => if (c == '1') '0' else '1'), 2)
}

//learn from others  ^^
object Solution3 {
  def findComplement(num: Int): Int = {
    var mask = 1
    while (mask < num) {
      mask = (mask << 1) + 1
    }
    num ^ mask
  }
}