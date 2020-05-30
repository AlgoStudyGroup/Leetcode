object Solution {
    
    def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] =
    points.toList.sortWith(sortBySqrt).take(K).toArray
    
    private def sortBySqrt(arr1 :Array[Int], arr2:Array[Int]): Boolean = 
    (arr1(0) * arr1(0) + arr1(1) * arr1(1)) < (arr2(0) * arr2(0) + arr2(1) * arr2(1))
    
}
