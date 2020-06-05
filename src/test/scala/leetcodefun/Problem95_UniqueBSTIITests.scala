package leetcodefun

import org.junit.Test

class Problem95_UniqueBSTIITests extends Problem95_UniqueBSTII {

	// ------ unique binary search tree II test -------------------------------------------------

	@Test def `unique binary search tree II test`: Unit = {

		val t00: TreeNode = new TreeNode()
		val t11: TreeNode = new TreeNode()
		val t12: TreeNode = new TreeNode()
		val t21: TreeNode = new TreeNode()
		val t22: TreeNode = new TreeNode()
		t00.value = 1
		t11.value = 1; t12.value = 2; t11.right = t12
		t21.value = 2; t22.value = 1; t21.left = t22
		val expected1: List[TreeNode] = List(t00)
		val generated1: List[TreeNode] = generateTrees(1)
		val expected2: List[TreeNode] = List(t11, t21)
		val generated2: List[TreeNode] = generateTrees(2)

		assert(generateTrees(0) == List()
			&& generated1.length == expected1.length
			&& generated1(0).value == expected1(0).value
			&& generated2.length == expected2.length)

		for (i <- 0 until generated2.length - 1) {
			assert(generated2(i).value == expected2(i).value)
		}
	}

}
