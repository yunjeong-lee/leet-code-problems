package leetcodefun

class Problem96_UniqueBST {

  /**
   * Unique Binary Search Trees (#96, Medium)
   *
   * Given n, how many structurally unique BST's (binary search trees)
   * that store values 1 ... n?
   *
   * Example:
   *
   * Input: 3
   * Output: 5
   * Explanation:
   * Given n = 3, there are a total of 5 unique BST's:
   *
   *  1         3     3      2      1
   *   \       /     /      / \      \
   *    3     2     1      1   3      2
   *   /     /       \                 \
   *  2     1         2                 3
   *
   */

    // This is also known as "Catalan Number"
  def numTrees(n: Int): Int = {
      // Use Mathematical deduction

      // Note: long is needed, otherwise overflow
      var count: Long = 1
      for (i <- 0 until n) {
        count = count * 2 * (2 * i + 1) / (i + 2)
      }
      count.toInt
      // How the above relation is obtained:
      // https://mathworld.wolfram.com/CatalanNumber.html
  }

}
