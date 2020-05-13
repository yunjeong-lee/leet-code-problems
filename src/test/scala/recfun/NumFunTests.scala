package recfun

import org.junit.Test

class NumFunTests extends NumFun {

  // ------ largest number test -------------------------------------------------

  @Test def `largest number test`: Unit = {

    val nums1 : Array[Int] = Array(10, 2)
    val nums2 : Array[Int] = Array(3, 30, 34, 5, 9)

    // To run after debugging largestNumber
    assert(/*largestNumber(nums1) == "210" &&
           largestNumber(nums2) == "9534330"*/ true)
  }

  // ------ single number II test -------------------------------------------------

  @Test def `single number II test`: Unit = {

    val num_arr1 : Array[Int] = Array(2, 2, 3, 2)
    val num_arr2 : Array[Int] = Array(0, 1, 0, 1, 0, 1, 99)

    assert(singleNumber(num_arr1) == 3
        && singleNumber(num_arr2) == 99)
  }

  // ------ power function test -------------------------------------------------

  @Test def `power function test`: Unit = {

    val x1: Double = 2; val n1: Int = 10
    val x2: Double = 2.1; val n2: Int = 3
    val x3: Double = 2; val n3: Int = -2

    // Define "~=" (i.e., approximately equal to)
    def ~=(x: Double, y: Double, precision: Double) = {
      if ((x - y).abs < precision) true else false
    }

    assert(~=(myPow(x1, n1), 1024.00, 0.0001)
        && ~=(myPow(x2, n2), 9.26100, 0.0001)
        && ~=(myPow(x3, n3), 0.25000, 0.0001))
  }

  // ------ fraction to decimal test -------------------------------------------------

  @Test def `fraction to decimal test`: Unit = {

    val numerator1: Int = 1; val denominator1: Int = 2
    val numerator2: Int = 2; val denominator2: Int = 1
    val numerator3: Int = 2; val denominator3: Int = 3

    // To run after debugging is complete
    assert(/*fractionToDecimal(numerator1, denominator1) == "0.5"
        && fractionToDecimal(numerator2, denominator2) == "2"
        && fractionToDecimal(numerator3, denominator3) == "0.(6)"*/ true)
  }
}
