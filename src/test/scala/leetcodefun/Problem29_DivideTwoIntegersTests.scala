package leetcodefun

import org.junit.Test

class Problem29_DivideTwoIntegersTests extends Problem29_DivideTwoIntegers {

  // ------ 3 Sum test -------------------------------------------------

  @Test def `divide two integers test`: Unit = {

    val dividend = -2147483648
    val divisor = -1
    assert(divide(10, 3) == 3
        && divide(7, -3) == -2
      // Case of MinValue -> return MaxValue
        && divide(dividend, divisor) == 2147483647)
  }

}
