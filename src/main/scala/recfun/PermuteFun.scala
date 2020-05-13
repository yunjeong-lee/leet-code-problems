package recfun

import java.util._
import java.util.LinkedList
import java.util.ArrayList
import java.util.Collections

class PermuteFun {

  /**
   * Permutations (#46, Medium)
   * Given a collection of distinct integers,
   * return all possible permutations.
   */

    /** Comment: Type mismatch -> Debugging in-progress */
  /*def permute(nums: Array[Int]): List[List[Int]] = {

    def backtrack(n: Int,
                  nums: util.ArrayList[Integer],
                  output: List[List[Int]],
                  first: Int): Unit = {
      // if all integers are used up
      if (first == n) output.appended(new util.ArrayList[Integer](nums))
      for (i <- first until n) {
        // in the current permutation
        Collections.swap(nums, first, i)
        // use next integers to complete the permutations
        backtrack(n, nums, output, first + 1)
        // backtrack
        Collections.swap(nums, first, i)
      }
      // place i-th integer first
      // place i-th integer first
    }

    def permute(nums: Array[Int]): List[List[Int]] = {
      // Initialize output list
      val output: List[List[Int]] = new util.LinkedList[List[Int]]()

      // Convert nums into list since the output is a list of lists
      val nums_ls: util.ArrayList[Integer] = new util.ArrayList[Integer]()

      for (num <- nums) nums_ls.add(num)
      val n: Int = nums.length
      backtrack(n, nums_ls, output, 0)
      output
    }

  }*/


  /**
   * Next Permutation (#31, Medium)
   * Implement next permutation, which rearranges numbers into
   * the lexicographically next greater permutation of numbers.
   *
   * If such arrangement is not possible, it must rearrange it
   * as the lowest possible order (ie, sorted in ascending order).
   *
   * The replacement must be in-place and use only constant extra memory.
   *
   * Here are some examples. Inputs are in the left-hand column and
   * its corresponding outputs are in the right-hand column.
   *
   * 1,2,3 → 1,3,2
   * 3,2,1 → 1,2,3
   * 1,1,5 → 1,5,1
   */

  def nextPermutation(nums: Array[Int]): Unit = {

    nextPermute(nums)

    // Helper functions - Swap
    def swap(nums: Array[Int], i: Int, j: Int): Unit = {
      val temp: Int = nums(i)
      nums(i) = nums(j)
      nums(j) = temp
    }

    // Helper functions - Reverse
    def reverse(nums: Array[Int], start: Int): Unit = {
      var i: Int = start
      var j: Int = nums.length - 1
      while (i < j) {
        swap(nums, i, j)
        i += 1; i - 1
        j -= 1; j + 1
      }
    }

    def nextPermute(nums: Array[Int]): Unit = {

      var i: Int = nums.length - 2
      while (0 <= i && nums(i + 1) <= nums(i)) {
        i -= 1; i + 1
      }

      if (i >= 0) {
        var j: Int = nums.length - 1

        // Find first pair of two successive numbers nums(i) nums(i - 1), from the right,
        // which satisfy nums(i) > nums(j)

        // Find the first decreasing element
        while (0 <= j && nums(j) <= nums(i)) {
          j -= 1; j + 1
        }
        // Swap the element with number just larger than the element
          swap(nums, i, j)
        }
      // Reverse the elements from index (i + 1)
      reverse(nums, i + 1)
      }

  }


}
