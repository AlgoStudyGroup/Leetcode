class Trie() {

  /** Initialize your data structure here. */
  case class TrieNode(isKey: Boolean = false, children: Array[Option[TrieNode]] = Array.fill[Option[TrieNode]](26)(None))

  val data: TrieNode = TrieNode()

  private def getCharIndex(char: Char): Int = char.toInt - 97

  /** Inserts a word into the trie. */
  def insert(word: String): Unit = recursiveInsert(data, word)

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = recursiveSearch(data, word)

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = recursiveSearch(data, prefix, doSearchPrefix = true)


  def recursiveInsert(node: TrieNode, text: String): Unit = {
    if (text.nonEmpty) {
      val firstCharIndex = getCharIndex(text.head)
      val childToInsert = node.children(firstCharIndex) match {
        case Some(child) if text.length == 1 =>
          val updatedChild = child.copy(isKey = true)
          node.children(firstCharIndex) = Some(updatedChild)
          updatedChild
        case Some(child) => child
        case None =>
          val newChild = TrieNode(text.length == 1)
          node.children(firstCharIndex) = Some(newChild)
          newChild
      }
      recursiveInsert(childToInsert, text.tail)
    }
  }

  def recursiveSearch(node: TrieNode, text: String, doSearchPrefix: Boolean = false): Boolean = {
    if (text.isEmpty)
      if (doSearchPrefix) true else node.isKey
    else {
      val firstCharIndex = getCharIndex(text.head)
      node.children(firstCharIndex) match {
        case Some(child) => recursiveSearch(child, text.tail, doSearchPrefix)
        case None => false
      }
    }
  }
}
