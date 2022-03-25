// --== CS400 File Header Information ==--
// Name: Letong Dai
// Email: ldai29@wisc.edu
// Team: ED
// Role: Data Wrangler
// TA: Keren Chen
// Lecturer: Florian Heimerl

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Accesses data from data.txt
 * 
 * @author Letong Dai
 *
 */
public class DataAccess {
	public static final String PATH = "data.txt";

	/**
	 * load data and construct a red black tree
	 * 
	 * @return the red black tree that contains all data
	 * 
	 * @throws IOException
	 */
	public static RedBlackTree<AddressBookEntry> loadData() throws IOException {
		File data = new File(PATH);
		BufferedReader reader = new BufferedReader(new FileReader(data));
		RedBlackTree<AddressBookEntry> entries = new RedBlackTree<AddressBookEntry>();
		String entry = reader.readLine();
		while (entry != null) {
			entries.insert(new AddressBookEntry(entry.trim()));
			entry = reader.readLine();
		}
		reader.close();
		return entries;
	}

	/**
	 * Save all data that are stored in the red black tree
	 * 
	 * @param tree the red black tree that store all data
	 * 
	 * @throws IOException
	 */
	public static void saveData(RedBlackTree<AddressBookEntry> tree) throws IOException {
		File data = new File(PATH);
		if (!data.exists())
			data.createNewFile();
		String allEntries = tree.toString();
		allEntries = allEntries.substring(1, allEntries.length() - 1);
		Pattern entryPattern = Pattern.compile("(\\[.*?\\])");
		Matcher entries = entryPattern.matcher(allEntries);
		BufferedWriter writer = new BufferedWriter(new FileWriter(data));
		while (entries.find()) {
			String entry = entries.group();
			writer.write(entry.substring(1, entry.length() - 1));
			writer.newLine();
			writer.flush();
		}
		writer.close();
	}
}