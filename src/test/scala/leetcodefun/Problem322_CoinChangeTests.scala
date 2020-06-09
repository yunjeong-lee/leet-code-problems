package leetcodefun
import leetcodefun.local_library._
import org.junit._

import scala.util.Random

class Problem322_CoinChangeTests extends Problem322_CoinChange {

  @Test def `coin change test`: Unit = {

    val coins1: Array[Int] = Array(1, 2, 5); val amount1: Int = 11
    val coins2: Array[Int] = Array(2); val amount2: Int = 3
    val coins3: Array[Int] = Array(186, 419, 83, 408); val amount3: Int = 6249
    val randCoins: Array[Int] = genRandomIntArray2(20)
    val randAmt: Int = Random.nextInt(100) + 10

    assert(coinChange(coins1, amount1) == 3
          && coinChange(coins2, amount2) == -1
          && coinChange(coins3, amount3) == 20
          /*&& coinChange(randCoins, randAmt) != -1*/)
  }


}
