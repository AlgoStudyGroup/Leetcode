class QueueReconstructionbyHeightKotlin406 {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(Comparator { t, t2 ->
            when {
                t[0] == t2[0] -> compareValues(t[1], t2[1])
                else -> compareValues(t2[0], t[0])
            }
        })
        val result: MutableList<IntArray> = ArrayList()
        people.forEach {
            result.add(it[1], it)
        }
        return result.toTypedArray()
    }
}
