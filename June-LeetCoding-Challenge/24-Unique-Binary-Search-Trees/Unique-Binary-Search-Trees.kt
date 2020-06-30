package depth_first_search

class UniqueBinarySearchTreesKotlin96 {
    // https://zh.wikipedia.org/wiki/%E5%8D%A1%E5%A1%94%E5%85%B0%E6%95%B0
    // https://en.wikipedia.org/wiki/Catalan_number
    fun numTrees(n: Int): Int {
        var result = 1L
        for (index in n + 1..n * 2) {
            result = result * index / (index - n)
        }
        return (result / (n + 1)).toInt()
    }
}