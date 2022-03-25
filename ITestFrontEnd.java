// --== CS400 File Header Information ==--
// Name: Timothy Voelker
// Email: tvoelker@wisc.edu
// Team: ED
// Role: Test Engineer
// TA: Keren Chen
// Lecturer: Florian Heimerl

/**
 * 
 * @author Timothy Voelker
 *
 */
public interface ITestFrontEnd {
    /**
     * Tests if the app can be succesfully quit
     * 
     * @return true if the app is quit successfully
     */
    public void testCanQuit();

    /**
     * Tests that FrontEnd.isValidDate method functions as intended
     * 
     * @return true if the method functions properly; false if it doesn't
     */
    public void testValidDate();

    /**
     * Tests that FrontEnd.isValidEmail method functions as intended
     * 
     * @return true if the method functions properly; false if it doesn't
     */
    public void testValidEmail();
}
