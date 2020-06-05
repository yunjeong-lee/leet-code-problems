package leetcodefun

import org.junit.Test

import scala.util.Random

class Problem137_SingleNumberTests extends Problem137_SingleNumber {

	/** A random array of length 10, used for verifying singleNumber */

	def singleNumTester(n: Int): Boolean = {
		val n1: Int = Random.nextInt(n)
		val n2: Int = n1 + Random.nextInt(n) + 1 // +1 to make it differ
		val n3: Int = n2 + Random.nextInt(n) + 1 // +1 to make it differ
		val single: Int = n3 + Random.nextInt(n) + 1 // +1 to make it differ

		var arr: Array[Int] = new Array[Int](10)
		for (i <- 1 to 3) {
			arr(i) = n1
			arr(i+3) = n2
			arr(i+6) = n3
		}
		arr(0) = single
		singleNumber(arr) == single
	}

	@Test def `single number II test`: Unit = {

		val num_arr1 : Array[Int] = Array(2, 2, 3, 2)
		val num_arr2 : Array[Int] = Array(0, 1, 0, 1, 0, 1, 99)

		assert(singleNumber(num_arr1) == 3
				&& singleNumber(num_arr2) == 99
				&& singleNumTester(Random.nextInt(100)))
	}


}
