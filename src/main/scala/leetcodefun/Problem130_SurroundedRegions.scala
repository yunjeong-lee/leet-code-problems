package leetcodefun

import scala.collection.mutable.ListBuffer

class Problem130_SurroundedRegions {

	/**
	 * Surrounded Regions (#130, Medium)
	 *
	 * Given a 2D board containing 'X' and 'O' (the letter O),
	 * capture all regions surrounded by 'X'. A region is captured
	 * by flipping all 'O's into 'X's in that surrounded region.
	 *
	 * Example:
	 * X X X X
	 * X O O X
	 * X X O X
	 * X O X X
	 *
	 * After running your function, the board should be:
	 * X X X X
	 * X X X X
	 * X X X X
	 * X O X X
	 *
	 * Explanation:
	 * Surrounded regions shouldn’t be on the border, which means
	 * that any 'O' on the border of the board are not flipped to 'X'.
	 * Any 'O' that is not on the border and it is not connected to an 'O'
	 * on the border will be flipped to 'X'. Two cells are connected
	 * if they are adjacent cells connected horizontally or vertically.
	 */

	/** Debugging in-progress : Not sure why the following does not pass the test...
	 * There is a stack-overflow problem...! */
	def surroundSolve(board: Array[Array[Char]]): Unit = {

		// If all the elements are on the border, then do nothing
		if (board.length <= 2) ()
		else if (board(0).length <= 2) ()
		else {

			val ROWS = board.length
			val COLS = board(0).length

			// Collect the border cells that are 'O's into 'borders'
			val borders: ListBuffer[(Int, Int)] = new ListBuffer[(Int, Int)]()
			for (r <- 0 until ROWS) {
				if (board(r)(0) == 'O') borders.addOne((r, 0));
				if (board(r)(COLS - 1) == 'O') borders.addOne((r, COLS - 1))
			}
			for (c <- 0 until COLS) {
				if (board(0)(c) == 'O') borders.addOne((0, c));
				if (board(ROWS-1)(c) == 'O') borders.addOne((ROWS - 1, c))
			}

			// Mark the cells that can be escaped as 'E'
			for (pair <- borders.toList) {
				DFS_markE(board, pair._1, pair._2)
			}

			// Traverse the entire board and mark escaped ones back to 'O'
			// and the 'O' cells that could not be escaped to 'X'
			for (r <- 0 until ROWS; c <- 0 until COLS) {
				if (board(r)(c) == 'O') board(r)(c) = 'X'
				if (board(r)(c) == 'E') board(r)(c) = 'O'
			}

			// Starting from the border cells, mark the ones that can be escaped
			def DFS_markE(board: Array[Array[Char]], row: Int, col: Int): Unit = {
				if (board(row)(col) == 'O') { board(row)(col) = 'E'};
				if (col < COLS - 1) DFS_markE(board, row, col + 1);
				if (row < ROWS - 1) DFS_markE(board, row + 1, col);
				if (col > 0) DFS_markE(board, row, col - 1);
				if (row > 0) DFS_markE(board, row - 1, col);
			}
		}
	}

	// Q: Why is it that if I simply use (instead of ListBuffer as used above)
	//    var ls: List[(Int, Int)] = Nil and
	//    cons elements (by .::(elem)) in the for-loops below, it does not work?

}