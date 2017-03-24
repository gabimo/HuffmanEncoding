
import java.util.LinkedList;
import java.util.Map;

/**
 * Michael Ellis 
 */

public class Huffman {
	static private Node low1 = null;
	static private Node low2 = null;
	static private LinkedList<Node> nodes = new LinkedList<Node>();
	// Make the nodes and fill out the tree
	static Node createTree(Map<String, Integer> myFrequency) {
		// create a list of the nodes, frequency and value pairs
		for (String key : myFrequency.keySet()) {
			Node newNode = new Node();
			newNode.letter = key; // String
			newNode.value = myFrequency.get(key); // Integer
			newNode.left = null; // Children will be given next
			newNode.right = null;
			nodes.add(newNode); // Add node to list of known nodes
		}
		// fill out the tree
		while (nodes.size() > 1) {
			setLow();
			Node pair = new Node();
			pair.value = low1.value + low2.value;
			pair.left = low1;
			pair.right = low2;
			nodes.add(pair);
			// push or add, both add to list but on different ends
			// nodes.push(pair);
			nodes.remove(low1);
			nodes.remove(low2);
			// make sure the nodes are reset to prevent errors
			low1 = null;
			low2 = null;
		}
		// Return head node of tree, root I guess
		Node n = nodes.getFirst();
		return n;
	}
	// assign two lowest values in nodes list to low1 and low2
	static void setLow() {
		for (Node curr : nodes) {
			if (low1 == null) {
				low1 = curr;
			} else if (low2 == null) {
				low2 = curr;
			} else {
				if (curr.value < low1.value) {
					low1 = curr;
				} else if (curr.value < low2.value) {
					low2 = curr;
				}
			}
		}
		if (low1.value > low2.value) {
			Node temp = low1;
			low1 = low2;
			low2 = temp;
		}
	}
}