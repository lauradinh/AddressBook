// --== CS400 File Header Information ==--
// Name: Timothy Voelker
// Email: tvoelker@wisc.edu
// Team: ED
// Role: Test Engineer
// TA: Keren Chen
// Lecturer: Florian Heimerl

public interface ITestDataAccess {
    /**
     * Tests that DataAccess.loadData doesn't throw an exception
     * 
     * @return false if exception is thrown; true if no exception is thrown
     */
    public void testCanLoadData();

    /**
     * Tests that DataAccess.saveData doesn't throw an exception
     * 
     * @return false if exception is thrown; true if no exception is thrown
     */
    public void testCanSaveData();

    /**
     * Tests that DataAccess.saveData changes data file
     * 
     * @return true if data is changed on save; false if data doesn't change
     */
    public void testChangesData();
}