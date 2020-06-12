package leetcodefun
import leetcodefun.local_library._

import org.junit.Test

class Problem153_FindMinTests extends Problem153_FindMin {

	@Test def `find min in rotated sorted array test`: Unit = {

		val arr1: Array[Int] = Array(3, 4, 5, 1, 2)
		val arr2: Array[Int] = Array(4, 5, 6, 7, 0, 1, 2)
		/*val randArr: Array[Int] = genRandomIntArray(10):+0*/

		assert(findMin(arr1) == 1
				&& findMin(arr2) == 0
				/*&& findMin(randArr) == 0*/)
	}

}
