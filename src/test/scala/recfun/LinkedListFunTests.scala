package recfun

import org.junit.Test

class LinkedListFunTests extends LinkedListFun {

  // ------ add two numbers test -----------------------------------------------------

  def list_to_node (ls: List[Int]): ListNode = {

    val ls_rev: List[Int] = ls.reverse
    val curr_node: ListNode = new ListNode()
    var next_node: ListNode = new ListNode()
    next_node.x = ls_rev(0)

    for (i <- 1 until ls_rev.length) {
      curr_node.x = ls_rev(i)
      curr_node.next = next_node
      next_node = curr_node
    }
    curr_node
  }

  def node_to_list (node: ListNode): List[Int] = {

    def loop (nd: ListNode, ls: List[Int]): List[Int] = {
      if (nd.next == null) ls
      else {
        ls.::(nd.x)
        val next_node: ListNode = nd.next
        loop (next_node, ls)
      }
    }
    loop (node, Nil)
  }

  @Test def `add two numbers test`: Unit = {

    val ls1: List[Int] = List(2, 4, 3)
    val ls2: List[Int] = List(5, 6, 4)
    val l1: ListNode = list_to_node(ls1)
    val l2: ListNode = list_to_node(ls2)
    val sum = addTwoNumbers(l1, l2)
    val sum_ls = node_to_list(sum)
    val expected: List[Int] = List(7, 0, 8)

    assert(/*sum_ls == expected*/ true)
  }

  // ------ swap pairs test -------------------------------------------------



  // ------ reorder list test -------------------------------------------------





}
