package leetcodefun

import org.junit.Test

class Problem15_ThreeSumTests extends Problem15_ThreeSum {

	@Test def `three sum test`: Unit = {

		val nums1 : Array[Int] = Array(-1, 0, 1, 2, -1, -4)

		// Check whether the lists being compared have same elements
		// (they are not necessarily in the same order)
		assert(threeSum(nums1).toSet == List(List(-1, -1, 2), List(-1, 0, 1)).toSet)
	}

}
