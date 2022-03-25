// --== CS400 File Header Information ==--
// Name: Timothy Voelker
// Email: tvoelker@wisc.edu
// Team: ED
// Role: Test Engineer
// TA: Keren Chen
// Lecturer: Florian Heimerl

public interface ITestBackEnd {
    /**
     * Tests that BackEnd.getEntry returns entries known to be in the tree
     * 
     * @return true if expected entries are retrieved; false if not
     */
    public void testCanGetEntry();

    /**
     * Tests that BackEnd.updateEntryName updates AddressBookEntry.name property
     * 
     * @return true if the property is changed; false if it isn't changed
     */
    public void testUpdateEntryName();

    /**
     * Tests that BackEnd.updateEntryAddress updates AddressBookEntry.address
     * property
     * 
     * @return true if the property is changed; false if it isn't changed
     */
    public void testUpdateEntryAddress();

    /**
     * Tests that BackEnd.updateEntryEmail updates AddressBookEntry.email property
     * 
     * @return true if the property is changed; false if it isn't changed
     */
    public void testUpdateEntryEmail();

    /**
     * Tests that BackEnd.updateEntryPhoneNumber updates
     * AddressBookEntry.phoneNumber property
     * 
     * @return true if the property is changed; false if it isn't changed
     */
    public void testUpdateEntryPhoneNumber();

    /**
     * Tests that BackEnd.updateEntryBirthday updates AddressBookEntry.birthday
     * property
     * 
     * @return true if the property is changed; false if it isn't changed
     */
    public void testUpdateEntryBirthday();

    /**
     * Tests that BackEnd.addNewEntry adds a new AddressBookEntry into the tree
     * 
     * @return true new entry is added to the tree; false if it isn't
     */
    public void testAddNewEntry();
}
