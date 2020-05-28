package recfun

import java.lang.AssertionError
import java.util

import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl

import scala.collection.mutable.ListBuffer

// Defined a new object 'Index' for the 'Jump Game' problem
// to enumerate a group of named constants for state
object Index extends Enumeration {
  val GOOD: Index = new Index()
  val BAD: Index = new Index()
  val UNKNOWN: Index = new Index()
  class Index extends Val
  // Implicit conversion : omit calling methods or referencing variables directly
  // but instead rely on the compiler to make the connections
  implicit def convertValue(v: Value): Index = v.asInstanceOf[Index] // Note 'asInstanceOf' method!

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
   * Example 1:
   * * Input: nums = [2,3,1,1,4]
   * * Output: true
   *
   * Example 2:
   * Input: nums = [3,2,1,0,4]
   * Output: false
   *
   * Constraints:
   * 1 <= nums.length <= 3 * 10^4
   * 0 <= nums[i][j] <= 10^5
   */

  // Sub-optimal backtracking approach
  def canJump0(nums: Array[Int]): Boolean = {

    def canJumpFromPosition(position: Int, nums: Array[Int]): Boolean = {
      if (position == nums.length - 1) true
      else {
        // Furthest jump that can be made, and the next position
        val furthestJump: Int = Math.min(position + nums(position), nums.length - 1)
        var nextPosition: Int = position + 1
        var reachability: Boolean = false

        while (nextPosition <= furthestJump) {
          // If the last position can be reached from nextPositions, return true
          if (canJumpFromPosition(nextPosition, nums)) {reachability = true}
          nextPosition += 1
        }
        reachability
      }
    }

    canJumpFromPosition(0, nums)
  }


  // More optimal approach (top-down dynamic programming version)
  def canJump1(nums: Array[Int]): Boolean = {

    var memo: Array[Index.Index] = Array()
    memo = Array.ofDim[Index.Index](nums.length)

    // Set all to be UNKNOWN at first
    for (i <- 0 until memo.length) {
      memo(i) = Index.UNKNOWN
    }
    // Set the last one to be GOOD
    memo(memo.length - 1) = Index.GOOD

    def canJumpFromPosition(position: Int, nums: Array[Int]): Boolean = {
      if (memo(position) != Index.UNKNOWN) {
        if (memo(position) == Index.GOOD) true
        else false
      } else { // when it is UNKNOWN
      val furthestJump: Int = Math.min(position + nums(position), nums.length - 1)
      var nextPosition: Int = position + 1
      var reachability: Boolean = false

      while(nextPosition <= furthestJump) {
        if (canJumpFromPosition(nextPosition, nums)) {
          memo(position) = Index.GOOD
          reachability = true
        }
        nextPosition += 1
      }
      memo(position) = Index.BAD
      reachability
      }
    }

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
