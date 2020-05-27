package recfun

import scala.annotation.tailrec

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var x: Int = _x
  var next: ListNode = _next
}

object ListNode {
  def unapply(node: ListNode): Option[Int] = Some(node.x)
}

class LinkedListFun {

  /**
   * Add Two Numbers (#2, Medium)
   *
   * Given two non-empty linked lists representing two non-negative integers,
   * the digits are stored in reverse order and each of their nodes contain
   * a single digit. Add the two numbers and return it as a linked list.
   *
   * You may assume the two numbers do not contain any leading zero, except
   * the number 0 itself.
   */

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var dummyHead : ListNode = new ListNode()
    var p: ListNode = l1
    var q: ListNode = l2
    var curr: ListNode = dummyHead
    var carry:Int = 0

    while (p != null || q != null) {
      val x = if (p != null) p.x
      else 0
      val y = if (q != null) q.x
      else 0
      val sum = carry + x + y
      carry = sum / 10
      curr.next = new ListNode(sum % 10) // sum modulo 10
      curr = curr.next

      if (p != null) p = p.next
      if (q != null) q = q.next
    }
    if (0 < carry) {
      curr.next = new ListNode(carry)
    }
    dummyHead.next
  }

  /**
   * Swap Nodes in Pairs (#24, Medium)
   * (using class ListNode from Problem 3 above)
   *
   * Given a linked list, swap every two adjacent nodes and return its head.
   *
   * Note:
   * Do not modify the values in the list's nodes,
   * only nodes itself may be changed.
   */

  def swapPairs(head: ListNode): ListNode = {

    // No node in the list, or only one node left -> return itself
    if ((head == null) || (head.next == null)) head

    // Nodes to be swapped
    val Node1: ListNode = head
    val Node2: ListNode = head.next

    // Swap them
    Node1.next = swapPairs(Node2.next)
    Node2.next = Node1

    // Return the new head, which is Node2
    Node2
  }

  /**
   * Reorder List (#143, Medium)
   * (using class ListNode from Problem 3 above)
   *
   * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
   * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
   *
   * Note:
   * Do not modify the values in the list's nodes,
   * only nodes itself may be changed.
   */

  def reorderList(head: ListNode): Unit = {
    def cut(cur: ListNode, count: Int = 0): Tuple2[ListNode, Int] = cur match {
      case ListNode(_) => {
        val res = cut(cur.next, count + 1)
        if (count == res._2 / 2 + (res._2 % 2) - 1) {
          val temp = cur.next
          cur.next = null
          Tuple2(temp, res._2)
        }
        else res
      }
      case null => Tuple2(null, count)
      case _ => throw new Exception("")
    }

    //(next, result)
    def reverseList(node: ListNode): Tuple2[ListNode, ListNode] = {
      if (node == null) (null, null)
      else if (node.next != null) {
        val res = reverseList(node.next)
        res._1.next = node; node.next = null;
        (node, res._2)
      }
      else (node, node)
    }

    @tailrec def merge(node1: ListNode, node2: ListNode): Unit = {
      val temp1 = node1.next
      val temp2 = if (node2 != null) node2.next else null

      node1.next = node2
      node2.next = temp1

      if (temp2 != null) merge(temp1, temp2)
    }

    if (head != null && head.next != null) merge(head, reverseList(cut(head)._1)._2)

  }

}
