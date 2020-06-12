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
   *          [1,2,3],
   *          [1,3,2],
   *          [2,1,3],
   *          [2,3,1],
   *          [3,1,2],
   *          [3,2,1]
   *        ]
   */

  def permute(nums: Array[Int]): List[List[Int]] = {

    // Initialize output list
    val output: ListBuffer[List[Int]] = ListBuffer(List())

    // Convert nums Array into list since the output is a list of lists
    val nums_ls: ListBuffer[Int] = new ListBuffer[Int]()
    for (i <- nums) nums_ls.addOne(i)

    val n: Int = nums.length

    backtrack(n, nums_ls, output, 0)

    // Explore all candidates by backtracking
    def backtrack(n: Int,
                  nums: ListBuffer[List[Int]],
                  output: List[List[Int]],
                  first: Int): Unit = {
      // If all integers are used up
      if (first == n) {
        output.::(new ListBuffer[Int](nums))
      }
      for (i <- first until n) {
        // place i-th integer first in the current permutation
        Collections.swap(nums.toList, first, i)
        // use next integers to complete the permutations
        backtrack(n, nums, output, first + 1)
        // backtrack
        Collections.swap(nums.toList, first, i)
      }
    }

    output.toList

  }


}
