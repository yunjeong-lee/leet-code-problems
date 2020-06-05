package leetcodefun

import org.junit.Test

class Problem166_FractionToDecimalTests extends Problem166_FractionToDecimal {

	// Notes :
	// Be wary of edge cases!
	// List out as many test cases as you can think of and test your code thoroughly.

	@Test def `fraction to decimal test`: Unit = {

		// ------ simple tests -------------------------------------------------
		val numerator1: Int = 1; val denominator1: Int = 2
		val numerator2: Int = 2; val denominator2: Int = 1
		val numerator3: Int = 2; val denominator3: Int = 3

		assert(true/*fractionToDecimal(numerator1, denominator1) == "0.5"
        && fractionToDecimal(numerator2, denominator2) == "2"
        && fractionToDecimal(numerator3, denominator3) == "0.(6)"*/)
	}
}
