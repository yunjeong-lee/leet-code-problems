package leetcodefun

import scala.collection.mutable.Queue
import scala.collection.mutable.HashMap

class Problem133_CloneGraph {

	/**
	 * Clone Graph (#133, Medium)
	 *
	 * Given a reference of a node in a connected undirected graph,
	 * return a deep copy (clone) of the graph.
	 *
	 * Each node in the graph contains a val (int) and a list (List[Node])
	 * of its neighbors.
	 *
	 * Notes:
	 * For simplicity sake, each node's value is the same as the node's index (1-indexed).
	 * For example, the first node with val = 1, the second node with val = 2, and so on.
	 * The graph is represented in the test case using an adjacency list.
	 *
	 * Adjacency list is a collection of unordered lists used to represent a finite graph.
	 * Each list describes the set of neighbors of a node in the graph.
	 *
	 * The given node will always be the first node with val = 1. You must return
	 * the copy of the given node as a reference to the cloned graph.
	 *
	 * Constraints:
	 * * 1 <= Node.val <= 100
	 * * Node.val is unique for each node.
	 * * Number of Nodes will not exceed 100.
	 * * There is no repeated edges and no self-loops in the graph.
	 * * The Graph is connected and all nodes can be visited starting from the given node.
	 *
	 * Example 1:
	 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
	 * Output: [[2,4],[1,3],[2,4],[1,3]]
	 *
	 * Example 2:
	 * Input: adjList = [[]]
	 * Output: [[]]
	 *
	 * Example 3:
	 * Input: adjList = [[2],[1]]
	 * Output: [[2],[1]]
	 */

	class Node(var _value: Int) {
		var value: Int = _value;
		var neighbors: List[Node] = List()
	}


	def get_exn(opt_value: Option[Node]): Node = {
		opt_value match {
			case Some(p) => p;
			case None => throw new IllegalArgumentException("None is not possible")
		}
	}

	/* def cloneGraph(graph: Node): Node = {
		if (graph == null) {
			graph
		}
		// Hash map to save the visited nodes and its clone as key/value
		val visited: HashMap[Node, Node] = new HashMap[Node, Node]()

		// Make a queue and put the first node (which is given graph) in the queue
		val queue: Queue[Node] = new Queue[Node]()
		queue.addOne(graph)

		// Clone the node and put it in the visited hashmap
		visited.put(graph, new Node(graph.value))

		// Begin the Breadth-First Search traversal
		while (!queue.isEmpty) {
			// Pop a node from the front of the queue
			val n: Node = queue.remove(0)

			// Iterate through all the neighbors of the node "n"
			for (neighbor <- n.neighbors) {
				if (!visited.contains(neighbor)) {
					visited.put(neighbor, new Node(neighbor.value))
					queue.addOne(neighbor)
				}
				get_exn(visited.get(n)).neighbors.++(visited.get(neighbor))
			}
		}
		get_exn(visited.get(graph))
	}
	*/

	/*
	if (visited.contains(graph)) {
		// Return the clone from the visited hashmap
		get_exn(visited.get(graph))
	} else {
		val cloneNode: Node = new Node(graph.value)
		for (neighbor <- graph.neighbors){
			cloneNode.neighbors.::(cloneGraph(neighbor))
		}
		cloneNode
	}
}*/
}