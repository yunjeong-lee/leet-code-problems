package leetcodefun

class Problem322_CoinChange {

	/**
	 * Coin Change (#322, Medium)
	 *
	 * Given coins of different denominations and a total amount of money amount,
	 * write a function to compute the fewest number of coins that you need
	 * to make up that amount. If that amount of money cannot be made up by any
	 * combination of the coins, return -1.
	 *
	 * Example 1:
	 * Input: coins = [1, 2, 5], amount = 11
	 * Output: 3
	 * Explanation: 11 = 5 + 5 + 1
	 *
	 * Example 2:
	 * Input: coins = [2], amount = 3
	 * Output: -1
	 *
	 * Note:
	 * You may assume that you have an infinite number of each kind of coin.
	 */

	def coinChange(coins: Array[Int], amount: Int): Int = {

		// 1. If there is no (or negative) amount. then return 0
		if (amount <= 0) 0
		else
		// 2. If there is no (valid) coins, then return -1
			if (coins.isEmpty || coins.filter(_ <= amount).isEmpty) -1
			else {
				// 3. Sort the array from largest to smallest
				// then leave out all the coins that are greater than the amount
				val valid_coins = coins.filter(_ <= amount).sorted(Ordering.Int.reverse)

				// 4. countLoop where you deduct amount by valid coins
				// and populate the number of counts in the count array

				def countLoop(validCoins: Array[Int], rem: Int, count: Array[Int]): Int = {
					// If rem < 0, it is not feasible to obtain the amount from a combination of coins
					if (rem < 0) -1
					else if (rem == 0) 0
					else if (count(rem - 1) != 0) count(rem - 1)
					else {
						var min: Int = Int.MaxValue

						for (coin <- validCoins) {
							val result: Int = countLoop(validCoins, rem - coin, count)
							if (result >= 0 && result < min) min = 1 + result
						}

						// Populate the last element of count array with min (when min != MaxValue)
						count(rem - 1) = if (min != Int.MaxValue) min else -1
						count(rem - 1)
					}
				}

				countLoop(valid_coins, amount, Array.ofDim[Int](amount))
			}
	}



}
