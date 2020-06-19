class DeleteNodeinaLinkedListKotlin237 {
    fun deleteNode(node: ListNode?) {
        val next = node!!.next!!
        node.`val` = next.`val`
        node.next = next.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}