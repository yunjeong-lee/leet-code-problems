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

	/** Currently simply attaching numbers in a row...
	 *  comparator is not working properly */

	def largestNumber(nums: Array[Int]): String = {

		// Convert the Array[Int] to Array[String]
		val strings: Array[String] = Array.ofDim(nums.length)
		for (i <- 0 until nums.length) {
			strings(i) = (nums(i)).toString
		}

		// Define a new comparator
		def comparator(s1: String, s2: String): Boolean = {
			val order12: String = s1 + s2
			val order21: String = s2 + s1
			order21.compareTo(order12) >= 0 // note: compareTo method
		}

		// Sort strings according to the comparator
		strings.sortWith(comparator)

		// If the largest one, after sorting, is zero, the entire number is "0".
		if (strings(0) == ("0")) {"0"}

		// Build largest number from sorted array
		var largestNumStr: String = new String()
		for (numAsStr <- strings) {
			largestNumStr += numAsStr
		}
		largestNumStr
	}

}
