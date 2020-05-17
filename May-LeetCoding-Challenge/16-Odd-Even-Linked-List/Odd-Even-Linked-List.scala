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
