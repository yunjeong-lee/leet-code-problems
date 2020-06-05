package leetcodefun

import org.junit.Test

class Problem50_PowTests extends Problem50_Pow {

	// ------ power function test -------------------------------------------------

	@Test def `power function test`: Unit = {

		val x1: Double = 2; val n1: Int = 10
		val x2: Double = 2.1; val n2: Int = 3
		val x3: Double = 2; val n3: Int = -2

		// Define "~=" (i.e., approximately equal to)
		def ~=(x: Double, y: Double, precision: Double) = {
			if ((x - y).abs < precision) true else false
		}

		assert(~=(myPow(x1, n1), 1024.00, 0.0001)
			&& ~=(myPow(x2, n2), 9.26100, 0.0001)
			&& ~=(myPow(x3, n3), 0.25000, 0.0001))
	}

}
