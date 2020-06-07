class Solution {
    public int change(int amount, int[] coins) {
        int[] combinations = new int[amount + 1];
        combinations[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                int prev = i - coin;
                if (prev >= 0) {
                    combinations[i] += combinations[prev];
                }
            }
        }
        return combinations[amount];
    }
}
