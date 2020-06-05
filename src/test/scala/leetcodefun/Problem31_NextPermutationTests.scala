package leetcodefun

import org.junit.Test

class Problem31_NextPermutationTests extends Problem31_NextPermutation {

	// ------ permute II tests -------------------------------------------------

	@Test def `next permutations test`: Unit = {

		val arr1: Array[Int] = Array(1, 2, 3)
		val arr2: Array[Int] = Array(3, 2, 1)
		val arr3: Array[Int] = Array(1, 1, 5)

		nextPermutation(arr1)
		nextPermutation(arr2)
		nextPermutation(arr3)

		// Need to convert to List
		// Keeping Array[Int] will trigger assertion failure
		assert(arr1.toList == List(1, 3, 2) &&
			arr2.toList == List(1, 2, 3) &&
			arr3.toList == List(1, 5, 1))
	}

}
