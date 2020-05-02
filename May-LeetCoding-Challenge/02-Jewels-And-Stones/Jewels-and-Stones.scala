/**
  * scala solution, not sure the fastest but surely the simplest
  */
object Solution {
  def numJewelsInStones(J: String, S: String): Int = S.toSeq.count(J.contains(_))
}
