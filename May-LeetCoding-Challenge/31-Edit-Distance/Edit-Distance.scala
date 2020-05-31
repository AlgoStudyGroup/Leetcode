//Dynamic programming solution
object Solution {
  def minDistance(word1: String, word2: String): Int = {
    val (l1, l2) = (word1.length, word2.length)
    val dp = Array.ofDim[Int](l1 + 1, l2 + 1)
    for (i <- 0 to l1) { dp(i)(0) = i }
    for (j <- 0 to l2) { dp(0)(j) = j }
    for (i <- 0 until l1; j <- 0 until l2) {
      if (word1(i) == word2(j)) dp(i + 1)(j + 1) = dp(i)(j)
      else dp(i + 1)(j + 1) = (dp(i)(j) min (dp(i)(j + 1) min dp(i + 1)(j))) + 1
    }
    dp(l1)(l2)
  }
}