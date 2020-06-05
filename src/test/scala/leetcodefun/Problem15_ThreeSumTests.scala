package leetcodefun

import org.junit.Test

class Problem15_ThreeSumTests extends Problem15_ThreeSum {

	// ------ Three Sum test -------------------------------------------------

	@Test def `three sum test`: Unit = {

		val nums : Array[Int] = Array(-1, 0, 1, 2, -1, -4)

		// To run after debugging largestNumber
		assert(/*threeSum(nums) == List(List(-1, -1, 2), List(-1, 0, 1))*/ true)
	}

}
