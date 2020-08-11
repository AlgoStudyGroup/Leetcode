package hash_map_set

class DesignHashSetKotlin705 {
    /** Initialize your data structure here. */
    private val table = BooleanArray(1000001)

    fun add(key: Int) {
        table[key] = true
    }

    fun remove(key: Int) {
        table[key] = false
    }

    /** Returns true if this set contains the specified element */
    fun contains(key: Int): Boolean {
        return table[key]
    }
}