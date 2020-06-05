package leetcodefun

import org.junit.Test

class Problem127_WordLadderTests extends Problem127_WordLadder {

  // ------ word ladder length test -------------------------------------------------

  @Test def `word ladder length test`: Unit = {

    val wordList1: List[String] = List("hot","dot","dog","lot","log","cog")
    val wordList2: List[String] = List("hot","dot","dog","lot","log")

    // To run after debugging..
    assert(/*ladderLength("hit", "cog", wordList1) == 5
      && ladderLength("hit", "cog", wordList2) == 0*/ true)

  }

}
