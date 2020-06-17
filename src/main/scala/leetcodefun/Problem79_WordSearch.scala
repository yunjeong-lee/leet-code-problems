package leetcodefun

import scala.util.control.Breaks

class Problem79_WordSearch {

	/**
	 * Word Search (#79, Medium)
	 *
	 * Given a 2D board and a word, find if the word exists in the grid.
	 *
	 * The word can be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once.
	 *
	 * Example:
	 *
	 * board =
	 * [
	 * ['A','B','C','E'],
	 * ['S','F','C','S'],
	 * ['A','D','E','E']
	 * ]
	 *
	 * Given word = "ABCCED", return true.
	 * Given word = "SEE", return true.
	 * Given word = "ABCB", return false.
	 *
	 * Constraints:
	 *
	 * * board and word consists only of lowercase and uppercase English letters.
	 * * 1 <= board.length <= 200
	 * * 1 <= board[i].length <= 200
	 * * 1 <= word.length <= 10 ** 3
	 *
	 */

	def exist(board: Array[Array[Char]], word: String): Boolean = {

		val ROWS: Int = board.length
		val COLS: Int = board(0).length

		def backtrack(row: Int, col: Int, word: String, index: Int): Boolean = {

			// 1. Check the bottom case
			if (index >= word.length) { true }

			// 2. Check the boundaries
			else if (row < 0 || row == ROWS || col < 0 || col == COLS
				|| board(row)(col) != word.charAt(index)) { false }
			else {
				// 3. Explore the neighbors in DFS
				// Mark the path before exploration
				var res: Boolean = false
				board(row)(col) = '#'

				// Note: need to break out of the loop to prevent 'Memory Limit Exceeded'
				val loop = new Breaks

				val rowOffsets: Array[Int] = Array(0, 1, 0, -1)
				val colOffsets: Array[Int] = Array(1, 0, -1, 0)
				loop.breakable{
					for (d <- 0 until 4) {
						if (backtrack(row + rowOffsets(d), col + colOffsets(d),
							word, index + 1)) { res = true }
						if (res) { loop.break }
					}
				}

				// 4. Clean up and return the result
				board(row)(col) = word.charAt(index)
				res
			}
		}

		for (r <- 0 until ROWS;
				 c <- 0 until COLS) {
			if (backtrack(r, c, word, 0)) { return true }
		}
		false
	}


}
