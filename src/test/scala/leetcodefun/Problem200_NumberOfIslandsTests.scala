package leetcodefun

import org.junit.Test

class Problem200_NumberOfIslandsTests extends Problem200_NumberOfIslands {

	// ------ number of islands test -----------------------------------------------------

	@Test def `number of islands tests`: Unit = {

		val grid1: Array[Array[Char]] =
			Array(
				Array('1', '1', '1', '1', '0'),
				Array('1', '1', '0', '1', '0'),
				Array('1', '1', '0', '0', '0'),
				Array('0', '0', '0', '0', '0'),
			)
		val grid2: Array[Array[Char]] =
			Array(
				Array('1', '1', '0', '0', '0'),
				Array('1', '1', '0', '0', '0'),
				Array('0', '0', '1', '0', '0'),
				Array('0', '0', '0', '1', '1'),
			)

		assert(numIslands(grid1) == 1
				&& numIslands(grid2) == 3)

	}

}
