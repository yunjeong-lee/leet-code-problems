package leetcodefun

import scala.collection.mutable.Queue
import scala.collection.mutable.HashMap
import leetcodefun.local_library._

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

	def cloneGraph(node: Node): Node = {
		// Hash map to save the visited nodes and its clone as key/value
		val visited: HashMap[Node, Node] = new HashMap[Node, Node]()

		if (node == null) {
			return node
		}

		// If the node has already visited before, return the clone from the visited dictionary.
		else if (visited.contains(node)){
			return get_exn(visited.get(node))
		}

		else {
			// Create a clone for the given node (Note no cloned neighbors at this point)
			val cloneNode: Node = new Node(node.value)

			// The key is original node, and the value is the cloned node
			visited.put(node, cloneNode)

			// Iterate over neighbors to generate their clones
			// And add the list of cloned neighbors to the clonedNode
			for (neighbor <- node.neighbors) {
				cloneNode.neighbors = cloneNode.neighbors.::(cloneGraph(neighbor))
			}
			cloneNode
		}


	}

}