package leetcodefun

import scala.collection.mutable

class Problem137_SingleNumber {

	/**
	 * Single Number II (#137, Medium)
	 *
	 * Given a non-empty array of integers,
	 * every element appears three times except for one,
	 * which appears exactly once. Find that single one.
	 */

	def singleNumber(nums: Array[Int]): Int = {

		// Create a hashmap
		val hashmap: mutable.HashMap[Int, Int] = new mutable.HashMap[Int, Int]()

		// Create result int variable
		var res: Int = -1

		// Iterate over the input array to count the frequency of each number
		for (n <- nums) {
			hashmap.put(n, hashmap.getOrElse(n, 0) + 1)
		}

		// Return an element with frequency 1
		for (k <- hashmap.keySet) {
			if (hashmap.get(k) == Some(1)) {res = k}
		}

		res
	}

	/* Question to go over:
	 * The algorithm above should have a linear runtime complexity.
   * Could you implement it without using extra memory?
   * */

}
