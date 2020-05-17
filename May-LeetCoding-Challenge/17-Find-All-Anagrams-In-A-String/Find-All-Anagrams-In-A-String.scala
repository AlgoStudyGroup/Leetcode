// for small & simple dataset, exception:  "memory limit exceeded" when s & p are both too long O((n - m) * m)
object Solution1 {
  def findAnagrams(s: String, p: String): List[Int] = {
    val sortedP = p.sorted
    (0 to s.length - sortedP.length).filter(index => isAnagram(s.substring(index, index + sortedP.length), sortedP)).toList
  }

  def isAnagram(textA: String, sortedTextB: String): Boolean = textA.length == sortedTextB.length && textA.sorted == sortedTextB
}

// solution with O(n + m) complexity
object Solution2 {
  import scala.collection.mutable._
  def findAnagrams(s: String, p: String): List[Int] = {
    val diffMap = HashMap.empty[Char, Int]
    // initiate diffMap
    p.foreach(updateMap(diffMap, _, 1))

    // -1 if char exist in diffMap, remove key if value == 0
    // +1 if char exit the subString's left bound , remove key if value == 0
    (0 until s.length).toList.filter(index => {
      if (index >= p.length) updateMap(diffMap, s(index - p.length), 1)
      updateMap(diffMap, s(index), -1)
      diffMap.isEmpty
    }).map(_ - p.length + 1)
  }

  def updateMap(map: HashMap[Char, Int], char: Char, incrementer: Int): Unit =
    map.get(char) match {
      case Some(number) if number + incrementer == 0 => map -= char
      case Some(number) => map += (char -> (number + incrementer))
      case None => map += (char -> incrementer)
    }
}
