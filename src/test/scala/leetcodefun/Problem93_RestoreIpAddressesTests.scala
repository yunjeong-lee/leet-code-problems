package leetcodefun

import org.junit.Test

class Problem93_RestoreIpAddressesTests extends Problem93_RestoreIpAddresses {

	// ------ restore IP addresses test -------------------------------------------------

	@Test def `restore IP addresses test`: Unit = {

		val s1: String = "25525511135"
		val s2: String = "0000"

		assert(restoreIpAddresses(s1) == List("255.255.11.135", "255.255.111.35")
				&& restoreIpAddresses(s2) == List("0.0.0.0"))

	}


}
