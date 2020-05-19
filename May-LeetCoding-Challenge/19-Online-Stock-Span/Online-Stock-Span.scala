// Solution 8000+ ms
class StockSpanner() {
  import scala.collection.mutable
  var stocks = mutable.Seq.empty[Int]
  def next(price: Int): Int = {
    stocks = stocks.+:(price)
    stocks.indices.find(i => stocks(i) > price).getOrElse(stocks.length)
  }
}

// Solution 2000+ ms
class StockSpanner2() {
  import scala.collection.mutable
  var stocks = mutable.Seq.empty[(Int, Int)]
  def next(price: Int): Int = {
    var weight = 1
    while (stocks.nonEmpty && stocks.head._1 <= price) {
      weight += stocks.head._2
      stocks = stocks.tail
    }
    stocks = stocks.+:(price, weight)
    weight
  }
}
