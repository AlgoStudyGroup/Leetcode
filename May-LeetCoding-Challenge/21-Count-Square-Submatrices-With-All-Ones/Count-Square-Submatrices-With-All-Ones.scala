//brute force solution
object Solution {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    val maxX = matrix(0).length
    val maxY = matrix.length
    val maxSide = maxX max maxY
    val list = for (side <- 0 until maxSide; x <- 0 until (maxX - side); y <- 0 until (maxY - side); if isAllOne(matrix, x, y, side)) yield 1
    list.size
  }

  def isAllOne(matrix: Array[Array[Int]], startX: Int, startY: Int, side: Int): Boolean =
    !(startX to startX + side).exists(x => (startY to startY + side).exists(y => matrix(y)(x) == 0))

}

//optimized solution O(x * y * 2)
object Solution2 {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    val maxX = matrix(0).length
    val maxY = matrix.length
    val res = Array.fill(maxY)(Array.fill(maxX)(0))
    for (x <- 0 until maxX; y <- 0 until maxY; if matrix(y)(x) == 1) {
      res(y)(x) = if (x != 0 && y != 0) ((res(y - 1)(x) min res(y - 1)(x - 1)) min res(y)(x - 1)) + 1 else 1
    }
    res.foldLeft(0)((acc, rang) => acc + rang.sum)
  }
}

//optimized solution+ O(x * y)
object Solution3 {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    val maxX = matrix(0).length
    val maxY = matrix.length
    val res = Array.fill(maxY)(Array.fill(maxX)(0))
    var total = 0
    for (x <- 0 until maxX; y <- 0 until maxY; if matrix(y)(x) == 1) {
      res(y)(x) = if (x != 0 && y != 0) ((res(y - 1)(x) min res(y - 1)(x - 1)) min res(y)(x - 1)) + 1 else 1
      total += res(y)(x)
    }
    total
  }
}