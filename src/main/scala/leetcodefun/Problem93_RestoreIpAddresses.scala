package leetcodefun

import scala.collection.mutable.ListBuffer

class Problem93_RestoreIpAddresses {

	/**
	 * Restore IP Addresses (#93, Medium)
	 *
	 * Given a string containing only digits, restore it by returning
	 * all possible valid IP address combinations.
	 *
	 * A valid IP address consists of exactly four integers
	 * (each integer is between 0 and 255) separated by single points.
	 *
	 * Example:
	 *
	 * Input: "25525511135"
	 * Output: ["255.255.11.135", "255.255.111.35"]
	 */

	/** Comment:
	 * Debugging is in-progress -> currently causing the NullPointerException */

	def restoreIpAddresses(s: String): List[String] = {

		var n: Int = 0
		var s: String = null
		var segments: ListBuffer[String] = new ListBuffer[String]()
		var output: ListBuffer[String] = new ListBuffer[String]()

		// Check if the segment is valid (backtracking logic)
		// 1. The segment should be <= 255
		// 2. The first character can be '0' only if the segment is equal to '0'
		def valid(segment: String): Boolean = {
			val len: Int = segment.length
			if (3 < len) {
				false
			}
			if (segment.charAt(0) != '0') {
				segment.toInt <= 255
			} else {
				len == 1 // when the first character is '0'
			}
		}

		// Update output by adding the solution (list of segments) to output (list of solutions)
		def update_output(curr_pos: Int): Unit = {
			val segment: String = s.substring(curr_pos + 1, n) // segment til the end of s
			if (valid(segment)) {
				segments.addOne(segment)
				val seg_to_add: String = segments.mkString(".")
				output.addOne(seg_to_add)
				// After adding seg_to_add to segments, remove the last placed dot.. => !?!
				segments.remove(segments.length - 1, 1)
			}
		}

		// Backtrack
		// prev_pos: position of the previously placed dot
		// dots: number of dots to place
		def backtrack(prev_pos: Int, dots: Int): Unit = {
			// Farthest position you can go
			// I.e., the current dot curr_pos can be placed in a range from
			//       prev_pos + 1 to prev_pos + 4, so min of that and the len - 1
			val max_pos: Int = Math.min(n - 1, prev_pos + 4)

			for (curr_pos <- prev_pos + 1 until max_pos) {
				val segment: String = s.substring(prev_pos + 1, curr_pos + 1)
				if (valid(segment)) {
					// Place the dot
					segments.addOne(segment)
					if (dots - 1 == 0) {
						// Add solution to the output
						update_output(curr_pos)
					} else {
						// Continue to place the dots
						backtrack(curr_pos, dots - 1)
					}
					// Remove the last placed dot..
					// => Question: when, during the process, was an additional dot placed?!
					segments.remove(segments.length - 1, 1)
				}
			}
		}

		n = s.length
		backtrack(-1, 3)
		// Question: isn't the number of dots not supposed to set, but
		// rather proportional to length of string?!
		output.toList
	}



}
