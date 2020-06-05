package leetcodefun

class Problem31_NextPermutation {

	/**
	 * Next Permutation (#31, Medium)
	 * Implement next permutation, which rearranges numbers into
	 * the lexicographically next greater permutation of numbers.
	 *
	 * If such arrangement is not possible, it must rearrange it
	 * as the lowest possible order (ie, sorted in ascending order).
	 *
	 * The replacement must be in-place and use only constant extra memory.
	 *
	 * Here are some examples. Inputs are in the left-hand column and
	 * its corresponding outputs are in the right-hand column.
	 *
	 * 1,2,3 → 1,3,2
	 * 3,2,1 → 1,2,3
	 * 1,1,5 → 1,5,1
	 */

	def nextPermutation(nums: Array[Int]): Unit = {

		nextPermute(nums)

		// Helper functions - Swap
		def swap(nums: Array[Int], i: Int, j: Int): Unit = {
			val temp: Int = nums(i)
			nums(i) = nums(j)
			nums(j) = temp
		}

		// Helper functions - Reverse
		def reverse(nums: Array[Int], start: Int): Unit = {
			var i: Int = start
			var j: Int = nums.length - 1
			while (i < j) {
				swap(nums, i, j)
				i += 1; i - 1
				j -= 1; j + 1
			}
		}

		def nextPermute(nums: Array[Int]): Unit = {

			var i: Int = nums.length - 2
			while (0 <= i && nums(i + 1) <= nums(i)) {
				i -= 1; i + 1
			}

			if (i >= 0) {
				var j: Int = nums.length - 1

				// Find first pair of two successive numbers nums(i) nums(i - 1), from the right,
				// which satisfy nums(i) > nums(j)

				// Find the first decreasing element
				while (0 <= j && nums(j) <= nums(i)) {
					j -= 1; j + 1
				}
				// Swap the element with number just larger than the element
				swap(nums, i, j)
			}
			// Reverse the elements from index (i + 1)
			reverse(nums, i + 1)
		}

	}



}
