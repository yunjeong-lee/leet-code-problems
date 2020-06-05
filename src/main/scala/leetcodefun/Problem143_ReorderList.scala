package leetcodefun

import scala.annotation.tailrec

class Problem143_ReorderList extends Problem2_AddTwoNumbers {

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
