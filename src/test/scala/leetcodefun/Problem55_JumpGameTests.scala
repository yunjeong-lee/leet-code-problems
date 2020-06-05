package leetcodefun

import org.junit.Test

class Problem55_JumpGameTests extends Problem55_JumpGame {

	// ------ canJump tests -------------------------------------------------

	@Test def `can jump test`: Unit = {

		val nums1: Array[Int] = Array(2, 3, 1, 1, 4)
		val nums2: Array[Int] = Array(3, 2, 1, 0, 4)

		assert(canJump0(nums1) && !canJump0(nums2)
			&& canJump1(nums1) && !canJump1(nums2))
	}

}
