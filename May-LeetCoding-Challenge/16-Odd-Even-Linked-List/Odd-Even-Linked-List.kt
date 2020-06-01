class OddEvenLinkedListKotlin328 {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next?.next == null) {
            return head
        }
        val evenHead = head.next

        var odd = head
        var even = head.next
        var current = even
        var count = 0
        while (current?.next != null) {
            current = current.next
            if (count % 2 == 0) {
                odd?.next = current
                odd = current
            } else {
                even?.next = current
                even = current
            }
            count++
        }
        even?.next = null
        odd?.next = evenHead
        return head
    }
    /*
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next?.next == null) {
            return head
        }
        val evenHead = head.next

        var odd = head
        var even = head.next
        var current = even
        var isOdd = true
        while (current?.next != null) {
            current = current.next
            if (isOdd) {
                isOdd = !isOdd
                odd?.next = current
                odd = current
            } else {
                isOdd = !isOdd
                even?.next = current
                even = current
            }
        }
        even?.next = null
        odd?.next = evenHead
        return head
    }
     */

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

fun main() {
    val node1 = OddEvenLinkedListKotlin328.ListNode(1)
    val node2 = OddEvenLinkedListKotlin328.ListNode(2)
    val node3 = OddEvenLinkedListKotlin328.ListNode(3)
    val node4 = OddEvenLinkedListKotlin328.ListNode(4)
    val node5 = OddEvenLinkedListKotlin328.ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    val solution = OddEvenLinkedListKotlin328()
    var result = solution.oddEvenList(node1)

    while (result?.next != null) {
        println(result.`val`)
        result = result.next
    }
    println(result?.`val`)
}