//solution typical "scala" way
object Solution1 {
  def canConstruct(ransomNote: String, magazine: String): Boolean =
    magazine.diff(ransomNote).length == magazine.length - ransomNote.length
}


object Solution2 {
  def canConstruct(ransomNote: String, magazine: String): Boolean = canConstructRec(ransomNote, magazine, rIndex = 0, alwaysPresent = true)

  def canConstructRec(ransomNote: String, magazine: String, rIndex: Int, alwaysPresent: Boolean): Boolean = {
    if (!alwaysPresent) false
    else if (ransomNote.length <= rIndex) true
    else {
      var mIndex = 0
      while (mIndex <= magazine.length - 1 && ransomNote(rIndex) != magazine(mIndex)) mIndex = mIndex + 1
      canConstructRec(ransomNote, removeByIndex(magazine, mIndex), rIndex + 1, !(mIndex == magazine.length))
    }
  }

  //remove character from text by index
  def removeByIndex(list: String, index: Int): String = list.take(index) ++ list.drop(index + 1)

}