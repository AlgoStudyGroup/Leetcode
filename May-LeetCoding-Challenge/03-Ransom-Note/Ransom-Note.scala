object Solution {
  def canConstruct(ransomNote: String, magazine: String): Boolean =
    magazine.diff(ransomNote).length == magazine.length - ransomNote.length
}