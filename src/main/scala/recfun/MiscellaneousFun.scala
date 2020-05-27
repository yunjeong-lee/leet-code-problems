package recfun

import scala.collection.mutable.ListBuffer

class MiscellaneousFun {

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


	/**
	 * Clone Graph (#133, Medium)
	 *
	 * Given a reference of a node in a connected undirected graph,
	 * return a deep copy (clone) of the graph.
	 *
	 * Each node in the graph contains a val (int) and a list (List[Node])
	 * of its neighbors.
	 *
	 * Notes:
	 * For simplicity sake, each node's value is the same as the node's index (1-indexed).
	 * For example, the first node with val = 1, the second node with val = 2, and so on.
	 * The graph is represented in the test case using an adjacency list.
	 *
	 * Adjacency list is a collection of unordered lists used to represent a finite graph.
	 * Each list describes the set of neighbors of a node in the graph.
	 *
	 * The given node will always be the first node with val = 1. You must return
	 * the copy of the given node as a reference to the cloned graph.
	 */

	class Node(var _value: Int) {
		var value: Int = _value
		var neighbors: List[Node] = List()
	}

	/*def cloneGraph(graph: Node): Node = {

		// Brainstorming in-progress

	}*/


	/**
	 * Number of Islands (#200, Medium)
	 *
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
	 * An island is surrounded by water and is formed by connecting adjacent lands
	 * horizontally or vertically. You may assume all four edges of the grid are all
	 * surrounded by water.
	 *
	 * Example 1:
	 * Input:
	 * 11110
	 * 11010
	 * 11000
	 * 00000
	 * Output: 1
	 *
	 * Example 2:
	 * Input:
	 * 11000
	 * 11000
	 * 00100
	 * 00011
	 * Output: 3
	 */

	/*def numIslands(grid: Array[Array[Char]]): Int = {

		// Brainstorming in-progress
		// Possibly using the methods from surroundSolve above

	}*/



}