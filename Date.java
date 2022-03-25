// --== CS400 File Header Information ==--
// Name: Letong Dai
// Email: ldai29@wisc.edu
// Team: ED
// Role: Data Wrangler
// TA: Keren Chen
// Lecturer: Florian Heimerl

/**
 * Creates the Date class used for birthdays
 * 
 * @author Letong Dai
 *
 */
public class Date implements Comparable<Date> {
	private int day;
	private int month;
	private int year;

	/**
	 * default constructor
	 */
	public Date() {
	}

	/**
	 * Creates a constructor that uses birthday information
	 * 
	 * @param day   of birth
	 * @param month of birth
	 * @param year  of birth
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * This constructor receive a String which contains all date information
	 * 
	 * @param date - format: month / day / year
	 */
	public Date(String date) {
		String[] info = date.split(" / ");
		this.day = Integer.valueOf(info[1]);
		this.month = Integer.valueOf(info[0]);
		this.year = Integer.valueOf(info[2]);
	}

	/**
	 * Accessor method for day
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Mutator method for day
	 * @param day new day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Accessor method for the month
	 * @return month
	 */
	public int getMonth() {
		return month;
	}
 
	/**
	 * Mutator method for the month
	 * @param month new month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Accessor method for year
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/** 
	 * Mutator method for year
	 * @param year new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Creates a String form the the date
	 * @return format: month / day / year
	 */
	@Override
	public String toString() {
		return month + " / " + day + " / " + year;
	}
	
	/**
	 * Compares two birthdays
	 */
	@Override
	public int compareTo(Date arg0) {
		int c = ((Integer) this.year).compareTo((Integer) arg0.year);
		if (c == 0) {
			c = ((Integer) this.month).compareTo((Integer) arg0.month);
			if (c == 0) {
				c = ((Integer) this.day).compareTo((Integer) arg0.day);
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
	}
}