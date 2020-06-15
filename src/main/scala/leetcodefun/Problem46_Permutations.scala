package leetcodefun

import java.util.{ArrayList, Collections, LinkedList}

import scala.collection.mutable.ListBuffer

class Problem46_Permutations {

  /**
   * Permutations (#46, Medium)
   * Given a collection of distinct integers,
   * return all possible permutations.
   *
   * For example:
   * Input: [1,2,3] ->
   * Output:[
   *          [1,2,3], [1,3,2], [2,1,3],
   *          [2,3,1], [3,1,2], [3,2,1]
   *        ]
   */

  def permute(nums: Array[Int]): List[List[Int]] = {

    // Helper function : swap index i-th and j-th elements in an array
    def swap(arr : Array[Int], i: Int, j: Int): Unit = {
      if (i >= arr.size || j >= arr.size) {
        throw new Error("swap : index out of range")
      } else {
        val x = arr(i); arr(i) = arr(j); arr(j) = x
      }
    }

    // Explore all candidates
    def backtrack(nums: Array[Int],
                  output: ListBuffer[List[Int]],
                  first: Int, n: Int): Unit = {
      // If all integers are used up
      if (first == n) {
        output.addOne(nums.toList)
      } else {
        for (i <- first until n) {
          // Place i-th integer first in the current permutation
          swap(nums, first, i)
          // Use next integers to complete the permutations
          backtrack(nums, output, first + 1, n)
          // Backtrack
          swap(nums, first, i)
        }
      }
    }

    // Initialize output
    val output: ListBuffer[List[Int]] = new ListBuffer[List[Int]]()
    val n: Int = nums.length
    backtrack(nums, output, 0, n)

    output.toList
  }


}
