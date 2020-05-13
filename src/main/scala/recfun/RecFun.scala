package recfun

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


object RecFun extends RecFunInterface {

  /**
   * Coin Change (#322, Medium)
   *
   * Given coins of different denominations and a total amount of money amount,
   * write a function to compute the fewest number of coins that you need
   * to make up that amount. If that amount of money cannot be made up by any
   * combination of the coins, return -1.
   *
   * Note:
   * You may assume that you have an infinite number of each kind of coin.
   */

  /** Debugging in-progress */

  def coinChange(coins: Array[Int], amount: Int): Int = {
    // return -1 if amount cannot be made up by any combination of the coins

    // Extract valid coins and sort from highest to lowest value
    val valid_coins: Array[Int] = coins.filter(_ <= amount).sortWith(_ > _)

    def coinLoop(index:Int, coins: Array[Int], amount: Int): Int = {
      if (coins.isEmpty) -1
      else if (amount == 0) 0
      else
        if (0 < amount && index < coins.length) {
          val maxNum: Int = amount / coins(index)
          var minCount: Int = Integer.MAX_VALUE // set minCost to be MAX_VALUE first
          var num: Int = 0

          while (num <= maxNum) {
            if (num * coins(index) <= amount) {
              val res: Int =
                coinLoop(index + 1, coins, amount - num * coins(index))
              if (res != -1) minCount = Math.min(minCount, res + num)
            }
            {num = num + 1;
              num - 1 } // returning result
          }

          if (minCount == Integer.MAX_VALUE) -1
          else minCount
        }
      -1 // -1 when the amount != 0
    }

    // Obtain result for the given amount and valid coins
    coinLoop(0, valid_coins, amount)
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

  /** Debugging in-progress */

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

  // Comment: There is a harder version of jump game (Jump Game II) to try!



}
