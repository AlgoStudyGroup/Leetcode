object Solution {
  def majorityElement(nums: Array[Int]): Int = {
    val map = scala.collection.mutable.HashMap.empty[Int, Int]
    var found = false
    var index = 0
    var foundNumber = nums(0)
    while (!found && index < nums.length){
      val num = nums(index)
      map.get(num) match {
        case None => map.put(num, 1)
        case _ => {
          val repeatTime = map(num) + 1
          if (repeatTime > nums.length / 2) {
            found = true
            foundNumber = num
          }
          map.put(num, repeatTime)
        }
      }
      index = index + 1
    }
    foundNumber
  }
}

