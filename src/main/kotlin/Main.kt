import java.awt.HeadlessException
import java.awt.Insets
import kotlin.math.ceil

fun main() {
    var head = createLinkedList()
//    traverseList(head)
//    insertAtPosition(4, Node("Mary"), head)
//    head = insertAtHead(Node("Bubble"), head)
//    traverseList(head)
//    removeAtPosition(5, head)
//    insertAfterNode("Elizabeth", Node("Fay"), head)
//    traverseList(head)
//    val mid  = findMiddleNode(head)
//    println(mid.name)
//val middle2 = findMiddle(head)
//    println(middle2.name)

//    val kth = findKthNodeFromEnd(6,head)
//    println(kth.name)
//
//    val circle = findFirstNodeInCircle(head)
//    println(circle?.name)

    val getCircle = floydCircle(head)
    println(getCircle?.name)
}

class Node(var name: String) {
    var next: Node? = null
}

fun createLinkedList(): Node {
    val node1 = Node("Susan")
    val node2 = Node("Eunice")
    val node3 = Node("Juliet")
    val node4 = Node("Joy")
    val node5 = Node("Vallary")
    val node6 = Node("Elizabeth")
    val node7 = Node("Joyeuse")

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node4  //circular list

    return node1
}

fun traverseList(head: Node) {
    var current: Node? = head
    while (current != null) {
        println(current.name)
        current = current.next
    }
}

fun insertAtPosition(pos: Int, nodeToInsert: Node, head: Node) {
    var counter = 1
    var current: Node? = head
    while (counter < pos - 1) {
        current = current?.next
        counter++
    }
    nodeToInsert.next = current?.next
    current?.next = nodeToInsert
}

fun insertAfterNode(name: String, nodeToInsert: Node, head: Node): Node {
    var current: Node? = head
    while (current!!.name != name) {
        current = current.next
    }
    nodeToInsert.next = current.next
    current.next = nodeToInsert
    return nodeToInsert
}

fun insertAtHead(nodeToInsert: Node, head: Node): Node {
    nodeToInsert.next = head
    return nodeToInsert
}

fun removeAtPosition(pos: Int, head: Node) {
    var counter = 1
    var current: Node? = head
    while (counter < pos - 1) {
        current = current?.next
        counter++
    }
    current?.next = current?.next?.next
}
fun findMiddleNode(head: Node): Node{
    var current: Node? = head
    var counter = 1
    while (current != null){
        current = current.next
        counter++
    }

    var middle = ceil(counter/2.0).toInt()

    current = head
    counter = 1
    while (counter < middle){
        current = current?.next
        counter++
    }
    return current!!
}

//better written code to find middle node

fun findMiddle (head: Node):Node{
    var fast: Node? = head
    var slow: Node? = head

    while (fast?.next != null){
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow!!
}

fun findKthNodeFromEnd (k: Int, head: Node): Node{
    var fast: Node? = head
    var slow : Node? = head
    var counter = 1

    while (counter < k){
        fast = fast?.next
        counter++
    }

    while (fast?.next != null){
        fast = fast?.next
        slow = slow?.next
    }
    return slow!!
}

fun findFirstNodeInCircle(head:Node): Node?{
    var visited = mutableListOf<Node>()
    var current: Node? = head

    while (current != null){
        if (visited.contains(current)){
            return current
        }
        else{
            visited.add(current)
            current = current.next
        }
    }
    return null
}
//improved detection while using less memory to find which node starts the circle
fun floydCircle (head: Node):Node?{
    var fast: Node? = head
    var slow: Node? = head

    while (fast?.next != null){
        fast = fast.next?.next
        slow = slow?.next

        if (fast == slow){
            break
        }
    }
fast = head
    while (true){
        fast = fast?.next
        slow = slow?.next

        if (fast == slow){
            return fast  //or slow
        }
    }
}
