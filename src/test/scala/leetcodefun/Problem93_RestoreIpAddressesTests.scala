package leetcodefun

import org.junit.Test

class Problem93_RestoreIpAddressesTests extends Problem93_RestoreIpAddresses {

	// ------ restore IP addresses test -------------------------------------------------

	@Test def `restore IP addresses test`: Unit = {

		val input1: String = "25525511135"

		assert(/*restoreIpAddresses(input1) == List("255.255.11.135", "255.255.111.35")*/ true)

	}


}
