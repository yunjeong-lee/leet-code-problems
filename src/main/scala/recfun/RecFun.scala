package recfun

import java.lang.AssertionError
import java.util

import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl

// Defined a new object 'Index' for the 'Jump Game' problem
// to enumerate a group of named constants for state
object Index extends Enumeration {
  val GOOD: Index = new Index()
  val BAD: Index = new Index()
  val UNKNOWN: Index = new Index()
  class Index extends Val
  // Implicit conversion : omit calling methods or referencing variables directly
  // but instead rely on the compiler to make the connections
  implicit def convertValue(v: Value): Index = v.asInstanceOf[Index]

}


object RecFun {

  /**
   * Coin Change (#322, Medium)
   *
   * Given coins of different denominations and a total amount of money amount,
   * write a function to compute the fewest number of coins that you need
   * to make up that amount. If that amount of money cannot be made up by any
   * combination of the coins, return -1.
   *
   * Example 1:
   * Input: coins = [1, 2, 5], amount = 11
   * Output: 3
   * Explanation: 11 = 5 + 5 + 1
   *
   * Example 2:
   * Input: coins = [2], amount = 3
   * Output: -1
   *
   * Note:
   * You may assume that you have an infinite number of each kind of coin.
   */

  def coinChange(coins: Array[Int], amount: Int): Int = {

    // 1. If there is no (or negative) amount. then return 0
    if (amount <= 0) 0
    else
      // 2. If there is no (valid) coins, then return -1
      if (coins.isEmpty || coins.filter(_ <= amount).isEmpty) -1
      else {
        // 3. Sort the array from largest to smallest
        // then leave out all the coins that are greater than the amount
        val valid_coins = coins.filter(_ <= amount).sorted(Ordering.Int.reverse)

        // 4. countLoop where you deduct amount by valid coins
        // and populate the number of counts in the count array

        def countLoop(validCoins: Array[Int], rem: Int, count: Array[Int]): Int = {
          // If rem < 0, it is not feasible to obtain the amount from a combination of coins
          if (rem < 0) -1
          else if (rem == 0) 0
          else if (count(rem - 1) != 0) count(rem - 1)
          else {
            var min: Int = Int.MaxValue

            for (coin <- validCoins) {
              val result: Int = countLoop(validCoins, rem - coin, count)
              if (result >= 0 && result < min) min = 1 + result
            }

            // Populate the last element of count array with min (when min != MaxValue)
            count(rem - 1) = if (min != Int.MaxValue) min else -1
            count(rem - 1)
          }
        }

        countLoop(valid_coins, amount, Array.ofDim[Int](amount))
    }
  }


  /**
   * Jump Game (#55, Medium)
   *
   * Given an array of non-negative integers, you are initially positioned
   * at the first index of the array. Each element in the array represents
   * your maximum jump length at that position.
   *
   * Determine if you are able to reach the last index.
   *
   * Constraints:
   * 1 <= nums.length <= 3 * 10^4
   * 0 <= nums[i][j] <= 10^5
   */

  def canJump(nums: Array[Int]): Boolean = {
    var memo: Array[Index.Index] = Array()

    def canJumpFromPosition(position: Int, nums: Array[Int]): Boolean = {
      if (memo(position) != Index.UNKNOWN) {
        if (memo(position) == Index.GOOD) true
        else false
      }
      val furthestJump: Int =
        Math.min(position + nums(position), nums.length - 1)

      var nextPosition: Int = position + 1

      while(nextPosition <= furthestJump) {
        if (canJumpFromPosition(nextPosition, nums)) {
          memo(position) = Index.GOOD
          true
        }
        {nextPosition += 1;
          nextPosition - 1}
      }
      memo(position) = Index.BAD
      false
    }

    memo = Array.ofDim[Index.Index](nums.length)
    // Set all to be UNKNOWN at first
    for (i <- 0 until memo.length) {
      memo(i) = Index.UNKNOWN
    }
    // Set the last one to be GOOD
    memo(memo.length - 1) = Index.GOOD

    canJumpFromPosition(0, nums)
  }

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

  /** Debugging in-progress : Not sure why it is not generating the answers properly?
   * possibly something wrong in converting back and forth from Array to List? */

  def generateParenthesis(n: Int): List[String] = {

    def ParenthesisRec(ans: Array[String],
                        res: StringBuilder,
                        left: Int, right: Int, max: Int): Unit = {
      if (res.length == max * 2) {
        ans.++(res.toString)
      }
      // left refers to number of open parentheses
      if (left < max) {
        res.append('(')
        // After using a open parenthesis, add left by 1 and run recursion
        ParenthesisRec(ans, res, left + 1, right, max)
        res.deleteCharAt(res.length - 1)
      }
      // right refers to number of close parentheses
      if (right < left) {
        res.append(')')
        // After using a close parenthesis, add right by 1 and run recursion
        ParenthesisRec(ans, res, left, right + 1, max)
        res.deleteCharAt(res.length - 1)
      }
    }

    val ans: Array[String] = new Array[String](n*2)
    val res: StringBuilder = new StringBuilder()
    ParenthesisRec(ans, res, 0, 0, n)
    ans.toList
  }


}
