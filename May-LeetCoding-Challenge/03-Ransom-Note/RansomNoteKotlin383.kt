class RansomNoteKotlin383 {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        // 292ms
        if (ransomNote.length > magazine.length) {
            return false
        }
        val intMagazines = IntArray(26)
        // a -> 97
        magazine.forEach { ++intMagazines[it - 'a'] }
        ransomNote.forEach {
            if (--intMagazines[it - 'a'] < 0) {
                return false
            }
        }
        return true
        /*  396ms
        if (ransomNote.length > magazine.length) {
            return false
        }
        val intMagazines = IntArray(26)
        // a -> 97
        magazine.forEach { ++intMagazines[it.toInt() - 97] }
        ransomNote.forEach {
            if (--intMagazines[it.toInt() - 97] < 0) {
                return false
            }
        }
        return true
         */
    }
}