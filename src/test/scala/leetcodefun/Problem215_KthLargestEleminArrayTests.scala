package leetcodefun

import org.junit.Test

class Problem215_KthLargestEleminArrayTests extends Problem215_KthLargestEleminArray {

	// ------ Kth largest element in an array test -----------------------------------------------------

	@Test def `Kth largest element in an array test`: Unit = {

		val arr1: Array[Int] = Array(3,2,1,5,6,4); val k1: Int = 2
		val arr2: Array[Int] = Array(3,2,3,1,2,4,5,5,6); val k2: Int = 4

		assert(findKthLargest(arr1, k1) == 5
				&& findKthLargest(arr2, k2) == 4)
	}


}
