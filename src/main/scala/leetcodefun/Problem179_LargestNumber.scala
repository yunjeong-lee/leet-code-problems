package leetcodefun

class Problem179_LargestNumber {

	/**
	 * Largest Number (#179, Medium)
	 *
	 * Given a list of non negative integers,
	 * arrange them such that they form the largest number.
	 *
	 * E.g.,
	 * Input [10, 2] -> "210"
	 * Input: [3,30,34,5,9] -> Output: "9534330"
	 *
	 * Note: The result may be very large,
	 * so you need to return a string instead of an integer.
	 */

	def largestNumber(nums: Array[Int]): String = {

		// Convert the Array[Int] to Array[String]
		val strings: Array[String] = Array.ofDim(nums.length)
		for (i <- 0 until nums.length) {
			strings(i) = nums(i).toString
		}

		// Define a new comparator
		def comparator(s1: String, s2: String): Boolean = {
			var res: Boolean = true
			if ((s1 + s2).compareTo(s2 + s1) < 0) {
				res = false
			}
			res
		}

		val sortedStr: Array[String] = strings.sortWith(comparator)

		// If the largest one, after sorting, is zero, the entire number is "0".
		if (sortedStr(0) == "0") {"0"}
		else {
			// Build largest number from sorted array
			var largestNumStr: String = new String()
			// append each string that is sorted according to the comparator
			for (numAsStr <- sortedStr) {
				largestNumStr = largestNumStr + numAsStr
			}
			largestNumStr
		}
	}

}
