package recfun

import org.junit.Test

class BinaryTreeFunTests extends BinaryTreeFun {

  // ------ unique binary search tree test -------------------------------------------------

  @Test def `unique binary search tree test`: Unit = {

    // Question: But, in the function below, when n == 0,
    // it results in List[TreeNode](), so shouldn't it be
    // numTrees(0) == 0 instead? (all the others are okay)
    assert(numTrees(0) == 1 && numTrees(1) == 1
        && numTrees(2) == 2 && numTrees(3) == 5
        && numTrees(4) == 14 && numTrees(5) == 42)
  }

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
