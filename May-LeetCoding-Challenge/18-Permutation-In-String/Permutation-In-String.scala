//almost the same as Question 17 , we use exists instead of filter to find the first permutation
object Solution {
  import scala.collection.mutable._

  def checkInclusion(s1: String, s2: String): Boolean = {
    val diffMap = HashMap.empty[Char, Int]
    s1.foreach(updateMap(diffMap, _, 1))

    (0 until s2.length).toList.exists(index => {
      if (index >= s1.length) updateMap(diffMap, s2(index - s1.length), 1)
      updateMap(diffMap, s2(index), -1)
      diffMap.isEmpty
    })
  }

  def updateMap(map: HashMap[Char, Int], char: Char, incrementer: Int): Unit =
    map.get(char) match {
      case Some(number) if number + incrementer == 0 => map -= char
      case Some(number)                              => map += (char -> (number + incrementer))
      case None                                      => map += (char -> incrementer)
    }
}
