object Solution {
  def intervalIntersection(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    import scala.collection.mutable
    var res = mutable.Seq.empty[Array[Int]]
    var indexA = 0
    var indexB = 0
    while (indexA < A.length && indexB < B.length) {
      val (intAStart, intAEnd) = (A(indexA)(0), A(indexA)(1))
      val (intBStart, intBEnd) = (B(indexB)(0), B(indexB)(1))
      val start = intAStart max intBStart
      val end = intAEnd min intBEnd
      if (intAEnd >= intBEnd) indexB += 1
      if (intBEnd >= intAEnd) indexA += 1
      if (end >= start) res = res :+ Array(start, end)
    }
    res.toArray
  }
}