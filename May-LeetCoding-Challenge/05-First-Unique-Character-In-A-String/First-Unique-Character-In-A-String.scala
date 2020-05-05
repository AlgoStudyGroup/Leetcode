object Solution {
  def firstUniqChar(s: String): Int = {
    val letterMap = scala.collection.mutable.HashMap.empty[Char, (Int, Boolean)]
    var repeatingCharCount = 0
    var index = 0
    val chars = s.toCharArray
    val length = chars.length
    while (index < length && repeatingCharCount < 26) {
      val char = chars(index)
      letterMap.get(char) match {
        case None => letterMap.put(char, (index, true))
        case Some(v) => {
          letterMap.put(char, (v._1, false))
          if (v._2) repeatingCharCount = repeatingCharCount + 1
        }
      }
      index = index + 1
    }
    if (repeatingCharCount == 26) -1
    else {
      val filteredMap = letterMap.filter(_._2._2)
      if (filteredMap.isEmpty) -1
      else filteredMap.minBy(_._2._1)._2._1
    }
  }
}

