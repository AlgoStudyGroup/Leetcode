object Solution {
    
    def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] =
    points.sortWith(sortBySqrt).take(K)
    
    private def sortBySqrt(arr1 :Array[Int], arr2:Array[Int]): Boolean = 
    (arr1(0) * arr1(0) + arr1(1) * arr1(1)) < (arr2(0) * arr2(0) + arr2(1) * arr2(1))
    
}


//simplest solution O(n * log(n))
object Solution2 {
    def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] =
        points.sortBy(p => p(0) * p(0) + p(1) * p(1)).take(K)
}

//QuickSelect solution with random pivot O(n) to 0(n*n)
object Solution3 {
    def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] =
        quickSelect(points, 0, points.length - 1, K)

    def quickSelect(points: Array[Array[Int]], start: Int, end: Int, K: Int): Array[Array[Int]] = {
        val pivot = scala.util.Random.nextInt(end - start + 1) + start
        var i = start
        var j = start
        swap(points, pivot, end)

        while (j < end) {
            if (SqAddition(points(j)) <= SqAddition(points(end))) {
                swap(points, i, j)
                i += 1
            }
            j += 1
        }

        swap(points, i, j)
        if (K == i + 1 - start) points.take(i + 1)
        else if (K > i + 1 - start) quickSelect(points, i + 1, end, K - i - 1 + start)
        else quickSelect(points, start, i - 1, K)
    }

    def swap(points: Array[Array[Int]], i: Int, j: Int): Unit = {
        val tmp = points(i)
        points(i) = points(j)
        points(j) = tmp
    }

    def SqAddition(point: Array[Int]): Int = point(0) * point(0) + point(1) * point(1)
}