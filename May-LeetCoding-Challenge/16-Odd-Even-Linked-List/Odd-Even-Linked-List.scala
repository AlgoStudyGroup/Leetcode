// Since the question asks for a O(1) space complexity and O(nodes) time complexity
// I decide to make no difference to a java solution...
object Solution {
    def oddEvenList(head: ListNode): ListNode = {
        if (head == null)
            null
        else{
            // Initialize two LinkedList
            var currentOdd = head
            var currentEven = head.next
            var firstEven = currentEven

            while (currentEven != null && currentEven.next != null) {
                currentOdd.next = currentEven.next
                currentOdd = currentOdd.next
                currentEven.next = currentOdd.next
                currentEven = currentEven.next
            }
            // Combine two LinkedList
            currentOdd.next = firstEven

            head
        }

    }
}

//nothing special ... but i HATE "null" in scala's code !!!
object Solution2 {

  def oddEvenList(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else {
      val evenListHead = head.next
      def reLinkList(odd: ListNode, even: ListNode): Unit = {
        if (even == null || even.next == null) odd.next = evenListHead
        else {
          odd.next = even.next
          even.next = odd.next.next
          reLinkList(odd.next, even.next)
        }
      }
      reLinkList(head, evenListHead)
      head
    }
  }
}
