package leetcodefun
import java.util.HashMap

class Problem36_ValidSudoku {

  /**
   * isValid Sudoku (#36, Medium)
   * Determine if a 9x9 Sudoku board is valid.
   * Only the filled cells need to be validated
   * according to the following rules:
   *
   * 1. Each row must contain the digits 1-9 without repetition.
   * 2. Each column must contain the digits 1-9 without repetition.
   * 3. Each of the 9 3x3 sub-boxes of the grid must contain
   *    the digits 1-9 without repetition.
   */

  def isValidsudoku(board: Array[Array[Char]]): Boolean = {

    // Populate the data
    val rows: Array[HashMap[Integer, Integer]] = Array.ofDim[HashMap[Integer, Integer]](9)
    val columns: Array[HashMap[Integer, Integer]] = Array.ofDim[HashMap[Integer, Integer]](9)
    val boxes: Array[HashMap[Integer, Integer]] = Array.ofDim[HashMap[Integer, Integer]](9)
    for (i <- 0.until (9)) {
      rows(i) = new HashMap[Integer, Integer]()
      columns(i) = new HashMap[Integer, Integer]()
      boxes(i) = new HashMap[Integer, Integer]()
    }

    for (i <- 0 until 9; j <- 0 until 9) {
      val num: Char = board(i)(j)
      if (num != '.'){
        val n: Int = num.toInt
        val box_index: Int = (i/3) * 3 + j/3

        // Keep the current cell value
        rows(i).put(n, rows(i).getOrDefault(n, 0) + 1) // return default only if no mapping
        columns(j).put(n, columns(j).getOrDefault(n, 0) + 1)
        boxes(box_index).put(n, boxes(box_index).getOrDefault(n, 0) + 1)

        // Check if this value has been already seen before
        if (rows(i).get(n) > 1 ||
          columns(j).get(n) > 1 ||
          boxes(box_index).get(n) > 1) false
      }
    }
    true
  }


}
