package recfun

import java.util

import scala.collection.immutable.HashMap
import scala.collection.mutable

class NumFun {

  /**
   * Largest Number (#179, Medium)
   *
   * Given a list of non negative integers,
   * arrange them such that they form the largest number.
   *
   * E.g.,
   * Input [10, 2] -> "210"
   * Input: [3,30,34,5,9] -> Output: "9534330"
   *
   * Note: The result may be very large,
   * so you need to return a string instead of an integer.
   */

  /** Debugging the below function is in-progress.. */

  def largestNumber(nums: Array[Int]): String = {

    // Convert the Array[Int] to Array[String]
    val strings: Array[String] = Array.ofDim(nums.length)
    for (i <- 0 until nums.length) {
      strings(i) = (nums(i)).toString
    }

    // Sort strings according to the comparator
    strings.sortWith{(s1, s2) =>
      val s12: String = s1 + s2
      val s21: String = s2 + s1
      (s12.compareTo(s21)) >= 0} // note: compareTo method

    // If the largest one, after sorting, is zero, the entire number is "0".
    if (strings(0) == ("0")) {"0"}

    // Build largest number from sorted array
    var largestNumStr: String = new String()
    for (numAsStr <- strings) {
      largestNumStr += numAsStr
    }
    largestNumStr

  }

  /**
   * Single Number II (#137, Medium)
   *
   * Given a non-empty array of integers,
   * every element appears three times except for one,
   * which appears exactly once. Find that single one.
   */

  def singleNumber(nums: Array[Int]): Int = {

    // Create a hashmap
    val hashmap: mutable.HashMap[Int, Int] = new mutable.HashMap[Int, Int]()

    // Create result int variable
    var res: Int = -1

    // Iterate over the input array to count the frequency of each number
    for (n <- nums) {
      hashmap.put(n, hashmap.getOrElse(n, 0) + 1)
    }

    // Return an element with frequency 1
    for (k <- hashmap.keySet) {
      if (hashmap.get(k) == Some(1)) {res = k}
    }

    res
  }


  /* To answer question below:
   * The algorithm above should have a linear runtime complexity.
   * Could you implement it without using extra memory?
   *
   * To think about how I can do the above without having any hashmap..
   * */

  /**
   * Pow (50, Medium)
   * Implement pow(x, n), which calculates x raised to the power n (x^n).
   *
   * For example:
   * Input: 2.00000, 10 -> Output: 1024.00000
   * Input: 2.10000, 3 -> Output: 9.26100
   * Input: 2.00000, -2 -> Output: 0.25000 (b/c 2^-2 = 1/2^2 = 1/4 = 0.25)
   *
   * Note:
   * -100.0 < x < 100.0
   * n is a 32-bit signed integer, within the range [−231, 231 − 1]
   */

  def myPow(x: Double, n: Int): Double = {

    // If n is negative, switch n to -n
    if (n < 0) {
      1 / myPow(x, -n)
    } // # ^ 0 == 1.0
    else if (n == 0) {
      1.0
    } // # ^ 1 == #
    else if (n == 1) {
      x
    } // If it is even number, divide by 2 and multiply
    else if (n % 2 == 0) {
      val s = myPow(x, n / 2)
      s * s
    } // If it is odd, multiply twice with x
    else {
      val s = myPow(x, n / 2)
      x * s * s
    }
  }

  /**
   * Fraction to Recurring Decimal (#166, Medium)
   *
   * Given two integers representing the numerator and denominator of a fraction,
   * return the fraction in string format.
   *
   * If the fractional part is repeating, enclose the repeating part in parentheses.
   */

  /** Debugging in-progress.. something is not right about below..*/

  def fractionToDecimal(numerator: Int, denominator: Int): String = {

    val fraction: StringBuilder = new StringBuilder()

    // If numerator is zero, return "0"
    if (numerator == 0) {"0"}

    // If numerator or denominator is negative
    // (but not both of them are negative -> note the usage of `^`),
    // then append "-" in front
    if (numerator < 0 ^ denominator < 0) {
      fraction.append("-")
    }

    // Convert to Double
    val dividend: Double = Math.abs(numerator.toDouble)
    val divisor: Double = Math.abs(denominator.toDouble)

    // Append the division result
    fraction.append((dividend / divisor).toString)

    // If remainder == 0 -> then convert to string and return result
    var remainder: Double = dividend % divisor
    if (remainder == 0) {
      fraction.toString
    }
    else {
      fraction.append(".")

      // Create a hashmap
      val map: HashMap[Double, Integer] = new HashMap[Double, Integer]()

      while (remainder != 0) {
        if (map.contains(remainder)) {
          var rem: Option[Integer] = map.get(remainder)
          // Insert it only if it is not None
          rem match {
            case Some(p) => fraction.insert(p, "(")
            case None => ()
          }
          fraction.append(")")
        }
        // Update hashmap with (remainder, fraction length)
        map.updated(remainder, fraction.length)
        remainder *= 10

        fraction.append(String.valueOf(remainder / divisor))
        remainder %= divisor // modulus and assignment
      }
      fraction.toString
    }
  }

  /**
   * 3Sum (#15, Medium)
   *
   * Given an array nums of n integers, are there elements
   * a, b, c in nums such that a + b + c = 0?
   * Find all unique triplets in the array which gives the sum of zero.
   *
   * Note:
   * The solution set must not contain duplicate triplets.
   *
   * Example:
   * Given array nums = [-1, 0, 1, 2, -1, -4],
   *
   * A solution set is:
   * [
   * [-1, 0, 1],
   * [-1, -1, 2]
   * ]
   */

  /** Debugging the below function is in-progress.. */

  def threeSum(nums: Array[Int]): List[List[Int]] = {

    nums.sorted

    val triplets: mutable.HashSet[List[Int]] = new mutable.HashSet[List[Int]]()

    for (left <- 0 until nums.length - 2) {
      var mid: Int = left + 1
      var right: Int = nums.length - 1

      while (mid < right) {
        val sum: Int = nums(left) + nums(mid) + nums(right)

        if (sum < 0) {
          mid +=1; mid - 1
        } else if (sum > 0) {
          right -= 1; right + 1
        } else {
          val triplet: List[Int] = List(nums(left), nums(mid), nums(right))
          triplets.add(triplet)
          mid += 1; mid - 1
        }
      }
    }

    triplets.toList

  }

  // To do: After debugging the above, try out a related problem, 3Sum Closest (#15)


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
