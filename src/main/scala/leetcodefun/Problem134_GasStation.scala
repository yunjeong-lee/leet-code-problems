package leetcodefun

class Problem134_GasStation {

	/**
	 * Gas Station (#134, Medium)
	 *
	 * There are N gas stations along a circular route, where the amount of gas at station i
	 * is gas[i]. You have a car with an unlimited gas tank and it costs cost[i] of gas
	 * to travel from station i to its next station (i+1). You begin the journey with
	 * an empty tank at one of the gas stations.
	 *
	 * Return the starting gas station's index if you can travel around the circuit
	 * once in the clockwise direction, otherwise return -1.
	 *
	 * Note:
	 *
	 * If there exists a solution, it is guaranteed to be unique.
	 * Both input arrays are non-empty and have the same length.
	 * Each element in the input arrays is a non-negative integer.
	 *
	 * Example 1:
	 *
	 * Input:
	 * gas  = [1,2,3,4,5]
	 * cost = [3,4,5,1,2]
	 * Output: 3
	 */

	def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {

		// Initiate total and current tanks as 0
		val n: Int = gas.length
		var total_tank: Int = 0
		var curr_tank: Int = 0
		var starting_station: Int = 0

		for (i <- 0 until n) {
			total_tank += gas(i) - cost(i)
			curr_tank += gas(i) - cost(i)

			// If curr_tank < 0 at (i + 1) station (i.e. when couldn't get here),
			// make 'i + 1' (i.e., next) stataion as a new starting point
			if (curr_tank < 0) {
				starting_station = i + 1
				// Reset curr_tank as an empty tank
				curr_tank = 0
			}
		}

		if (total_tank >= 0) {
			starting_station
		} else {
			-1
		}
	}

}
