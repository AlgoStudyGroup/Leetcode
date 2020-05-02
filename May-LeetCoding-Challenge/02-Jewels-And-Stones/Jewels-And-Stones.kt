class JewelsandStonesKotlin771 {
    fun numJewelsInStones(J: String, S: String): Int {
        val jCharSet = J.toHashSet()    // 164ms use HashSet
        // val jCharSet = J.toSet()    // 180ms because use LinkedHashSet
        return S.count { jCharSet.contains(it) }
    }
}