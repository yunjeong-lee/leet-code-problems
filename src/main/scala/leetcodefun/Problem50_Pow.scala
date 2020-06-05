package leetcodefun

class Problem50_Pow {

	/**
	 * Pow (50, Medium)
	 * Implement pow(x, n), which calculates x raised to the power n (x^n).
	 *
	 * For example:
	 * Input: 2.00000, 10 -> Output: 1024.00000
	 * Input: 2.10000, 3 -> Output: 9.26100
	 * Input: 2.00000, -2 -> Output: 0.25000 (b/c 2^-2 = 1/2^2 = 1/4 = 0.25)
	 *
	 * Note:
	 * -100.0 < x < 100.0
	 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
	 */

	def myPow(x: Double, n: Int): Double = {

		// If n is negative, switch n to -n
		if (n < 0) {
			1 / myPow(x, -n)
		} // # ^ 0 == 1.0
		else if (n == 0) {
			1.0
		} // # ^ 1 == #
		else if (n == 1) {
			x
		} // If it is even number, divide by 2 and multiply
		else if (n % 2 == 0) {
			val s = myPow(x, n / 2)
			s * s
		} // If it is odd, multiply twice with x
		else {
			val s = myPow(x, n / 2)
			x * s * s
		}
	}

}
