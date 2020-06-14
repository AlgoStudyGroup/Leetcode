import kotlin.random.Random

class InsertDeleteGetRandomO1Kotlin380 {
    /** Initialize your data structure here. */
    private val arrayList: MutableList<Int> = ArrayList()
    private val map: MutableMap<Int, Int> = HashMap()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (map.containsKey(`val`)) {
            return false
        }
        map[`val`] = arrayList.size
        arrayList.add(`val`)
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) {
            return false
        }
        val removeIndex = map.getValue(`val`)
        if (removeIndex != arrayList.size - 1) {
            arrayList[removeIndex] = arrayList[arrayList.size - 1]
            map[arrayList[arrayList.size - 1]] = removeIndex
        }
        arrayList.removeAt(arrayList.size - 1)
        map.remove(`val`)
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        return arrayList[Random.Default.nextInt(arrayList.size)]
    }
}

fun main() {
    val solution = InsertDeleteGetRandomO1Kotlin380()
    println(solution.insert(1))
    println(solution.remove(2))
    println(solution.insert(2))
    println(solution.getRandom())
    println(solution.remove(1))
    println(solution.insert(2))
}