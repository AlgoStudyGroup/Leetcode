class Question03 {
  // sort by difference O(n2)
  object Solution {
    def twoCitySchedCost(costs: Array[Array[Int]]): Int = {
      costs.sortBy(t => t(0) - t(1)).zipWithIndex.foldLeft(0) {
        case (acc, (t, index)) => acc + (if (index < costs.length / 2) t(0) else t(1))
      }
    }
  }
}
