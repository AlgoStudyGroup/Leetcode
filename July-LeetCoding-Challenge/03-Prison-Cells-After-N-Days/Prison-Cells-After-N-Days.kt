package string_integer

class PrisonCellsAfterNDaysKotlin957 {
    fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
        var result = cells
        for (times in 0..((N - 1) % 14)) {
            val new = IntArray(cells.size)
            for (index in 1..cells.size - 2) {
                if (result[index - 1] == result[index + 1]) {
                    new[index] = 1
                } else {
                    new[index] = 0
                }
            }
            result = new
        }
        return result
    }
}

fun main() {
    val solution = PrisonCellsAfterNDaysKotlin957()
    // [0,0,1,1,0,0,0,0]
    solution.prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 7).forEach(::print)
    println()
    // [0,0,1,1,1,1,1,0]
    solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000).forEach(::print)
}