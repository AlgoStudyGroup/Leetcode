
class Question05 {
  import scala.util.Random
  //create a new array of integers represent the bounds of proportion
  //ex: (1, 4, 5, 100) => (0 ,1, 5, 10, 100),  take last value as seed (100)
  //if randomValue == 8   ->  8  <= 10   -> take index - 1  ->  indexOf(10)  - 1  = 2
  //if randomValue == 30  ->  30 <= 100  -> take index - 1  ->  indexOf(100) - 1  = 3
  class Solution(_w: Array[Int]) {
    var acc: Int = 0
    val w: Array[Int] = Array.fill(_w.length + 1)(0)
    for (i <- 1 until w.length) {
      w(i) = _w(i - 1) + acc
      acc = w(i)
    }

    def pickIndex(): Int = {
      val randomValue = Random.nextInt(acc) + 1
      var index = 0
      var done = false
      while (!done && index < _w.length) {
        if (randomValue <= w(index)) done = true
        else index += 1
      }
      index - 1
    }
  }

}

