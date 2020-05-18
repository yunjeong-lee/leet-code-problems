package recfun

import org.junit.Test

class StringFunTests extends StringFun {

  // ------ lengthOfLongestSubstring tests -------------------------------------------------

  @Test def `length of longest substring test`: Unit = {
    val s1: String = "abcabcbb"
    val s2: String = "bbbbb"

    // To test after debugging
    assert(/*lengthOfLongestSubstring(s1) == 3 &&
      lengthOfLongestSubstring(s2) == 1*/ true)
  }

  // ------ simplify path test -------------------------------------------------

  @Test def `simplify path test`: Unit = {

    val path1: String = "/home/"
    val path2: String = "/../"
    val path3: String = "/home//foo/"
    val path4: String = "/a/./b/../../c/"
    val path5: String = "/a/../../b/../c//.//"

      assert(simplifyPath(path1) == "/home"
          && simplifyPath(path2) == "/"
          && simplifyPath(path3) == "/home/foo"
          && simplifyPath(path4) == "/c"
          && simplifyPath(path5) == "/c")

    /* Hmm... the path in question:
     * val path: String = "/a//b////c/d//././/.."*/
  }

  // ------ restore IP addresses test -------------------------------------------------

  @Test def `restore IP addresses test`: Unit = {

    val input1: String = "25525511135"

    assert(/*restoreIpAddresses(input1) == List("255.255.11.135", "255.255.111.35")*/ true)

  }

  // ------ word ladder length test -------------------------------------------------

  @Test def `word ladder length test`: Unit = {

    val wordList1: List[String] = List("hot","dot","dog","lot","log","cog")
    val wordList2: List[String] = List("hot","dot","dog","lot","log")

    // To run after debugging..
    assert(/*ladderLength("hit", "cog", wordList1) == 5
      && ladderLength("hit", "cog", wordList2) == 0*/ true)

  }

}
