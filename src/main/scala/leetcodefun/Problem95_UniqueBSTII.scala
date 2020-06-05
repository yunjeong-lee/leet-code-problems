package leetcodefun

import scala.collection.mutable.ListBuffer

class Problem95_UniqueBSTII {

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
