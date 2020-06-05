package leetcodefun

// Defined a new object 'Index' for the 'Jump Game' problem
// to enumerate a group of named constants for state
object Index extends Enumeration {
	val GOOD: Index = new Index()
	val BAD: Index = new Index()
	val UNKNOWN: Index = new Index()
	class Index extends Val
	// Implicit conversion : omit calling methods or referencing variables directly
	// but instead rely on the compiler to make the connections
	implicit def convertValue(v: Value): Index = v.asInstanceOf[Index] // Note 'asInstanceOf' method!

}

class Problem55_JumpGame {

	/**
	 * Jump Game (#55, Medium)
	 *
	 * Given an array of non-negative integers, you are initially positioned
	 * at the first index of the array. Each element in the array represents
	 * your maximum jump length at that position.
	 *
	 * Determine if you are able to reach the last index.
	 *
	 * Example 1:
	 * * Input: nums = [2,3,1,1,4]
	 * * Output: true
	 *
	 * Example 2:
	 * Input: nums = [3,2,1,0,4]
	 * Output: false
	 *
	 * Constraints:
	 * 1 <= nums.length <= 3 * 10^4
	 * 0 <= nums[i][j] <= 10^5
	 */

	// Sub-optimal backtracking approach
	def canJump0(nums: Array[Int]): Boolean = {

		def canJumpFromPosition(position: Int, nums: Array[Int]): Boolean = {
			if (position == nums.length - 1) true
			else {
				// Furthest jump that can be made, and the next position
				val furthestJump: Int = Math.min(position + nums(position), nums.length - 1)
				var nextPosition: Int = position + 1
				var reachability: Boolean = false

				while (nextPosition <= furthestJump) {
					// If the last position can be reached from nextPositions, return true
					if (canJumpFromPosition(nextPosition, nums)) {reachability = true}
					nextPosition += 1
				}
				reachability
			}
		}

		canJumpFromPosition(0, nums)
	}


	// More optimal approach (top-down dynamic programming version)
	def canJump1(nums: Array[Int]): Boolean = {

		var memo: Array[Index.Index] = Array()
		memo = Array.ofDim[Index.Index](nums.length)

		// Set all to be UNKNOWN at first
		for (i <- 0 until memo.length) {
			memo(i) = Index.UNKNOWN
		}
		// Set the last one to be GOOD
		memo(memo.length - 1) = Index.GOOD

		def canJumpFromPosition(position: Int, nums: Array[Int]): Boolean = {
			if (memo(position) != Index.UNKNOWN) {
				if (memo(position) == Index.GOOD) true
				else false
			} else { // when it is UNKNOWN
				val furthestJump: Int = Math.min(position + nums(position), nums.length - 1)
				var nextPosition: Int = position + 1
				var reachability: Boolean = false

				while(nextPosition <= furthestJump) {
					if (canJumpFromPosition(nextPosition, nums)) {
						memo(position) = Index.GOOD
						reachability = true
					}
					nextPosition += 1
				}
				memo(position) = Index.BAD
				reachability
			}
		}

		canJumpFromPosition(0, nums)
	}

}
