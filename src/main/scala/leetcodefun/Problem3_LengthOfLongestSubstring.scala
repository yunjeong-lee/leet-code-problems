package leetcodefun

import scala.collection.mutable

class Problem3_LengthOfLongestSubstring {

	/**
	 * Longest Substring Without Repeating Chars (#3, Medium)
	 *
	 * Given a string, find the length of the longest substring without
	 * repeating characters.
	 *
	 * Example 1:
	 * Input: "abcabcbb"
	 * Output: 3
	 *
	 * Example 2:
	 * Input: "bbbbb"
	 * Output: 1
	 *
	 * Example 3:
	 * Input: "pwwkew"
	 * Output: 3
	 * Explanation: The answer is "wke", with the length of 3.
	 */

	def lengthOfLongestSubstring(s: String): Int = {

		val len: Int = s.length
		var ans: Int = 0

		// Create a hashmap
		val map: mutable.HashMap[Char, Int] = new mutable.HashMap[Char, Int]()

		var i = 0
		for (j <- 0 until len) {

			// If there is a character from the map, then i = max(n, i)
			if (map.contains(s.charAt(j))) {
				map.get(s.charAt(j)) match {
					case Some(n) => i = Math.max(n, i)
					case None => ()
				}
			}

			// ans is max(ans, j - i + 1)  >> Note how j - i + 1 is computed here!
			ans = Math.max(ans, j - i + 1)
			// Map the character to its (index + 1)
			map.put(s.charAt(j), j + 1)
		}
		ans
	}


}
