package leetcodefun

import scala.collection.mutable

class Problem71_SimplifyPath {

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

	/** Comment: debugging in-progress.
	 * Check path6 for the edge-case test that failed. */

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
