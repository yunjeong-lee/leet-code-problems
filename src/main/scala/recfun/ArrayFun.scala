package recfun

class ArrayFun {

	/**
	 * Find Min in Rotated Sorted Array (#153, Medium)
	 *
	 * Suppose an array sorted in ascending order is rotated
	 * at some pivot unknown to you beforehand.
	 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
	 * Find the minimum element.
	 * You may assume no duplicate exists in the array.
	 *
	 * Example 1:
	 * Input: [3,4,5,1,2]
	 * Output: 1
	 *
	 * Example 2:
	 * Input: [4,5,6,7,0,1,2]
	 * Output: 0
	 */

	def findMin(nums: Array[Int]): Int = {

		// If there is one element, then return the element
		if (nums.length == 1) {
			nums(0)
		} else {

			// Initialize the left and right pointers
			val len: Int = nums.length
			var lo: Int = 0
			var hi: Int = len - 1

			// If there is no rotation, return the first element
			if (nums(lo) < nums(hi)) {
				nums(lo)
			} else {

				while (lo + 1 < hi) {
					// Index for mid-point
					val mid: Int = lo + (hi - lo) / 2

					// If first elem < mid elem, look for inflection point on the right
					if (nums(lo) < nums(mid)) {
						lo = mid
					} else {
						// If first elem > mid elem, look for inflection point on the left
						hi = mid
					}
				}
				// When there are only 2 elems left, nums(hi) refers to the min
				nums(hi)
			}

		}
	}


	/**
	 * Find Min in Rotated Sorted Array II (#154, Hard)
	 *
	 * Suppose an array sorted in ascending order is rotated
	 * at some pivot unknown to you beforehand.
	 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
	 * Find the minimum element.
	 * The array may contain duplicates.
	 *
	 * Example 1:
	 * Input: [1,3,5]
	 * Output: 1
	 *
	 * Example 2:
	 * Input: [2,2,2,0,1]
	 * Output: 0
	 */

	def findMin2(nums: Array[Int]): Int = {

		// Keep two pointers, low and high
		var lo: Int = 0
		var hi: Int = nums.length - 1

		while (lo < hi) {
			// Index for mid-point
			val mid: Int = lo + (hi - lo) / 2

			// If mid elem < last elem, look for inflection point on the right
			if (nums(mid) < nums(hi)) hi = mid

			// If mid elem > last elem, look for inflection point on the left
			else if (nums(mid) > nums(hi)) lo = mid + 1

				// If mid elem == last elem, then reduce the search scope.
				// Note: moving the lower boundary (lo +=1) does not work for all cases.
			else hi -= 1
		}
		// When there are only 2 elems left, nums(lo) refers to the min
		nums(lo)
	}

	/* Question:
	 * Would allowing duplicates affect the run-time complexity? How and why?
	 *
	 * Answer:
	 * Without duplicates, we don't have to consider the case when nums(mid) == nums(hi).
	 * This renders the time complexity of the algorithm to be O(N) instead of O(log_2 N).
	 */


	/**
	 * Gas Station (#134, Medium)
	 *
	 * There are N gas stations along a circular route, where the amount of gas at station i
	 * is gas[i]. You have a car with an unlimited gas tank and it costs cost[i] of gas
	 * to travel from station i to its next station (i+1). You begin the journey with
	 * an empty tank at one of the gas stations.
	 *
	 * Return the starting gas station's index if you can travel around the circuit
	 * once in the clockwise direction, otherwise return -1.
	 *
	 * Note:
	 *
	 * If there exists a solution, it is guaranteed to be unique.
	 * Both input arrays are non-empty and have the same length.
	 * Each element in the input arrays is a non-negative integer.
	 *
	 * Example 1:
	 *
	 * Input:
	 * gas  = [1,2,3,4,5]
	 * cost = [3,4,5,1,2]
	 * Output: 3
	 */

	/*def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
	 	// Ideation in-progress
	}*/

}
