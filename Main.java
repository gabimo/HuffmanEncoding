
//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Michael Ellis
 * 
 *  set readFile to desired read-in path
 **/
public class Main {
	// Hard coded file path 
	static String readFile = "input.txt";
	static public LinkedList<Node> letters = new LinkedList<Node>();

	public static void main(String[] args) throws FileNotFoundException {
		try {
			Map<String, Integer> myDictionary = new HashMap<String, Integer>();// frequency
																				// table
			myDictionary = ReadOperations.readFile(readFile);
			String sequence = "";
			Node root = Huffman.createTree(myDictionary);
			printTree(root, sequence, "");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// nothing to free?
		}

	}

	static void printTree(Node node, String sequence, String add) {
		sequence = sequence + add;
		if (node.letter != null) {
			System.out.println(node.letter + ": " + sequence);
		} else {
			printTree(node.left, sequence, "0");
			printTree(node.right, sequence, "1");
		}
	}
}