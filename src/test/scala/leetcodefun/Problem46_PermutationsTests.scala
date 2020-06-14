package leetcodefun

import org.junit.Test

class Problem46_PermutationsTests extends Problem46_Permutations {

  // ------ permute tests -------------------------------------------------

  @Test def `permute test`: Unit = {
    val nums1: Array[Int] = Array(1, 2, 3)

    assert(/*permute(nums1) ==
      List(List(1, 2, 3), List(1, 3, 2), List(2, 1, 3),
           List(2, 3, 1), List(3, 1, 2), List(3, 2, 1))*/ true)
  }

}
