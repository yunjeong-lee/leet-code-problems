package leetcodefun

class Problem153_FindMin {

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


}
