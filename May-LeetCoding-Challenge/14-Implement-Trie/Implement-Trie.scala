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

// This solution is a little bit mixed of java and scala
// Cause the Leetcode's website use a java style (mutable) scala code to test implementation:
// Using class rather than case class and initializing root node with new Trie()
class Trie(var value: Option[Boolean] = None,
           var children: List[Option[Trie]] = List.fill(26)(None)) {
    
  def searchRec(node: Trie, key: String, step: Int): Boolean = 
    if (key.length == step) {
      node.value.getOrElse(false)
    } else {
      node.children(key.charAt(step) - 97) match {
        case Some(nextItem) => searchRec(nextItem, key, step + 1)
        case None           => false
      }
    }
    
        
  def startWithRec(node: Trie, key: String, step: Int): Boolean = 
    if (key.length == step) {
      node.value.getOrElse(false) || node.children.flatten.nonEmpty
    } else {
      node.children(key.charAt(step) - 97) match {
        case Some(nextItem) => 
          startWithRec(nextItem, key, step + 1)
        case None           => 
          false
      }
    }

  def insertRec(node: Trie, key: String, value: Boolean = true, step: Int): Trie =
    if (key.length == step) {
      node.value = Some(true)
      node
    } else {
      val index    = key.charAt(step) - 97
      val nextItem = node.children(index).getOrElse(new Trie())
      val newNode  = insertRec(nextItem, key, value, step + 1)
      val newNext  = node.children.updated(index, Some(newNode))

      node.children = newNext
      node  
    }

    def insert(word: String): Unit = {
        val result = insertRec(this, word, true, 0)
        this.value = result.value
        this.children = result.children
    }
    def search(word: String): Boolean = {
        searchRec(this, word, 0)
    }
    
    def startsWith(word: String): Boolean = {
        startWithRec(this, word, 0)
    }
}
