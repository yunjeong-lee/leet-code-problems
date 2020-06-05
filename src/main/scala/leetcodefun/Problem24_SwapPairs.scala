package leetcodefun

class Problem24_SwapPairs extends Problem2_AddTwoNumbers {

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


}
