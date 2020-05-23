//easiest solution but maybe not the fastest way
object Solution {
  def frequencySort(s: String): String = s.groupBy(c => c).toSeq.sortBy(-_._2.length).foldLeft("")((acc, t) => acc + t._2)
}