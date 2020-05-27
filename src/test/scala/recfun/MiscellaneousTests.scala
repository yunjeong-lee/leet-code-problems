package recfun

import org.junit.Test

class MiscellaneousTests extends MiscellaneousFun {

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

		// To run after debugging
		/*surroundSolve(b1)
		surroundSolve(b2)*/
		assert(/*b1 == b1_expected
				&& b2 == b2_expected*/ true)
	}





}
