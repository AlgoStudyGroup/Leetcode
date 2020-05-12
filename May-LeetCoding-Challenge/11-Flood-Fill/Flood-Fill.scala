object Solution {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    fill(image, sr, sc, image(sr)(sc), newColor)
    image
  }

  def fill(image: Array[Array[Int]], r: Int, c: Int, startColor: Int, newColor: Int): Unit = {
    val oldColor = image(r)(c)
    if (oldColor == startColor && oldColor != newColor) {
      image(r)(c) = newColor
      if (r - 1 >= 0) fill(image, r - 1, c, startColor, newColor)
      if (c - 1 >= 0) fill(image, r, c - 1, startColor, newColor)
      if (r + 1 < image.length) fill(image, r + 1, c, startColor, newColor)
      if (c + 1 < image(0).length) fill(image, r, c + 1, startColor, newColor)
    }
  }
}


object Solution2 {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val startColor = image(sr)(sc)

    def fill(r: Int, c: Int): Unit = {
      val oldColor = image(r)(c)
      if (oldColor == startColor && oldColor != newColor) {
        image(r)(c) = newColor
        if (r - 1 >= 0) fill(r - 1, c)
        if (c - 1 >= 0) fill(r, c - 1)
        if (r + 1 < image.length) fill(r + 1, c)
        if (c + 1 < image(0).length) fill(r, c + 1)
      }
    }

    fill(sr, sc)
    image
  }
}

