class Question04 {

  object Solution {
    def reverseString(s: Array[Char]): Unit = {
      var index = 0
      //not necessary to revert middle char in a odd array
      while (index < (s.length.toDouble - 1) / 2) {
        val tmp = s(index)
        s(index) = s(s.length - 1 - index)
        s(s.length - 1 - index) = tmp
        index += 1
      }
    }
  }

}
