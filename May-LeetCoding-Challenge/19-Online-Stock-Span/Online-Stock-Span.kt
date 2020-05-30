import java.util.*

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */
class OnlineStockSpanKotlin901 {
    // 100 80 60 70 60 75 85
    // 1    1 1  2  1  4  6

    // 100 1    add 100
    // 100 1 -> 80 1    add 80
    // 100 1 -> 80 1 -> 60 1    add 60
    // 100 1 -> 80 1 -> 70 2    add 70
    // 100 1 -> 80 1 -> 70 2 -> 60 1    add 60
    // 100 1 -> 80 1 -> 75 4    add 75
    // 100 1 -> 85 6    add 85

    // 1384 ms
    // first price, second count
    private val priceCountStack: Stack<Pair<Int, Int>> = Stack()
    fun next(price: Int): Int {
        var count = 1
        // stack peek won't remove the element, just return the reference of last added element
        while (priceCountStack.isNotEmpty() && priceCountStack.peek().first <= price) {
            count += priceCountStack.pop().second
        }
        priceCountStack.push(Pair(price, count))
        return count
    }

    /*
    1884 ms
    private val prices: MutableList<Int> = ArrayList()
    fun next(price: Int): Int {
        var count = 1
        loop@ for (index in prices.size - 1 downTo 0) {
            when {
                prices[index] <= price -> ++count
                else -> break@loop
            }
        }
        prices.add(price)
        return count
    }
     */
}

fun main() {
    val solution = OnlineStockSpanKotlin901()
    // 1112146
    print(solution.next(100))
    print(solution.next(80))
    print(solution.next(60))
    print(solution.next(70))
    print(solution.next(60))
    print(solution.next(75))
    print(solution.next(85))
}