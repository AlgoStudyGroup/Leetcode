package depth_first_search

import java.util.*
import kotlin.collections.HashMap

class ReconstructItineraryKotlin332 {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val result: MutableList<String> = LinkedList()
        if (tickets.isEmpty()) {
            return result
        }
        val map: MutableMap<String, PriorityQueue<String>> = HashMap()
        tickets.forEach {
            map.computeIfAbsent(it[0]) { PriorityQueue() }.offer(it[1])
        }
        dfs(map, "JFK", result)
        return result
    }

    private fun dfs(
        map: MutableMap<String, PriorityQueue<String>>,
        s: String,
        result: MutableList<String>
    ) {
        if (map.containsKey(s)) {
            val current = map.getValue(s)
            while (current.isNotEmpty()) {
                dfs(map, current.poll(), result)
            }
        }
        result.add(0, s)
    }
}