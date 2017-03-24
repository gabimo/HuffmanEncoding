import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
/**
 *  Michael Ellis 
 * 
 *  ReadOperations objects must be passed a path to an input file
 * 
 * 	Input files should be text file as comma separated values
 * 	Input is read with scanner and String
 * 
 * 	Outputs a Map<String, Integer> Hashtable object
 * 
 */
public class ReadOperations {
	static public Map<String, Integer> readFile(String fileName) throws FileNotFoundException  {
		// frequency chart
		Map<String, Integer> myDictionary = new Hashtable<String, Integer>();
		// read file
		HashSet<String> allUniqueLetters = new HashSet<String>();
		// unique letters list for
		LinkedList<String> currList = new LinkedList<String>();
		// Scanner in reads the file or throws exception
		Scanner in = new Scanner(new FileReader(fileName));
		while (in.hasNext()) {
			// Letter by letter creates frequncy table from .txt file in csv format
			String currLine = in.nextLine();
			String[] nodes = currLine.split(",");
			for (int i = 0; i < nodes.length; i++){
				allUniqueLetters.add(nodes[i]);
			}
			for (String curr : allUniqueLetters) {
				myDictionary.put(curr, 0);
				if (!currList.contains(curr)) {
					currList.push(curr);// unique letters list
				}
			}
			for (int i = 0; i < nodes.length; i++) {
				myDictionary.put(nodes[i], myDictionary.get(nodes[i]) + 1);
			}
		}
		in.close();
		return myDictionary;
	}
}