package leetcodefun

import org.junit.Test

class Problem79_WordSearchTests extends Problem79_WordSearch {

	// ------ word search test -------------------------------------------------

	@Test def `word search test`: Unit = {

		val board1: Array[Array[Char]] =
			Array(
				Array('A', 'B', 'C', 'E'),
				Array('S', 'F', 'C', 'S'),
				Array('A', 'D', 'E', 'E')
			)
		val word11: String = "ABCCED"
		val word12: String = "SEE"
		val word13: String = "ABCB"

		val board2: Array[Array[Char]] =
			Array(Array('A', 'A'))
		val word21: String = "AAA"
		val word22: String = "AA"

		assert(exist(board1, word11)
			&& exist(board1, word12)
			&& !exist(board1, word13)
			&& !exist(board2, word21)
			&& exist(board2, word22))

	}

}
