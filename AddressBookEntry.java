// --== CS400 File Header Information ==--
// Name: Letong Dai
// Email: ldai29@wisc.edu
// Team: ED
// Role: Data Wrangler
// TA: Keren Chen
// Lecturer: Florian Heimerl

/**
 * Creates the AddressBookEntry class which is stored in the RedBlackTree
 * 
 * @author Letong Dai
 *
 */
public class AddressBookEntry implements Comparable<AddressBookEntry> {
	private String name;
	private Address address;
	private String email;
	private String phoneNumber;
	private Date birthday;
	private int id;

	/**
	 * default constructor
	 */
	public AddressBookEntry() {
	}

	/**
	 * This constructor
	 * 
	 * @param id
	 * @param name
	 * @param address
	 * @param email
	 * @param phoneNumber
	 * @param birthday
	 */
	public AddressBookEntry(int id, String name, Address address, String email, String phoneNumber, Date birthday) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	/**
	 * This constructor receive a String which contains all date information
	 * 
	 * @param date - format: name, address - city - province - country, email, phone
	 *             number, month / day / year
	 */
	public AddressBookEntry(String entry) {
		String[] info = entry.split(", ");
		this.id = Integer.valueOf(info[0]);
		this.name = info[1];
		this.address = new Address(info[2]);
		this.email = info[3];
		this.phoneNumber = info[4];
		this.birthday = new Date(info[5]);
	}

	/**
	 * Accessor method for name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mutator metod for name
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Accessor method for address
	 * @return address 
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Mutator method for address
	 * @param address new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Accessor method for email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Mutator method for email
	 * @param email new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Accessor method for phone number
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Mutator method for phone number
	 * @param phoneNumber new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Accessor method for birthday
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Mutator method for birthday 
	 * @param birthday new birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * Accessor method for Id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Mutator method for Id
	 * @param newId new Id
	 */
	public void setId(int newId) {
		id = newId;
	}

	/**
	 * Creates a string of all the information of entry
	 * 
	 * @return format: name, address - city - province - country, email, phone
	 *         number, month / day / year
	 */
	@Override
	public String toString() {
		return "[" + id + ", " + name + ", " + address.toString() + ", " + email + ", " + phoneNumber + ", "
				+ birthday.toString() + "]";
	}

	/**
	 * Compares the entries IDs
	 */
	@Override
	public int compareTo(AddressBookEntry other) {
		return id - other.getId();
	}
}
