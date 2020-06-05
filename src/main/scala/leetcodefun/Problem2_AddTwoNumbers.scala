package leetcodefun

class Problem2_AddTwoNumbers {

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



}
