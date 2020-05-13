object Solution {
  def removeKdigits(num: String, k: Int): String =
    if (num.length == k) "0"
    else trimLeftZero(removeKdigitsWithAcc(num, num.length - k, ""))

  def removeKdigitsWithAcc(num: String, restNumberLength: Int, acc: String): String = {
    if (restNumberLength == 0) acc
    else if (num.length == restNumberLength) acc + num
    else {
      val rightIndexEnd = num.length - restNumberLength
      var smallestNumberIndex = 0
      var smallestNumber = num.head
      var index = 1
      while (index <= rightIndexEnd && smallestNumber != '0') {
        if (num(index).toInt < smallestNumber.toInt) {
          smallestNumber = num(index)
          smallestNumberIndex = index
        }
        index += 1
      }
      val newAcc = acc + smallestNumber
      removeKdigitsWithAcc(num.drop(smallestNumberIndex + 1), restNumberLength - 1, newAcc)
    }
  }

  def trimLeftZero(num: String): String = {
    val leftZeroDroppedNumber = num.dropWhile(_ == '0')
    if (leftZeroDroppedNumber.isEmpty) "0" else leftZeroDroppedNumber
  }

}
