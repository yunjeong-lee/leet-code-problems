package leetcodefun

import leetcodefun.local_library._
import org.junit.Test

class Problem130_SurroundedRegionsTests extends Problem130_SurroundedRegions {

	// ------ surrounded regions test -----------------------------------------------------

	@Test def `surrounded regions test`: Unit = {

		val b1: Array[Array[Char]] =
			Array(
				Array('X', 'X', 'X', 'X'),
				Array('X', 'O', 'O', 'X'),
				Array('X', 'X', 'O', 'X'),
				Array('X', 'O', 'X', 'X')
			)
		val b2: Array[Array[Char]] =
			Array(
				Array('X', 'X', 'X', 'X'),
				Array('X', 'O', 'O', 'X'),
				Array('X', 'X', 'O', 'O'),
				Array('X', 'O', 'X', 'X')
			)
		val b1_expected: Array[Array[Char]] =
			Array(
				Array('X', 'X', 'X', 'X'),
				Array('X', 'X', 'X', 'X'),
				Array('X', 'X', 'X', 'X'),
				Array('X', 'O', 'X', 'X')
			)
		val b2_expected: Array[Array[Char]] =
			Array(
				Array('X', 'X', 'X', 'X'),
				Array('X', 'O', 'O', 'X'),
				Array('X', 'X', 'O', 'O'),
				Array('X', 'O', 'X', 'X')
			)

		solve(b1); solve(b2)
		assert(equal_CharArrArr(b1, b1_expected)
				&& equal_CharArrArr(b2, b2_expected))
	}





}
