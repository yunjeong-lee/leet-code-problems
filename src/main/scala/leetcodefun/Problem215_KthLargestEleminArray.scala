package leetcodefun

import scala.collection.mutable.PriorityQueue

class Problem215_KthLargestEleminArray {
	/**
	 * Kth Largest Element in an Array (#215, Medium)
	 *
	 * Find the kth largest element in an unsorted array.
	 * Note that it is the kth largest element in the sorted order,
	 * not the kth distinct element.
	 *
	 * Example 1:
	 * Input: [3,2,1,5,6,4] and k = 2
	 * Output: 5
	 *
	 * Example 2:
	 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
	 * Output: 4
	 *
	 * Note:
	 * You may assume k is always valid, 1 ≤ k ≤ array's length.
	 */

	def findKthLargest(nums: Array[Int], k: Int): Int = {

		// Initialize heap in a reverse order
		val heap: PriorityQueue[Int] = new PriorityQueue[Int]().reverse

		// Keep only the k largest elements in the heap
		for (n <- nums) {
			heap.addOne(n)
			// Remove the element with the highest priority in the queue
			if (heap.size > k) { heap.dequeue() }
		}

		// Return the kth largest element (by dequeue)
		heap.dequeue()
	}


}
