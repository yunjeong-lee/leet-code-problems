package leetcodefun

import org.junit.Test

class Problem134_GasStationTests extends Problem134_GasStation {

	// ------ gas station tests -----------------------------------------------------

	@Test def `gas station tests`: Unit = {
		val gas1: Array[Int] = Array(1, 2, 3, 4, 5)
		val cost1: Array[Int] = Array(3, 4, 5, 1, 2)

		val gas2: Array[Int] = Array(2, 3, 4)
		val cost2: Array[Int] = Array(3, 4, 3)

		assert(canCompleteCircuit(gas1, cost1) == 3
			&& canCompleteCircuit(gas2, cost2) == -1)
	}

}
