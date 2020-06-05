package leetcodefun

class Problem154_FindMinII {

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


}
