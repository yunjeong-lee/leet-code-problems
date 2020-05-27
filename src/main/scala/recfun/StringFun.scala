package recfun

import scala.collection.immutable.HashSet
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class StringFun {

  /**
   * Longest Substring Without Repeating Chars (#3, Medium)
   *
   * Given a string, find the length of the longest substring without
   * repeating characters.
   */

  /** Comment:
   * Debugging is in-progress...! */

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

  /* To-do list: To use sliding window to optimize (covered in data structure/algo class)*/

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


  /**
   * Restore IP Addresses (#93, Medium)
   *
   * Given a string containing only digits, restore it by returning
   * all possible valid IP address combinations.
   *
   * A valid IP address consists of exactly four integers
   * (each integer is between 0 and 255) separated by single points.
   *
   * Example:
   *
   * Input: "25525511135"
   * Output: ["255.255.11.135", "255.255.111.35"]
   */

  /** Comment:
   * Debugging is in-progress -> currently causing the NullPointerException */

  def restoreIpAddresses(s: String): List[String] = {

    var n: Int = 0
    var s: String = null
    var segments: ListBuffer[String] = new ListBuffer[String]()
    var output: ListBuffer[String] = new ListBuffer[String]()

    // Check if the segment is valid (backtracking logic)
    // 1. The segment should be <= 255
    // 2. The first character can be '0' only if the segment is equal to '0'
    def valid(segment: String): Boolean = {
      val len: Int = segment.length
      if (3 < len) {
        false
      }
      if (segment.charAt(0) != '0') {
        segment.toInt <= 255
      } else {
        len == 1 // when the first character is '0'
      }
    }

    // Update output by adding the solution (list of segments) to output (list of solutions)
    def update_output(curr_pos: Int): Unit = {
      val segment: String = s.substring(curr_pos + 1, n) // segment til the end of s
      if (valid(segment)) {
        segments.addOne(segment)
        val seg_to_add: String = segments.mkString(".")
        output.addOne(seg_to_add)
        // After adding seg_to_add to segments, remove the last placed dot.. => !?!
        segments.remove(segments.length - 1, 1)
      }
    }

    // Backtrack
    // prev_pos: position of the previously placed dot
    // dots: number of dots to place
    def backtrack(prev_pos: Int, dots: Int): Unit = {
      // Farthest position you can go
      // I.e., the current dot curr_pos can be placed in a range from
      //       prev_pos + 1 to prev_pos + 4, so min of that and the len - 1
      val max_pos: Int = Math.min(n - 1, prev_pos + 4)

      for (curr_pos <- prev_pos + 1 until max_pos) {
        val segment: String = s.substring(prev_pos + 1, curr_pos + 1)
        if (valid(segment)) {
          // Place the dot
          segments.addOne(segment)
          if (dots - 1 == 0) {
            // Add solution to the output
            update_output(curr_pos)
          } else {
            // Continue to place the dots
            backtrack(curr_pos, dots - 1)
          }
          // Remove the last placed dot..
          // => Question: when, during the process, was an additional dot placed?!
          segments.remove(segments.length - 1, 1)
        }
      }
    }

    n = s.length
    backtrack(-1, 3)
    // Question: isn't the number of dots not supposed to set, but
    // rather proportional to length of string?!
    output.toList
  }


  /**
   * Word Search (#79, Medium)
   *
   * Given a 2D board and a word, find if the word exists in the grid.
   *
   * The word can be constructed from letters of sequentially adjacent cell,
   * where "adjacent" cells are those horizontally or vertically neighboring.
   * The same letter cell may not be used more than once.
   *
   * Example:
   *
   * board =
   * [
   * ['A','B','C','E'],
   * ['S','F','C','S'],
   * ['A','D','E','E']
   * ]
   *
   * Given word = "ABCCED", return true.
   * Given word = "SEE", return true.
   * Given word = "ABCB", return false.
   *
   * Constraints:
   *
   * * board and word consists only of lowercase and uppercase English letters.
   * * 1 <= board.length <= 200
   * * 1 <= board[i].length <= 200
   * * 1 <= word.length <= 10 ** 3
   *
   */

  /*def exist(board: Array[Array[Char]], word: String): Boolean = {

    // 1. Find where the 1st character of the word is located in the board,
    //    and collect them in a list

    val init_char: Char = word.charAt(0)
    val init_ls: List[(Int, Int)] = Nil

    for (i <- 0 until board.length - 1;
         j <- 0 until board.length - 1) {
      while (board(i)(j) == init_char) {
        init_ls.::(i, j)
      }
    }
    init_ls

  }*/



  /**
   * Word Ladder (#127, Medium)
   *
   * Given two words (beginWord and endWord), and a dictionary's word list,
   * find the length of shortest transformation sequence
   * from beginWord to endWord, such that:
   *
   * Only one letter can be changed at a time.
   * Each transformed word must exist in the word list.
   *
   * Notes:
   *
   * - Return 0 if there is no such transformation sequence.
   * - All words have the same length.
   * - All words contain only lowercase alphabetic characters.
   * - You may assume no duplicates in the word list.
   * - You may assume beginWord and endWord are non-empty and are not the same.
   *
   * Example1:
   *
   * Input:
   * beginWord = "hit",
   * endWord = "cog",
   * wordList = ["hot","dot","dog","lot","log","cog"]
   *
   * Output: 5
   *
   * Explanation: As one shortest transformation is
   * "hit" -> "hot" -> "dot" -> "dog" -> "cog",
   * return its length 5.
   *
   * Example 2:
   *
   * Input:
   * beginWord = "hit"
   * endWord = "cog"
   * wordList = ["hot","dot","dog","lot","log"]
   *
   * Output: 0
   *
   * Explanation: The endWord "cog" is not in wordList,
   * therefore no possible transformation.
   *
   */

  /** The problem is about using undirected, unweighted graph to find the shortest path
   *  from start node (beginWord) to end node (endWord), if it exists. */

  /*def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {

    // len is the same for all (all words are of same length)
    val len: Int = beginWord.length

    // Dictionary that contains all combinations of words
    // that can be formed from any given word by changing one letter at a time
    val allCombDict: mutable.HashMap[String, List[String]] = new mutable.HashMap[String, List[String]]()
    wordList.foreach(word =>
      for (i <- 0 until len) {
        // Key is the generic word
        val newWord: String = word.substring(0, i) + '*' + word.substring(i + 1, len)
        // Value is the list of words which have the same intermediate generic words
        val transformations: List[String] = allCombDict.getOrElse(newWord, new ListBuffer[String]())
        transformations.::(word)
        allCombDict.put(newWord, transformations)
      }
    )

    // Queue for BFS (Breath First Search)
    val Q: mutable.Queue[(String, Int)] = new mutable.Queue[(String, Int)]()
    Q.addOne((beginWord, 1))

    // Currently debugging in-progress

  }*/


  // To review and try formulating the above in a way that utilizes
  // bidirectional breath first search to optimize the search space-!!

}
