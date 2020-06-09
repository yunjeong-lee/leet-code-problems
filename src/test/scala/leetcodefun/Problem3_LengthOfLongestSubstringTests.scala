package leetcodefun
import leetcodefun.local_library._
import org.junit.Test

import scala.util.Random

class Problem3_LengthOfLongestSubstringTests extends Problem3_LengthOfLongestSubstring {

	def lengthOfLongestSubstringTester(n: Int): Boolean = {
		val s: String = genRandomString(n)
		val res: Int = lengthOfLongestSubstring(s)
		var res_str: String = s
		for (i <- 0 until n) {
			res_str = res_str + s
		}
		lengthOfLongestSubstring(res_str) == res
	}


	@Test def `length of longest substring test`: Unit = {
		val s1: String = "abcabcbb"
		val s2: String = "bbbbb"
		val num: Int = Random.nextInt(100)

		assert(lengthOfLongestSubstring(s1) == 3
				&& lengthOfLongestSubstring(s2) == 1
				/*&& lengthOfLongestSubstringTester(num)*/)
	}


}
