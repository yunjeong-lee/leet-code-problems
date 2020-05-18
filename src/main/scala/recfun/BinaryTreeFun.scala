package recfun

import scala.collection.mutable.ListBuffer

/** Definition for a binary tree node. */

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

class BinaryTreeFun {

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




  /**
   * Unique Binary Search Trees II (#95, Medium)
   *
   * Given an integer n, generate all structurally unique BST's
   * (binary search trees) that store values 1 ... n.
   *
   * Example:
   *
   * Input: 3
   * Output:
   * [
   * [1,null,3,2],
   * [3,2,null,1],
   * [3,1,null,null,2],
   * [2,1,3],
   * [1,null,2,null,3]
   * ]
   *
   * Explanation:
   * The above output corresponds to the 5 unique BST's shown below:
   *
   *  1         3     3      2      1
   *   \       /     /      / \      \
   *    3     2     1      1   3      2
   *   /     /       \                 \
   *  2     1         2                 3
   *
   */

  def generateTrees(n: Int): List[TreeNode] = {

    def genTrees(start: Int, end: Int): List[TreeNode] = {
      val all_trees: ListBuffer[TreeNode] = new ListBuffer[TreeNode]()
      if (start > end) {
        all_trees.addOne(null)
      }

      // Make a Root
      var root: Int = start
      while (root <= end) {

        // All possible left subtrees, given the root
        val left_trees: List[TreeNode] = genTrees(start, root - 1)
        // All possible right subtrees, given the root
        val right_trees: List[TreeNode] = genTrees(root + 1, end)

        // Connect left subtrees and right subtrees to the root
        for (l <- left_trees) {
          for (r <- right_trees) {
            val curr_tree: TreeNode = new TreeNode(root)
            curr_tree.left = l
            curr_tree.right = r
            all_trees.addOne(curr_tree)
          }
        }
        root += 1
      }
      all_trees.toList
    }

    if (n == 0) {
      new ListBuffer[TreeNode]().toList
    }
    else
      genTrees(1, n)
  }




}
