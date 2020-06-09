package leetcodefun

import scala.collection.mutable
import scala.util.Random
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

package object local_library {

	/** Random string generator : a string of lower-case alphabets
	 * (relevant problem: 3) */

	def genRandomString(length: Int): String = {
		val arr = new Array[Char](length)

		val lo = 97 	// lowercase 'a'
		val hi = 122	// lowercase 'z'
		for (i <- 0 to length - 1) {
			arr(i) = (Random.nextInt(hi - lo) + lo).toChar
		}
		arr.mkString
	}


	/** Random Int array generator : a sorted array of random integers with repeating numbers
	 * (relevant problem: 154) */

	def genRandomIntArray(length: Int): Array[Int] = {
		var res: Array[Int] = new Array[Int](length)
		val n: Int = length * 2

		for (i <- 0 until length) {
			val elem = 1 + Random.nextInt(n)
			res(i) = elem
		}
		res.sortWith(_ <= _)
	}


	/** Random Int array generator : a sorted array random integers without repeating integers
	 * (relevant problem: 153, 322) */

	def genRandomIntArray2(length: Int): Array[Int] = {
		val created: mutable.HashSet[Int] = new mutable.HashSet[Int]()
		var res: Array[Int] = new Array[Int](length)
		val n: Int = length * 2

		for (i <- 0 until length) {
			val elem = 1 + Random.nextInt(n)
			if (created.exists(x => x != elem)) {
				res(i) = elem; created.add(elem)
			} else {
				res(i) = elem + Random.nextInt(n) + 1 // Hmm.. this is not sufficient!
			}
		}
		res.sortWith(_ < _)
	}


	/**  Converting ListNode to List[Int] and vice versa
	 * (relevant problems: 2, 43, 143) */

	def list_to_node (ls: List[Int]): ListNode = {
		var ls_rev: List[Int] = ls.reverse
		var curr_node: ListNode = new ListNode()
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


	/** Scalacheck examples */

	// strGen generates a fixed length random string
	val strGen = (n: Int) => Gen.listOfN(n, Gen.alphaChar).map(_.mkString)

	val fixedLengthStr = forAll(strGen(10)){ s =>
		s.length == 10
	}



}


/** Definition of ListNode (relevant problems: 2, 24, 143) */

class ListNode(_x: Int = 0, _next: ListNode = null) {
	var x: Int = _x
	var next: ListNode = _next
}

object ListNode {
	def unapply(node: ListNode): Option[Int] = Some(node.x)
}

/** Definition of a binary tree node (relevant problems: 95, 96) */

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}

