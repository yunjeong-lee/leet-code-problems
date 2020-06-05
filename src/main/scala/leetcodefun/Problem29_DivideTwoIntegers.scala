package leetcodefun

class Problem29_DivideTwoIntegers {

  /**
   * Divide Two Integers (#29, Medium)
   *
   * Given two integers dividend and divisor, divide two integers
   * without using multiplication, division and mod operator.
   *
   * Return the quotient after dividing dividend by divisor.
   *
   * The integer division should truncate toward zero,
   * which means losing its fractional part. For example,
   * truncate(8.345) = 8 and truncate(-2.7335) = -2.
   *
   * Example 1:
   *
   * Input: dividend = 10, divisor = 3
   * Output: 3
   * Explanation: 10/3 = truncate(3.33333..) = 3.
   *
   * Example 2:
   *
   * Input: dividend = 7, divisor = -3
   * Output: -2
   * Explanation: 7/-3 = truncate(-2.33333..) = -2.
   *
   * Note:
   *
   * * Both dividend and divisor will be 32-bit signed integers.
   * * The divisor will never be 0.
   * * Assume we are dealing with an environment which could only store
   *   integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
   * * For the purpose of this problem, assume that your function
   *   returns 2 ^ 31 − 1 when the division result overflows.
   * */

  /** In addition: There are multiple approaches to this problem.
   *  It was noted that this is one of the hardest medium problems. */

  def divide(dividend: Int, divisor: Int): Int = {

    var quo: Int = 0

    // When the result overflows (over 32-bit signed integer range)
    if (dividend == Int.MinValue
      && divisor == -1) {
      Int.MaxValue
    }
    else {
      var divid: Int = dividend
      var divis: Int = divisor

      // Need to convert both dividend and divosr to negative (Notes below)
      // Count the negative by subtraction (starting from 2)
      var negatives: Int = 2
      if (divid > 0) {
        negatives -= 1
        divid = -divid
      }
      if (divis > 0) {
        negatives -= 1
        divis = -divis
      }

      // Subtract divisor from dividend
      // and count how many times it's done (by subtraction)
      while (divid - divis <= 0) {
        quo -= 1
        divid -= divis
      }

      // If there was only one negative sign (either divisor or dividend negative),
      // then, quotient remains negative;
      // otherwise, convert it to a positive number
      if (negatives != 1) {
        quo = -quo
      }
      quo
    }
  }

  // Notes on the above problem:
  // The key observation to make is that the problems are occurring
  // because there are more negative signed 32-bit integers than
  // there are positive signed 32-bit integers. Each positive signed
  // 32-bit integer has a corresponding negative signed 32-bit integer.
  // However, the same is not true for negative signed 32-bit integers.
  // The smallest one, -2147483648, is alone. It is this number that
  // causes the problems. This is the reason why both Dividend and Divisor
  // are converted to negative in the above process.

}
