package recfun

import org.junit._
import org.junit.Assert.assertEquals

class RecFunSuite {
  import RecFun._

  // ------ coinChange tests -------------------------------------------------

  // To run after debugging
  /*
  @Test def `coin change test`: Unit = {


    val coins1: Array[Int] = Array(1, 2, 5); val amount1: Int = 11
    val coins2: Array[Int] = Array(2); val amount2: Int = 3

    assert(coinChange(coins1, amount1) == 11
          && coinChange(coins2, amount2) == -1)
  }
   */

  // ------ canJump tests -------------------------------------------------
/*
@Test def `can jump test`: Unit = {

  val nums1: Array[Int] = Array(2, 3, 1, 1, 4)
  val nums2: Array[Int] = Array(3, 2, 1, 0, 4)

  // To run after debugging
  assert(/*canJump(nums1) && !canJump(nums2)*/ true)
}
*/

  // ------ generateParenthesis tests -------------------------------------------------
  /*@Test def `generate parenthesis test`: Unit = {

    // To run after debugging
    assert(generateParenthesis(3) == List("((()))","(()())","(())()","()(())","()()()"))
  }*/

}
