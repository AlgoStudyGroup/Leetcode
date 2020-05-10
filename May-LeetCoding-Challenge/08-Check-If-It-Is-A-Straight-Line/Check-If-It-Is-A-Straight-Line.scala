object Solution {
  def checkStraightLine(coordinates: Array[Array[Int]]): Boolean = {

    if (coordinates.length <= 2) true
    else {
      val firstGradient = gradient(coordinates, 1)
      ! (2 until coordinates.length).exists(gradient(coordinates, _) != firstGradient)
    }
  }

  def gradient(coordinates: Array[Array[Int]], index: Int): Double ={
    (coordinates(index)(1) - coordinates(index - 1)(1)).toDouble /
      (coordinates(index)(0) - coordinates(index - 1)(0)).toDouble
  }
}

