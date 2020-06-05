package leetcodefun

import org.junit.Test

class Problem96_UniqueBSTTests extends Problem96_UniqueBST {

  // ------ unique binary search tree test -------------------------------------------------

  @Test def `unique binary search tree test`: Unit = {

    // Question: But, in the function below, when n == 0,
    // it results in List[TreeNode](), so shouldn't it be
    // numTrees(0) == 0 instead? (all the others are okay)
    assert(numTrees(0) == 1 && numTrees(1) == 1
        && numTrees(2) == 2 && numTrees(3) == 5
        && numTrees(4) == 14 && numTrees(5) == 42)
  }

}
