package recfun

import scala.collection.immutable.HashSet
import scala.collection.mutable

class StringFun {

  /**
   * Longest Substring Without Repeating Chars (#3, Medium)
   *
   * Given a string, find the length of the longest substring without
   * repeating characters.
   */

  /** Comment:
   * Debugging is in-progress...!
   * To use sliding window to optimize (covered in data structure/algo class) */

  def lengthOfLongestSubstring(s: String): Int = {

    // Test whether the given string is all unique
    def allUnique(s: String, start: Int, end: Int): Boolean = {
      // Create hashset (no need to insert key as in HashMap)
      val hashset: HashSet[Char] = new HashSet[Char]()

      for (i <- start until end) {
        val ch: Character = s.charAt(i)
        if (hashset.contains(ch)) false
        hashset + ch // add character to the hashset
      }
      true
    }

    // `num` to work as an index where all unique string begins
    val len: Int = s.length
    var num: Int = 0

    for (i <- 0 until len) {
      for (j <- 0 to len) {
        if (allUnique(s, i, j)) {
          num = Math.max(num, j - 1)}
      }
    }
    num
  }


  /**
   * Simplify Path (#71, Medium)
   *
   * Given an absolute path for a file (Unix-style), simplify it.
   * Or in other words, convert it to the canonical path.
   *
   * In a UNIX-style file system, a period . refers to the current directory.
   * Furthermore, a double period .. moves the directory up a level.
   *
   * Note that the returned canonical path must always begin with a slash /,
   * and there must be only a single slash / between two directory names.
   * The last directory name (if it exists) must not end with a trailing /.
   * Also, the canonical path must be the shortest string representing
   * the absolute path.
   */

  def simplifyPath(path: String): String = {

    // When no path was given (i.e., empty string)
    if (path.isEmpty) path
    else {
      // Initialize a stack and make components array
      val stack: mutable.Stack[String] = new mutable.Stack[String]()
      val components: Array[String] = path.split("/")

      // Process each component of path one by one
      for (directory <- components) {

        // A no-op for a "." or an empty string
        if (directory.equals(".") || directory.isEmpty) {} // "." -> current directory, so continue
        else if (directory.equals("..")) {

          // If the current component is "..",
          // go up a level, i.e., pop an element from the stack if it's not empty
          if (!stack.isEmpty) {stack.pop()}
        }
        else {
          // Otherwise, add the legitimate directory to the stack
          stack.addOne(directory)
        }
      }

      // Combine legitimate names together
      val result: StringBuilder = new StringBuilder() //note: use of StringBuilder
      for (dir <- stack) {
        result.append("/")
        result.append(dir)
      }

      // The last directory name (if it exists) must not end with a trailing "/"
      if (result.length > 0) result.toString()
      else "/"
    }
  }



}
