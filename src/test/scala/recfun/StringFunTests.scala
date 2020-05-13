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
}
