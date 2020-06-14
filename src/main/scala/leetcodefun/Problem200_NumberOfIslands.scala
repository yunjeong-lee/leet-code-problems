package leetcodefun

class Problem200_NumberOfIslands {

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

	def numIslands(grid: Array[Array[Char]]): Int = {

		def dfs(grid: Array[Array[Char]], r: Int, c: Int): Unit = {
			val num_row: Int = grid.length
			val num_col: Int = grid(0).length
			// If it is outside the grid or cell contains '0', then do nothing
			if (r < 0 || c < 0
				|| r >= num_row || c >= num_col
				|| grid(r)(c) == '0') { }
			else {
				// Mark the visited node as '0'
				grid(r)(c) = '0'
				dfs(grid, r - 1, c)
				dfs(grid, r + 1, c)
				dfs(grid, r, c - 1)
				dfs(grid, r, c + 1)
			}
		}

		if (grid == null || grid.length == 0) { 0 }
		else {
			val num_row: Int = grid.length
			val num_col: Int = grid(0).length

			// Counter for number of islands
			var num_islands: Int = 0
			for (r <- 0 until num_row) {
				for (c <- 0 until num_col) {
					if (grid(r)(c) == '1') {
						// Number of islands increments for every additional root node
						num_islands += 1
						dfs(grid, r, c)
					}
				}
			}
			num_islands
		}

	}



}
