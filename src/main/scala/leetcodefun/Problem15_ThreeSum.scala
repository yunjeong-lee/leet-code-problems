package leetcodefun

import scala.collection.mutable.HashSet

class Problem15_ThreeSum {

	/**
	 * 3Sum (#15, Medium)
	 *
	 * Given an array nums of n integers, are there elements
	 * a, b, c in nums such that a + b + c = 0?
	 * Find all unique triplets in the array which gives the sum of zero.
	 *
	 * Note:
	 * The solution set must not contain duplicate triplets.
	 *
	 * Example:
	 * Given array nums = [-1, 0, 1, 2, -1, -4],
	 *
	 * A solution set is:
	 * [
	 * [-1, 0, 1],
	 * [-1, -1, 2]
	 * ]
	 */

	def threeSum(nums: Array[Int]): List[List[Int]] = {

		// Sort the input array
		val nums_sorted = nums.sorted

		val res: HashSet[List[Int]] = new HashSet[List[Int]]()

		// Iterate through the input array
		for (i <- 0 until nums.length - 2) {
			// Set the low pointer to be i + 1, and high pointer to be the last index
			var lo: Int = i + 1
			var hi: Int = nums.length - 1

			while (lo < hi) {
				val sum: Int = nums_sorted(i) + nums_sorted(lo) + nums_sorted(hi)

				// If sum is less than 0, increment lo
				if (sum < 0) {
					// Also increment lo if the value is the same as for lo - 1
					lo +=1; lo - 1
				}
				// If sum is greater than 0, decrement hi
				else if (sum > 0) {
					// Also decrement hi if the value is the same as for hi + 1
					hi -= 1; hi + 1
				}
				// Otherwise, found a triplet and add it to the result
				else {
					val triplet: List[Int] = List(nums_sorted(i), nums_sorted(lo), nums_sorted(hi))
					res.add(triplet)
					// Increment lo and decrement hi
					lo += 1; hi -= 1
				}
			}
		}

		res.toList

	}

}
