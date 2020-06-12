package leetcodefun

import scala.collection.mutable.HashMap
import scala.util.control.Breaks

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
		if (numerator == 0) { return "0" }

		// If either numerator or denominator is negative, but not both (`^`),
		// then append "-" in front
		if (numerator < 0 ^ denominator < 0) { fraction.append("-") }

		// Convert to positive number
		val dividend: Int = Math.abs(numerator)
		val divisor: Int = Math.abs(denominator)

		// Append the division result
		fraction.append((dividend / divisor).toString)

		// If remainder == 0 -> then convert to string and return result
		var remainder: Int = dividend % divisor
		if (remainder == 0) {
			fraction.toString
		}
		else {
			fraction.append(".")

			// Create a hashmap
			val map: HashMap[Int, Long] = new HashMap[Int, Long]()
			val while_loop = new Breaks

			while (remainder != 0) {
				if (map.contains(remainder)) {
					var rem: Option[Long] = map.get(remainder)
					// Insert it only if it is not None
					rem match {
						case Some(p) => fraction.insert(p.toInt, "(")
						case None => ()
					}
					fraction.append(")")
					return fraction.toString
					while_loop.break
				} else {
					// Update hashmap with (key: remainder, value: fraction length)
					map.update(remainder, fraction.length)
					remainder *= 10

					fraction.append(String.valueOf(remainder / divisor))
					remainder %= divisor // modulus and assignment
				}
			}
			fraction.toString
		}
	}

}
