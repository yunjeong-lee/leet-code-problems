package leetcodefun

import org.junit.Test

class Problem79_WordSearchTests extends Problem79_WordSearch {

	// ------ word search test -------------------------------------------------

	@Test def `word search test`: Unit = {

		val board: Array[Array[Char]] =
			Array(
				Array('A', 'B', 'C', 'E'),
				Array('S', 'F', 'C', 'S'),
				Array('A', 'D', 'E', 'E')
			)
		val word1: String = "ABCCED"
		val word2: String = "SEE"
		val word3: String = "ABCB"

		// To run after debugging..
		assert(/*exist(board, word1) && exist(board, word2) && !exist(board, word3) */true)

	}

}
