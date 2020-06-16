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

	def restoreIpAddresses(s: String): List[String] = {
		var n: Int = 0
		var str: String = null
		val segments: ListBuffer[String] = new ListBuffer[String]()
		val output: ListBuffer[String] = new ListBuffer[String]()

		// Check if the segment is valid (backtracking logic)
		// 1. The segment should be <= 255
		// 2. The first character can be '0' only if the segment is equal to '0'
		def valid(segment: String): Boolean = {
			val len: Int = segment.length
			if (3 < len || segment.toInt > 255) { false }
			// when the first character is '0', then segment is equal to '0'
			else if (segment.charAt(0) == '0' && len != 1) { false }
			else { true }
		}

		// Update output by adding the solution (list of segments) to output (list of solutions)
		def update_output(curr_pos: Int): Unit = {
			val segment: String = str.substring(curr_pos + 1, n) // segment til the end of s
			if (valid(segment)) {
				segments.addOne(segment)
				val seg_to_add: String = segments.mkString(".")
				output.addOne(seg_to_add)
				// After adding seg_to_add to segments, remove the last placed dot
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
				val segment: String = str.substring(prev_pos + 1, curr_pos + 1)
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
					segments.remove(segments.length - 1, 1)
				}
			}
		}

		str= s
		n = s.length
		backtrack(-1, 3)
		output.toList
	}



}
