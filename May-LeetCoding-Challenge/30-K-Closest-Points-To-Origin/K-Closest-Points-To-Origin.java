class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>
            ((a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        
        for (int[] point : points) {
            minHeap.add(point);
        }

        for (int i = 0; i < K; i++) {
            res[i] = minHeap.poll();

        }
        return res;
    }
}

// quick select
class Solution2 {
    public int[][] kClosest(int[][] points, int K) {
        int from = 0;
        int to = points.length - 1;

        while (from < to) {
            int left = from;
            int right = to;
            int[] pivot = points[(from + to) / 2];

            while (left < right) {
                if (compare(points[left], pivot) >= 0) {
                    int[] point = points[right];
                    points[right] = points[left];
                    points[left] = point;
                    right--;
                } else {
                    left++;
                }
            }

            // if we stepped up (left++), we need to step one down
            if (compare(points[left], pivot) > 0) {
                left--;
            }
            if (K <= left) {
                to = left;
            } else {
                from = left + 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int compare(int[] a, int[] b) {
        // distanceA^2: ax^2 + ay^2
        // distanceB^2: bx^2 + by^2
        return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
    }
}
