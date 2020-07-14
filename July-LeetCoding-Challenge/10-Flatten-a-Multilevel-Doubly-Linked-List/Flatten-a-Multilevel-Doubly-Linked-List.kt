package list_array

class FlattenaMultilevelDoublyLinkedListKotlin430 {
    fun flatten(root: Node?): Node? {
        var current = root
        while (current != null) {
            current.child?.let {
                val flatten = current!!
                val next = flatten.next
                var lastChild = it
                while (lastChild.next != null) {
                    lastChild = lastChild.next!!
                }
                flatten.next = it
                it.prev = flatten
                flatten.child = null
                lastChild.next = next
                next?.let { n -> n.prev = lastChild }
            }
            current = current.next
        }
        return root
    }
    /*
    fun flatten(root: Node?): Node? {
        if (root == null) {
            return root
        }
        dfs(root)
        return root
    }

    private fun dfs(root: Node): Node {
        var current = root
        /*
        1 -> 2  -> 3
             ->4 -> 5

         current = 2
         nextNode = 3
         2.next = 4
         4.prev = 2

         result = 5
         3.pre = 5
         5.next = 3

         2.child = null
         current = 5
         */
        current.child?.let {
            val nextNode = current.next
            current.next = it
            it.prev = current
            val result = dfs(it)
            nextNode?.prev = result
            result.next = nextNode
            current.child = null
            current = result
        }
        while (current.next != null) {
            current = current.next!!
            current.child?.let {
                val nextNode = current.next
                current.next = it
                it.prev = current
                val result = dfs(it)
                nextNode?.prev = result
                result.next = nextNode
                current.child = null
                current = result
            }
        }
        return current
    }

     */

    class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null
    }
}

fun main() {
    val node1 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(1)
    val node2 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(2)
    val node3 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(3)
    val node4 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(4)
    val node5 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(5)
    val node6 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(6)
    val node7 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(7)
    val node8 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(8)
    val node9 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(9)
    val node10 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(10)
    val node11 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(11)
    val node12 = FlattenaMultilevelDoublyLinkedListKotlin430.Node(12)
    node1.next = node2
    node2.prev = node1

    node2.next = node3
    node3.prev = node2

    node3.next = node4
    node4.prev = node3

    node4.next = node5
    node5.prev = node4

    node5.next = node6
    node6.prev = node5

    node3.child = node7

    node7.next = node8
    node8.prev = node7

    node8.next = node9
    node9.prev = node8

    node9.next = node10
    node10.prev = node9

    node8.child = node11

    node11.next = node12
    node12.prev = node11

    val solution = FlattenaMultilevelDoublyLinkedListKotlin430()
    val result = solution.flatten(node1)
    println(result)
}