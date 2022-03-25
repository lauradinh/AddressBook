
// --== CS400 File Header Information ==--
// Name: Conrad Wiebe
// Email: cwiebe2@wisc.edu
// Team: ED
// Role: Back End Developer
// TA: Keren Chen
// Lecturer:
import java.util.NoSuchElementException;

/**
 * Interface for BackEnd.java
 * 
 * @author Conrad Wiebe
 *
 */
public interface IBackEnd {
	/**
	 * Gets the entry from the tree using ids
	 * 
	 * @throws NoSuchElementException when id is not found
	 * @return the node's data that contains the id
	 */
	public AddressBookEntry getEntry(int entryId) throws NoSuchElementException;

	/**
	 * Shows all entries of the RedBlackTree
	 */
	public void showAllEntries();

	/**
	 * Updates the name of entry
	 * 
	 * @param entryID id of entry
	 * @param newName new name of entry
	 * @throws NoSuchElementException   when node with id not found
	 * @throws IllegalArgumentException when incorrect information is entered
	 */
	public void updateEntryName(int entryId, String newName) throws NoSuchElementException, IllegalArgumentException;

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
	public void updateEntryAddress(int entryId, String address, String city, String province, String country)
			throws NoSuchElementException;

	/**
	 * Updates the email of entry
	 * 
	 * @param entryId  id of entry
	 * @param newEmail new email of entry
	 * @throws NoSuchElementExpcetion when the id is not found
	 */
	public void updateEntryEmail(int entryId, String newEmail) throws NoSuchElementException;

	/**
	 * Updates the phone number of entry
	 * 
	 * @param entryId        id of entry
	 * @param newPhoneNumber new number of the entry
	 * @throws NoSuchElementException when the id is not found
	 */
	public void updateEntryPhoneNumber(int entryId, String newPhoneNumber) throws NoSuchElementException;

	/**
	 * Updates the entry's birthday
	 * 
	 * @param entryId id of entry
	 * @param day     of birth
	 * @param month   of birth
	 * @param year    of birth
	 * @throws NoSuchElementException when id is not found
	 */
	public void updateEntryBirthday(int entryId, int day, int month, int year) throws NoSuchElementException;

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
	public void addNewEntry(int id, String name, String address, String city, String province, String country,
			String emailAddress, String phoneNumber, int birthdayDay, int birthdayMonth, int birthdayYear);
}
