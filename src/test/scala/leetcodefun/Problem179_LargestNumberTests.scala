package leetcodefun

import org.junit.Test

class Problem179_LargestNumberTests extends Problem179_LargestNumber {

	// ------ largest number test -------------------------------------------------

	@Test def `largest number test`: Unit = {

		val nums1: Array[Int] = Array(10, 2)
		val nums2: Array[Int] = Array(3, 30, 34, 5, 9)
		val nums3: Array[Int] = Array(1, 20)
		val nums4: Array[Int] = Array(0, 9, 8, 7, 6, 5, 4, 3, 2, 1)

		assert(largestNumber(nums1) == "210"
			&& largestNumber(nums2) == "9534330"
			&& largestNumber(nums3) == "201"
			&& largestNumber(nums4) == "9876543210")
	}
}
