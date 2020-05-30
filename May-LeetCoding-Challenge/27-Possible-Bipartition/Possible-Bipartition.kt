class PossibleBipartitionKotlin886 {
    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        val dislikesMap: MutableMap<Int, MutableList<Int>> = HashMap()
        for (dislike in dislikes) {
            dislikesMap.computeIfAbsent(dislike[0]) { mutableListOf() }.add(dislike[1])
            dislikesMap.computeIfAbsent(dislike[1]) { mutableListOf() }.add(dislike[0])
        }
        val hashArray = IntArray(N + 1)
        for (index in hashArray.indices) {
            hashArray[index] = index
        }
        for (index in 1 until hashArray.size) {
            if (!dislikesMap[index].isNullOrEmpty()) {
                val currentHash = hash(hashArray, index)
                val dislikeList = dislikesMap.getValue(index)
                val first = hash(hashArray, dislikeList[0])
                if (currentHash == first) {
                    return false
                }
                for (d in 1 until dislikeList.size) {
                    val dislikeHash = hash(hashArray, dislikeList[d])
                    if (currentHash == dislikeHash) {
                        return false
                    }
                    hashArray[dislikeHash] = first
                }
            }
        }
        return true
    }

    private fun hash(hashArray: IntArray, target: Int): Int = when (target) {
        hashArray[target] -> target
        else -> hash(hashArray, hashArray[target])
    }
    /*
    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        val dislikesMap: MutableMap<Int, MutableList<Int>> = HashMap()
        for (dislike in dislikes) {
            dislikesMap.computeIfAbsent(dislike[0]) { mutableListOf() }.add(dislike[1])
            dislikesMap.computeIfAbsent(dislike[1]) { mutableListOf() }.add(dislike[0])
        }
        val nArray = IntArray(N + 1)
        for (index in 1 until nArray.size) {
            if (nArray[index] == 0) {
                val queue: Queue<Int> = LinkedList()
                nArray[index] = 1
                queue.offer(index)
                while (queue.isNotEmpty()) {
                    val current = queue.poll()
                    dislikesMap[current]?.forEach {
                        when {
                            nArray[it] == nArray[current] -> return false
                            nArray[it] == 0 -> {
                                nArray[it] = -nArray[current]
                                queue.offer(it)
                            }
                        }
                    }
                }
            }
        }
        return true
    }
     */
    /*
    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        val dpDislikes = Array(N + 1) { IntArray(N + 1) }
        for (dislike in dislikes) {
            dpDislikes[dislike[0]][dislike[1]] = 1
            dpDislikes[dislike[1]][dislike[0]] = 1
        }
        val nArray = IntArray(N + 1)
        for (index in 1 until nArray.size) {
            if (nArray[index] == 0 && canNotGroup(index, 1, nArray, dpDislikes)) {
                return false
            }
        }
        return true
    }

    private fun canNotGroup(
        n: Int,
        group: Int,
        nArray: IntArray,
        dpDislikes: Array<IntArray>
    ): Boolean = !canGroup(n, group, nArray, dpDislikes)

    private fun canGroup(
        n: Int,
        group: Int,
        nArray: IntArray,
        dpDislikes: Array<IntArray>
    ): Boolean {
        nArray[n] = group
        for (index in 1 until dpDislikes.size) {
            if (dpDislikes[n][index] == 1) {
                when {
                    nArray[index] == group -> return false
                    nArray[index] == 0 && canNotGroup(index, -group, nArray, dpDislikes) -> return false
                }
            }
        }
        return true
    }
     */
}