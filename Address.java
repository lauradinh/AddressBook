// --== CS400 File Header Information ==--
// Name: Letong Dai
// Email: ldai29@wisc.edu
// Team: ED
// Role: Data Wrangler
// TA: Keren Chen
// Lecturer: Florian Heimerl

/**
 * Creates Address class
 * 
 * @author Letong Dai
 *
 */
public class Address implements Comparable<Address> {
	private String address;
	private String city;
	private String province;
	private String country;

	/**
	 * default constructor
	 */
	public Address() {
	}

	/**
	 * constructor that holds address information
	 * 
	 * @param address  street address
	 * @param city     city of address
	 * @param province province/state of address
	 * @param country  country of address
	 */
	public Address(String address, String city, String province, String country) {
		this.address = address;
		this.city = city;
		this.province = province;
		this.country = country;
	}

	/**
	 * This constructor receive a String which contains all address information
	 * 
	 * @param address - format: address, city, province, country
	 */
	public Address(String address) {
		String[] info = address.split(" - ");
		this.address = info[0];
		this.city = info[1];
		this.province = info[2];
		this.country = info[3];
	}

	/**
	 * Accessor method of address
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Mutator method of address
	 * 
	 * @param address new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Accessor method of city
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Mutator method of city
	 * 
	 * @param city new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Accessor method of province
	 * 
	 * @return province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Mutator method of province
	 * 
	 * @param province new province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * Accessor method of country
	 * 
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Mutator method of country
	 * 
	 * @param country new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Prints the Address
	 * 
	 * @return format: address - city - province - country
	 */
	@Override
	public String toString() {
		return address + " - " + city + " - " + province + " - " + country;
	}

	@Override
	public int compareTo(Address arg0) {
		int c = this.country.compareTo(arg0.country);
		if (c == 0) {
			c = this.province.compareTo(arg0.province);
			if (c == 0) {
				c = this.city.compareTo(arg0.city);
				if (c == 0) {
					c = this.address.compareTo(arg0.address);
					if (c == 0) {
						return 0;
					} else {
						return c;
					}
				} else {
					return c;
				}

			} else {
				return c;
			}
		} else {
			return c;
		}
	}
}