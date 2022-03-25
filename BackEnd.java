
// --== CS400 File Header Information ==--
// Name: Conrad Wiebe
// Email: cwiebe2@wisc.edu
// Team: ED
// Role: Back End Developer
// TA: Keren Chen
// Lecturer: 
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Creates the Back End implementation
 * 
 * @author Conrad Wiebe
 *
 */
public class BackEnd implements IBackEnd {
	private RedBlackTree<AddressBookEntry> tree;

	/**
	 * Creates the constructor by loading data from data.txt
	 */
	public BackEnd() {
		try {
			tree = DataAccess.loadData();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: Can't load data");
		}
	}

	/**
	 * Gets the entry from the tree using ids
	 * 
	 * @throws NoSuchElementException when id is not found
	 * @return the node's data that contains the id
	 */
	@Override
	public AddressBookEntry getEntry(int entryId) throws NoSuchElementException {
		// Starting at the root of the tree
		RedBlackTree.Node<AddressBookEntry> node = tree.root;

		// Search for the node with id
		while (node != null) {
			if (node.data.getId() == entryId) {
				return node.data;
			}

			// Node's id is greater than root id
			if (node.data.getId() < entryId) {
				// Search right subtree
				node = node.rightChild;
			} else {
				// Search left subtree
				node = node.leftChild;
			}
		}

		throw new NoSuchElementException(String.format("No entry with id = \"%d\"", entryId));
	}

	/**
	 * Shows all entries of the RedBlackTree
	 */
	@Override
	public void showAllEntries() {
		// Use traversal algorithm from RedBlackTree.Node<T>.toString
		LinkedList<RedBlackTree.Node<AddressBookEntry>> q = new LinkedList<>();
		q.add(tree.root);

		while (!q.isEmpty()) {
			RedBlackTree.Node<AddressBookEntry> next = q.removeFirst();

			if (next.leftChild != null)
				q.add(next.leftChild);

			if (next.rightChild != null)
				q.add(next.rightChild);

			System.out.println(next.data);
		}
	}

	/**
	 * Updates the name of entry
	 * 
	 * @param entryID id of entry
	 * @param newName new name of entry
	 * @throws NoSuchElementException   when node with id not found
	 * @throws IllegalArgumentException when incorrect information is entered
	 */
	@Override
	public void updateEntryName(int entryId, String newName) throws NoSuchElementException, IllegalArgumentException {
		// Get the entry
		AddressBookEntry entry = getEntry(entryId);

		// If the entry wasn't found throw a NoSuchElementException
		if (entry == null) {
			throw new NoSuchElementException();
		}

		// Set the name field to the new name
		entry.setName(newName);

		// Save changes to file
		try {
			DataAccess.saveData(tree);
		} catch (IOException e) {
			System.out.println("ERROR: Changes weren't saved");
		}
	}

	/**
	 * Updates the address of entry
	 * 
	 * @param entryId  the id of the entry
	 * @param address  street address of entry
	 * @param city     the city of entry
	 * @param province the province/state of entry
	 * @param country  the country of the entry
	 * @throws NoSuchElementException when entry id not found
	 * 
	 */
	@Override
	public void updateEntryAddress(int entryId, String address, String city, String province, String country)
			throws NoSuchElementException {
		// Get the entry
		AddressBookEntry entry = getEntry(entryId);

		// If the entry wasn't found throw a NoSuchElementException
		if (entry == null) {
			throw new NoSuchElementException();
		}

		// Set the address field to the new address
		entry.setAddress(new Address(address, city, province, country));

		// Save changes to file
		try {
			DataAccess.saveData(tree);
		} catch (IOException e) {
			System.out.println("ERROR: Changes weren't saved");
		}
	}

	/**
	 * Updates the email of entry
	 * 
	 * @param entryId  id of entry
	 * @param newEmail new email of entry
	 * @throws NoSuchElementExpcetion when the id is not found
	 */
	@Override
	public void updateEntryEmail(int entryId, String newEmail) throws NoSuchElementException {
		// Get the entry
		AddressBookEntry entry = getEntry(entryId);

		// If the entry wasn't found throw a NoSuchElementException
		if (entry == null) {
			throw new NoSuchElementException();
		}

		// Set the email field to the new email
		entry.setEmail(newEmail);

		// Save changes to file
		try {
			DataAccess.saveData(tree);
		} catch (IOException e) {
			System.out.println("ERROR: Changes weren't saved");
		}
	}

	/**
	 * Updates the phone number of entry
	 * 
	 * @param entryId        id of entry
	 * @param newPhoneNumber new number of the entry
	 * @throws NoSuchElementException when the id is not found
	 */
	@Override
	public void updateEntryPhoneNumber(int entryId, String newPhoneNumber) throws NoSuchElementException {
		// Get the entry
		AddressBookEntry entry = getEntry(entryId);

		// If the entry wasn't found throw a NoSuchElementException
		if (entry == null) {
			throw new NoSuchElementException();
		}

		// Set the phone number field to the new phone number
		entry.setPhoneNumber(newPhoneNumber);

		// Save changes to file
		try {
			DataAccess.saveData(tree);
		} catch (IOException e) {
			System.out.println("ERROR: Changes weren't saved");
		}
	}

	/**
	 * Updates the entry's birthday
	 * 
	 * @param entryId id of entry
	 * @param day     of birth
	 * @param month   of birth
	 * @param year    of birth
	 * @throws NoSuchElementException when id is not found
	 */
	@Override
	public void updateEntryBirthday(int entryId, int day, int month, int year) throws NoSuchElementException {
		// Get the entry
		AddressBookEntry entry = getEntry(entryId);

		// If the entry wasn't found throw a NoSuchElementException
		if (entry == null) {
			throw new NoSuchElementException();
		}

		// Set the birthday field to the new date
		entry.setBirthday(new Date(day, month, year));

		// Save changes to file
		try {
			DataAccess.saveData(tree);
		} catch (IOException e) {
			System.out.println("ERROR: Changes weren't saved");
		}
	}

	/**
	 * Adds a new entry to the tree
	 * 
	 * @param id            id of entry
	 * @param name          name of entry
	 * @param address       street address of entry
	 * @param city          of entry
	 * @param province      (or state) of entry
	 * @param country       of entry
	 * @param emailAddress  of entry
	 * @param phoneNumber   number of entry
	 * @param birthdayDay   of entry
	 * @param birthdayMonth of entry
	 * @param birthdayYear  of entry
	 * @throws IllegalArgumentException when an entry with id is found
	 */
	@Override
	public void addNewEntry(int id, String name, String address, String city, String province, String country,
			String emailAddress, String phoneNumber, int birthdayDay, int birthdayMonth, int birthdayYear)
			throws IllegalArgumentException {
		try {
			// If an entry with id is found
			getEntry(id);
			throw new IllegalArgumentException();
		} catch (NoSuchElementException e) {
			// Working as intended
		}	

		// Create Address object for entry
		Address newEntryAddress = new Address(address, city, province, country);

		// Create Date object for entry's birthday
		Date newEntryBirthday = new Date(birthdayDay, birthdayMonth, birthdayYear);

		// Create new entry object
		AddressBookEntry newEntry = new AddressBookEntry(id, name, newEntryAddress, emailAddress, phoneNumber,
				newEntryBirthday);

		// Insert new entry into the tree
		tree.insert(newEntry);

		// Save changes to file
		try {
			DataAccess.saveData(tree);
		} catch (IOException e) {
			System.out.println("ERROR: Changes weren't saved");
		}
	}
}