package list_array

class RemoveLinkedListElementsKotlin203 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return null
        }
        if (head.`val` == `val`) {
            return removeElements(head.next, `val`)
        }
        head.next = removeElements(head.next, `val`)
        return head
    }
    /*
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var current: ListNode? = head ?: return head
        while (current != null && current.`val` == `val`) {
            current = current.next
        }
        val result = current
        var previous = current
        current = current?.next
        while (current != null) {
            if (current.`val` == `val`) {
                while (current != null && current.`val` == `val`) {
                    current = current.next
                }
                previous!!.next = current
            }
            previous = current
            current = current?.next
        }
        return result
    }
     */
}

fun main() {
    val solution = RemoveLinkedListElementsKotlin203()
    val l1 = RemoveLinkedListElementsKotlin203.ListNode(1)
    val l2 = RemoveLinkedListElementsKotlin203.ListNode(2)
    val l22 = RemoveLinkedListElementsKotlin203.ListNode(2)
    val l12 = RemoveLinkedListElementsKotlin203.ListNode(1)

    l1.next = l2
    l2.next = l22
    l22.next = l12

    val result = solution.removeElements(l1, 2)
    println(result)
}