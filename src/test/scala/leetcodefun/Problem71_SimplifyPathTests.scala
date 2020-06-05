package leetcodefun

import org.junit.Test

class Problem71_SimplifyPathTests extends Problem71_SimplifyPath {

	@Test def `simplify path test`: Unit = {

		val path1: String = "/home/"
		val path2: String = "/../"
		val path3: String = "/home//foo/"
		val path4: String = "/a/./b/../../c/"
		val path5: String = "/a/../../b/../c//.//"
		val path6: String = "/a//b////c/d//././/.."

		assert(simplifyPath(path1) == "/home"
			&& simplifyPath(path2) == "/"
			&& simplifyPath(path3) == "/home/foo"
			&& simplifyPath(path4) == "/c"
			&& simplifyPath(path5) == "/c"
			/*&& simplifyPath(path6) == "/a/b/c"*/)


	}

}
