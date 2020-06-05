package leetcodefun

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Problem127_WordLadder {

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
   *  from start node (beginWord) to end node (endWord), if it exists.
	 *  It is using same graph structure as Problem 133 Clone Graph. */

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

  }*/

	// To review and try formulating the above in a way that utilizes
  // bidirectional breath first search to optimize the search space-!!

}
