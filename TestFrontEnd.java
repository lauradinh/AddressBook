//// --== CS400 File Header Information ==--
//// Name: Timothy Voelker
//// Email: tvoelker@wisc.edu
//// Team: ED
//// Role: Test Engineer
//// TA: Keren Chen
//// Lecturer: Florian Heimerl
//
//import static org.junit.Assert.*;
//
//import org.junit.jupiter.api.Test;
//
//public class TestFrontEnd implements ITestFrontEnd {
//
//    @Override
//    @Test
//    public void testCanQuit() {
//        try {
//            // Starts app
//            FrontEnd.main(null);
//        }
//        // If any uncaught exceptions are found
//        catch (Exception e) {
//            e.printStackTrace();
//            // App doesn't close successfully
//            fail("App didn't close properly");
//        }
//    }
//
//    @Override
//    @Test
//    public void testValidDate() {
//        // Checks negative day, month, year
//        assertFalse(IFrontEnd.isValidDate(-1, -1, -1));
//
//        // Checks that 30th of Februrary is invalid
//        assertFalse(IFrontEnd.isValidDate(30, 2, 2020));
//
//        // Checks that 1st of January, 1970 is valid
//        assertTrue(IFrontEnd.isValidDate(1, 1, 1970));
//
//        // Checks that 1st of January, 1 is valid
//        assertTrue(IFrontEnd.isValidDate(1, 1, 1));
//    }
//
//    @Override
//    @Test
//    public void testValidEmail() {
//        // Handles null check
//        assertFalse(IFrontEnd.isValidEmail(null));
//
//        // Handles non-conforming string
//        assertFalse(IFrontEnd.isValidEmail("hello, world"));
//
//        // Out of order check
//        assertFalse(IFrontEnd.isValidEmail("example.com@test"));
//
//        // Missing domain name check
//        assertFalse(IFrontEnd.isValidEmail("test@.com"));
//
//        // Recognizes valid email check
//        assertTrue(IFrontEnd.isValidEmail("test@example.com"));
//
//        // Checks that it recognizes a valid email with extra whitespace around it
//        assertTrue(IFrontEnd.isValidEmail("   test@example.com     "));
//        assertTrue(IFrontEnd.isValidEmail("   test@example.com"));
//        assertTrue(IFrontEnd.isValidEmail("test@example.com   "));
//    }
//}
