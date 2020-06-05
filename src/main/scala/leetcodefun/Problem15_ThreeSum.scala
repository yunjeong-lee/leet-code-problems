package leetcodefun

import scala.collection.mutable

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

	/** Debugging the below function is in-progress.. */

	def threeSum(nums: Array[Int]): List[List[Int]] = {

		nums.sorted

		val triplets: mutable.HashSet[List[Int]] = new mutable.HashSet[List[Int]]()

		for (left <- 0 until nums.length - 2) {
			var mid: Int = left + 1
			var right: Int = nums.length - 1

			while (mid < right) {
				val sum: Int = nums(left) + nums(mid) + nums(right)

				if (sum < 0) {
					mid +=1; mid - 1
				} else if (sum > 0) {
					right -= 1; right + 1
				} else {
					val triplet: List[Int] = List(nums(left), nums(mid), nums(right))
					triplets.add(triplet)
					mid += 1; mid - 1
				}
			}
		}

		triplets.toList

	}

}
