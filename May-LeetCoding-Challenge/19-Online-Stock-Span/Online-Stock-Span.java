/*
* Runtime: 32 ms. Memory Usage: 48.8 MB.
*/
class StockSpanner {

    private final List<Integer> prices = new ArrayList<>();
    private final List<Integer> spanner = new ArrayList<>();
    
    public StockSpanner() {
    }
    
    public int next(int price) {
        int span = 1;
        if (!prices.isEmpty()) {
            while (span <= spanner.size()) {
                int toCompIdx = spanner.size() - span;
                if (prices.get(toCompIdx) > price) {
                    break;
                } else {
                    span += spanner.get(toCompIdx);
                }
            }
        }
        prices.add(price);
        spanner.add(span);
        return span;  
    }
}