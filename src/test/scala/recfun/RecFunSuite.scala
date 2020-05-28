package recfun

import org.junit._
import org.junit.Assert.assertEquals

class RecFunSuite {
  import RecFun._

  // ------ coinChange tests -------------------------------------------------

  // To run after debugging

  @Test def `coin change test`: Unit = {

    val coins1: Array[Int] = Array(1, 2, 5); val amount1: Int = 11
    val coins2: Array[Int] = Array(2); val amount2: Int = 3
    val coins3: Array[Int] = Array(186, 419, 83, 408); val amount3: Int = 6249

    assert(coinChange(coins1, amount1) == 3
          && coinChange(coins2, amount2) == -1
          && coinChange(coins3, amount3) == 20)
  }


  // ------ canJump tests -------------------------------------------------

  @Test def `can jump test`: Unit = {

  val nums1: Array[Int] = Array(2, 3, 1, 1, 4)
  val nums2: Array[Int] = Array(3, 2, 1, 0, 4)

  assert(canJump0(nums1) && !canJump0(nums2)
      && canJump1(nums1) && !canJump1(nums2))
  }

  // ------ generateParenthesis tests -------------------------------------------------
  /* Comment : Something wrong with the way I use assert with exists?!
  @Test def `generate parenthesis test`: Unit = {

    val paren3: List[String] = List("((()))","(()())","(())()","()(())","()()()")
    val generated3: List[String] = generateParenthesis(3)
    for (i <- 0 until generated3.length) {
      val elem = generated3(i)
      assert(paren3.exists(elem))
    }
  }*/

}
