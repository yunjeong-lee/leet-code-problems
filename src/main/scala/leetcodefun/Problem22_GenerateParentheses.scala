package leetcodefun

import scala.collection.mutable.ListBuffer

class Problem22_GenerateParentheses {

	/**
	 * Generate Parentheses (#22, Medium)
	 *
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 *
	 * For example, given n = 3, a solution set is:
	 * [
	 * "((()))",
	 * "(()())",
	 * "(())()",
	 * "()(())",
	 * "()()()"
	 * ]
	 */

	def generateParenthesis(n: Int): List[String] = {

		val ans: ListBuffer[String] = new ListBuffer[String]()
		if (n == 0) {
			ans.addOne("")
		} else {
			for (c <- 0 until n;
					 left <- generateParenthesis(c);
					 right <- generateParenthesis(n - 1 - c)) {
				ans.addOne("(" + left + ")" + right)
			}
			ans
		}
		ans.toList
	}


}
