public class RecentCounter {

    private Queue<int> queue;
    private int count;
    public RecentCounter() {
        count = 0;
        queue = new Queue<int>();
    }
    
    public int Ping(int t) {
        queue.Enqueue(t);
        while(t - queue.FirstOrDefault() > 3000)
        {
            queue.Dequeue();
        }
        return queue.Count();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.Ping(t);
 */