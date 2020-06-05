package leetcodefun

import scala.collection.immutable.HashMap

class Problem166_FractionToDecimal {

	/**
	 * Fraction to Recurring Decimal (#166, Medium)
	 *
	 * Given two integers representing the numerator and denominator of a fraction,
	 * return the fraction in string format.
	 *
	 * If the fractional part is repeating, enclose the repeating part in parentheses.
	 */

	def fractionToDecimal(numerator: Int, denominator: Int): String = {

		val fraction: StringBuilder = new StringBuilder()

		// If numerator is zero, return "0"
		if (numerator == 0) {"0"}

		// If numerator or denominator is negative
		// (but not both of them are negative -> note the usage of `^`),
		// then append "-" in front
		if (numerator < 0 ^ denominator < 0) {
			fraction.append("-")
		}

		// Convert to Double
		val dividend: Double = Math.abs(numerator.toDouble)
		val divisor: Double = Math.abs(denominator.toDouble)

		// Append the division result
		fraction.append((dividend / divisor).toString)

		// If remainder == 0 -> then convert to string and return result
		var remainder: Double = dividend % divisor
		if (remainder == 0) {
			fraction.toString
		}
		else {
			fraction.append(".")

			// Create a hashmap
			val map: HashMap[Double, Integer] = new HashMap[Double, Integer]()

			while (remainder != 0) {
				if (map.contains(remainder)) {
					var rem: Option[Integer] = map.get(remainder)
					// Insert it only if it is not None
					rem match {
						case Some(p) => fraction.insert(p, "(")
						case None => ()
					}
					fraction.append(")")
				}
				// Update hashmap with (remainder, fraction length)
				map.updated(remainder, fraction.length)
				remainder *= 10

				fraction.append(String.valueOf(remainder / divisor))
				remainder %= divisor // modulus and assignment
			}
			fraction.toString
		}
	}

}
