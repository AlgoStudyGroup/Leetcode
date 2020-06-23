class PermutationSequenceKotlin60 {

    private val permutation: IntArray = IntArray(10)

    init {
        permutation[0] = 1
        for (index in 1 until permutation.size) {
            permutation[index] = permutation[index - 1] * index
        }
    }

    fun getPermutation(n: Int, k: Int): String {
        val stringBuild = StringBuilder()
        var current = k - 1
        val numberList: MutableList<Int> = ArrayList()
        for (i in 1..n) {
            numberList.add(i)
        }
        for (index in n downTo 1) {
            val p = permutation[index - 1]
            stringBuild.append(numberList[current / p])
            numberList.removeAt(current / p)
            current %= p
        }
        return stringBuild.toString()
    }
}

fun main() {
    val solution = PermutationSequenceKotlin60()
    println(solution.getPermutation(4, 9))
}