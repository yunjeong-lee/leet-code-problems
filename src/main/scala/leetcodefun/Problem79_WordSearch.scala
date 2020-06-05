package leetcodefun

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

	/*def exist(board: Array[Array[Char]], word: String): Boolean = {

		// 1. Find where the 1st character of the word is located in the board,
		//    and collect them in a list

		val init_char: Char = word.charAt(0)
		val init_ls: List[(Int, Int)] = Nil

		for (i <- 0 until board.length - 1;
				 j <- 0 until board.length - 1) {
			while (board(i)(j) == init_char) {
				init_ls.::(i, j)
			}
		}
		init_ls

	}*/


}
