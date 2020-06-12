package leetcodefun
import leetcodefun.local_library.genRandomIntArray

import org.junit.Test

class Problem154_FindMinIITests extends Problem154_FindMinII {

	@Test def `find min in rotated sorted array II test`: Unit = {

		val arr1: Array[Int] = Array(1, 3, 5)
		val arr2: Array[Int] = Array(2, 2, 2, 0, 1)
		val randArr: Array[Int] = genRandomIntArray(100)
		/*val randArr2: Array[Int] = randArr:+0*/

		assert(findMin2(arr1) == 1
				&& findMin2(arr2) == 0
				&& findMin2(randArr) != 101
				/*&& findMin2(randArr2) == 0*/)
	}


}
