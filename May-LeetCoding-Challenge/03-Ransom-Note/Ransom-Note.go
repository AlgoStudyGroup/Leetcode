// map
func canConstruct(ransomNote string, magazine string) bool {
    letters := make(map[rune]int)
    for _, c := range magazine {
        letters[c]++
    }
    for _, c := range ransomNote {
        letters[c]--
        if letters[c] < 0 {
            return false
        }
    }
    return true
}

// array
func canConstruct(ransomNote string, magazine string) bool {
    var letters [128]int // ASCII table: 128 chars
    for _, c := range magazine {
        letters[c]++
    }
    for _, c := range ransomNote {
        letters[c]--
        if letters[c] < 0 {
            return false
        }
    }
    return true
}
