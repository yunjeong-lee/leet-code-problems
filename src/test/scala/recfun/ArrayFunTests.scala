package recfun

import org.junit.Test

class ArrayFunTests extends ArrayFun {

	// ------ find min in rotated sorted array test -----------------------------------------------------

	@Test def `find min in rotated sorted array test`: Unit = {

		val arr1: Array[Int] = Array(3, 4, 5, 1, 2)
		val arr2: Array[Int] = Array(4, 5, 6, 7, 0, 1, 2)
		assert(findMin(arr1) == 1
			  && findMin(arr2) == 0)
	}

	// ------ find min in rotated sorted array II test -----------------------------------------------------

	@Test def `find min in rotated sorted array II test`: Unit = {

		val arr1: Array[Int] = Array(1, 3, 5)
		val arr2: Array[Int] = Array(2, 2, 2, 0, 1)
		assert(findMin2(arr1) == 1
			  && findMin2(arr2) == 0)
	}

	// ------ Kth largest element in an array test -----------------------------------------------------

	@Test def `Kth largest element in an array test`: Unit = {

		val arr1: Array[Int] = Array(1, 3, 5)
		val arr2: Array[Int] = Array(2, 2, 2, 0, 1)
		assert(true)
	}
}
