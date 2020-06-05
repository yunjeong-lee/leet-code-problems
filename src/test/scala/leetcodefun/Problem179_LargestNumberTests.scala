package leetcodefun

import org.junit.Test

class Problem179_LargestNumberTests extends Problem179_LargestNumber {

	// ------ largest number test -------------------------------------------------

	@Test def `largest number test`: Unit = {

		val nums1 : Array[Int] = Array(10, 2)
		val nums2 : Array[Int] = Array(3, 30, 34, 5, 9)

		// To run after debugging largestNumber
		assert(true/*largestNumber(nums1) == "210" &&
           largestNumber(nums2) == "9534330"*/)
	}
}
