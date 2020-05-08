func numJewelsInStones(J string, S string) int {
    var jewels [128]bool
    for _, j := range J {
        jewels[j] = true
    }
    count := 0
    for _, s := range S {
        if jewels[s] {
            count++
        }
    }
    return count
}
